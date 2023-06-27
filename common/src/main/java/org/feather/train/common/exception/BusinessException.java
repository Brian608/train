package org.feather.train.common.exception;

/**
 * @projectName: train
 * @package: org.feather.train.common.exception
 * @className: BusinessException
 * @author: feather
 * @description: TODO
 * @since: 2023-06-27 21:54
 * @version: 1.0
 */

public class BusinessException extends RuntimeException {

    private BusinessExceptionEnum e;

    public BusinessException(BusinessExceptionEnum e) {
        this.e = e;
    }

    public BusinessExceptionEnum getE() {
        return e;
    }

    public void setE(BusinessExceptionEnum e) {
        this.e = e;
    }

    /**
     * 不写入堆栈信息，提高性能
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

}

