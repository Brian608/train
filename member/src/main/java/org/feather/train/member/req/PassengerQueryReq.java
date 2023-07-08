package org.feather.train.member.req;

import org.feather.train.common.req.PageReq;

/**
 * @projectName: train
 * @package: org.feather.train.member.req
 * @className: PassengerQueryReq
 * @author: feather
 * @description: TODO
 * @since: 2023-07-08 8:32
 * @version: 1.0
 */

public class PassengerQueryReq    extends PageReq {
    private Long memberId;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PassengerQueryReq{");
        sb.append("memberId=").append(memberId);
        sb.append('}');
        return sb.toString();
    }
}
