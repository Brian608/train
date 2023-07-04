package org.feather.train.member.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import jakarta.annotation.Resource;
import org.feather.train.common.utils.SnowUtil;
import org.feather.train.member.domain.Passenger;
import org.feather.train.member.mapper.PassengerMapper;
import org.feather.train.member.req.PassengerSaveReq;
import org.springframework.stereotype.Service;

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
    @Resource
    private PassengerMapper passengerMapper;


   public void savePassenger(PassengerSaveReq req){
       DateTime now = DateTime.now();
       Passenger passenger = BeanUtil.copyProperties(req, Passenger.class);
       passenger.setId(SnowUtil.getSnowflakeNextId());
       passenger.setCreateTime(now);
       passenger.setUpdateTime(now);
       passengerMapper.insert(passenger);
   }
}
