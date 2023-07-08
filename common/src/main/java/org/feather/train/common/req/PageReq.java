package org.feather.train.common.req;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

/**
 * @projectName: train
 * @package: org.feather.train.common.req
 * @className: PageReq
 * @author: feather
 * @description: TODO
 * @since: 2023-07-08 8:35
 * @version: 1.0
 */

public class PageReq {
    @NotNull(message = "【页码】不能为空")
    private Integer page;

    @NotNull(message = "【每页条数】不能为空")
    @Max(value = 100, message = "【每页条数】不能超过100")
    private Integer size;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "PageReq{" +
                "page=" + page +
                ", size=" + size +
                '}';
    }
}
