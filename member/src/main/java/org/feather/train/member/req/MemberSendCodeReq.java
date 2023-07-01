package org.feather.train.member.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * @projectName: train
 * @package: org.feather.train.member.req
 * @className: MemberSendCodeReq
 * @author: feather
 * @description: TODO
 * @since: 2023-07-02 7:37
 * @version: 1.0
 */

public class MemberSendCodeReq {
    @NotBlank(message = "【手机号】不能为空")
    @Pattern(regexp = "^1\\d{10}$", message = "手机号码格式错误")
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "MemberSendCodeReq{" +
                "mobile='" + mobile + '\'' +
                '}';
    }
}
