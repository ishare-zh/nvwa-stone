package com.weker.nvwa.common.util;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * 封装UUID，生成唯一字符串标识
 *
 * @author jiuxin.zhang@cgtz.com
 * @since 09/12/2016
 */
public class UUIDGenerator {

    private static SecureRandom random = new SecureRandom();

    /**
     * 封装JDK自带的UUID算法，生成唯一标识串
     * 去除 "-"
     *
     * @return
     */
    public static String uuid() {

        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 利用SecureRandom随机生成Long类型整数
     *
     * @return
     */
    public static Long uuidLong() {

        return Math.abs(random.nextLong());
    }
}
