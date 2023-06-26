package org.feather.train.member.service;

import cn.hutool.core.collection.CollectionUtil;
import jakarta.annotation.Resource;
import org.feather.train.member.domain.Member;
import org.feather.train.member.domain.MemberExample;
import org.feather.train.member.mapper.MemberMapper;
import org.feather.train.member.req.MemberRegisterReq;
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
    @Resource
    private MemberMapper memberMapper;

    public  int count(){
        return Math.toIntExact( memberMapper.countByExample(null));
    }

    public  long  register(MemberRegisterReq req){
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> memberList = memberMapper.selectByExample(memberExample);
        if (CollectionUtil.isNotEmpty(memberList)){

        }
        Member member=new Member();
        member.setId(System.currentTimeMillis());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return  member.getId();
    }
}
