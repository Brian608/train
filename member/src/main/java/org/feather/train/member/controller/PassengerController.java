package org.feather.train.member.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.feather.train.common.resp.CommonResp;
import org.feather.train.member.req.PassengerSaveReq;
import org.feather.train.member.service.PassengerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: train
 * @package: org.feather.train.member.controller
 * @className: PassengerController
 * @author: feather
 * @description: TODO
 * @since: 2023-07-04 8:16
 * @version: 1.0
 */
@RestController
@RequestMapping("/passenger")
public class PassengerController {
    @Resource
    private PassengerService passengerService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody PassengerSaveReq req) {
        passengerService.savePassenger(req);
        return new CommonResp<>();
    }
}
