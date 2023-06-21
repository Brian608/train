package org.feather.train.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: train
 * @package: org.feather.train.member.controller
 * @className: TestController
 * @author: feather
 * @description: TODO
 * @since: 2023-06-21 21:04
 * @version: 1.0
 */
@RestController
public class TestController {

    @GetMapping("/hello")
    public String test(){
        return  "hello word";
    }
}
