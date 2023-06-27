package org.feather.train.member.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import jakarta.annotation.Resource;
import org.feather.train.common.exception.BusinessException;
import org.feather.train.common.exception.BusinessExceptionEnum;
import org.feather.train.common.utils.SnowUtil;
import org.feather.train.member.domain.Member;
import org.feather.train.member.domain.MemberExample;
import org.feather.train.member.mapper.MemberMapper;
import org.feather.train.member.req.MemberRegisterReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @projectName: train
 * @package: org.feather.train.member.service
 * @className: MemberService
 * @author: feather
 * @description: TODO
 * @since: 2023-06-26 20:55
 * @version: 1.0
 */
@Service
public class MemberService {
    private static final Logger LOG = LoggerFactory.getLogger(MemberService.class);
    @Resource
    private MemberMapper memberMapper;

    public  int count(){
        return Math.toIntExact( memberMapper.countByExample(null));
    }

    public long register(MemberRegisterReq req) {
        String mobile = req.getMobile();
        Member memberDB = selectByMobile(mobile);

        if (ObjectUtil.isNull(memberDB)) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }

        Member member = new Member();
        member.setId(SnowUtil.getSnowflakeNextId());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }
    private Member selectByMobile(String mobile) {
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);
        if (CollUtil.isEmpty(list)) {
            return null;
        } else {
            return list.get(0);
        }
    }
}
