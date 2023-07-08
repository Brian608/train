package org.feather.train.member.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.feather.train.common.context.LoginMemberContext;
import org.feather.train.common.resp.PageResp;
import org.feather.train.common.utils.SnowUtil;
import org.feather.train.member.domain.Passenger;
import org.feather.train.member.domain.PassengerExample;
import org.feather.train.member.mapper.PassengerMapper;
import org.feather.train.member.req.PassengerQueryReq;
import org.feather.train.member.req.PassengerSaveReq;
import org.feather.train.member.resp.PassengerQueryResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @projectName: train
 * @package: org.feather.train.member.service
 * @className: PassengerService
 * @author: feather
 * @description: TODO
 * @since: 2023-07-03 21:00
 * @version: 1.0
 */
@Service
public class PassengerService {

    private static final Logger LOG = LoggerFactory.getLogger(PassengerService.class);
    @Resource
    private PassengerMapper passengerMapper;


   public void savePassenger(PassengerSaveReq req){
       DateTime now = DateTime.now();
       Passenger passenger = BeanUtil.copyProperties(req, Passenger.class);
       passenger.setId(SnowUtil.getSnowflakeNextId());
       passenger.setMemberId(LoginMemberContext.getId());
       passenger.setCreateTime(now);
       passenger.setUpdateTime(now);
       passengerMapper.insert(passenger);
   }

    public PageResp<PassengerQueryResp> queryList(PassengerQueryReq req) {
        PassengerExample passengerExample = new PassengerExample();
        passengerExample.setOrderByClause("id desc");
        PassengerExample.Criteria criteria = passengerExample.createCriteria();
        if (ObjectUtil.isNotNull(req.getMemberId())) {
            criteria.andMemberIdEqualTo(req.getMemberId());
        }

        LOG.info("查询页码：{}", req.getPage());
        LOG.info("每页条数：{}", req.getSize());
        PageHelper.startPage(req.getPage(), req.getSize());
        List<Passenger> passengerList = passengerMapper.selectByExample(passengerExample);

        PageInfo<Passenger> pageInfo = new PageInfo<>(passengerList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

        List<PassengerQueryResp> list = BeanUtil.copyToList(passengerList, PassengerQueryResp.class);

        PageResp<PassengerQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }
}
