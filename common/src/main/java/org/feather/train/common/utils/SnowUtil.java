package org.feather.train.common.utils;

import cn.hutool.core.util.IdUtil;

/**
 * @projectName: train
 * @package: org.feather.train.common.utils
 * @className: SnowUtil
 * @author: feather
 * @description: 封装hutool雪花算法
 * @since: 2023-06-27 22:49
 * @version: 1.0
 */



public class SnowUtil {

    private static long dataCenterId = 1;  //数据中心
    private static long workerId = 1;     //机器标识

    public static long getSnowflakeNextId() {
        return IdUtil.getSnowflake(workerId, dataCenterId).nextId();
    }

    public static String getSnowflakeNextIdStr() {
        return IdUtil.getSnowflake(workerId, dataCenterId).nextIdStr();
    }
}
