package org.feather.train.member.controller;

import jakarta.annotation.Resource;
import org.feather.train.member.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: train
 * @package: org.feather.train.member.controller
 * @className: MemberController
 * @author: feather
 * @description: TODO
 * @since: 2023-06-26 20:57
 * @version: 1.0
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource
    private MemberService memberService;

    @GetMapping("/count")
    public  Integer count(){return memberService.count();}

}
