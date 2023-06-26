package org.feather.train.member.service;

import jakarta.annotation.Resource;
import org.feather.train.member.mapper.MemberMapper;
import org.springframework.stereotype.Service;

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
        return memberMapper.count();
    }
}
