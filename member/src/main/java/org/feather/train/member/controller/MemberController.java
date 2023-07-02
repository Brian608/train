package org.feather.train.member.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.feather.train.common.resp.CommonResp;
import org.feather.train.member.req.MemberLoginReq;
import org.feather.train.member.req.MemberRegisterReq;
import org.feather.train.member.req.MemberSendCodeReq;
import org.feather.train.member.resp.MemberLoginResp;
import org.feather.train.member.service.MemberService;
import org.springframework.web.bind.annotation.*;

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
    public CommonResp<Integer> count(){
        return new CommonResp<>(memberService.count());
    }



    @PostMapping("/register")
    public CommonResp<Long> register(@Valid  @RequestBody MemberRegisterReq req) {
        return new CommonResp<>(memberService.register(req));
    }

    @PostMapping("/send-code")
    public CommonResp<Long> sendCode(@Valid @RequestBody MemberSendCodeReq req) {
        memberService.sendCode(req);
        return new CommonResp<>();
    }
    @PostMapping("/login")
    public CommonResp<MemberLoginResp> login(@Valid @RequestBody MemberLoginReq req) {
        MemberLoginResp resp = memberService.login(req);
        return new CommonResp<>(resp);
    }

}
