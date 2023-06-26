package org.feather.train.member.req;

/**
 * @projectName: train
 * @package: org.feather.train.member.req
 * @className: MemberRegisterReq
 * @author: feather
 * @description: TODO
 * @since: 2023-06-26 21:50
 * @version: 1.0
 */

public class MemberRegisterReq {
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "MemberRegisterReq{" +
                "mobile='" + mobile + '\'' +
                '}';
    }
}
