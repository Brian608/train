package org.feather.train.common.resp;

import java.io.Serializable;
import java.util.List;

/**
 * @projectName: train
 * @package: org.feather.train.common.resp
 * @className: PageResp
 * @author: feather
 * @description: TODO
 * @since: 2023-07-08 8:40
 * @version: 1.0
 */

public class PageResp<T> implements Serializable {

    /**
     * 总条数
     */
    private Long total;

    /**
     * 当前页的列表
     */
    private List<T> list;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageResp{" +
                "total=" + total +
                ", list=" + list +
                '}';
    }
}
