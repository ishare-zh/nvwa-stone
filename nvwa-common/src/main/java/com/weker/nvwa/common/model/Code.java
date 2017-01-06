package com.weker.nvwa.common.model;

/**
 * 通用Rest API响应码
 *
 * @author jiuxin.zhang@cgtz.com
 * @since 08/12/2016
 */
public interface Code {

    /**
     * 业务处理代码
     */
    int getCode();

    /**
     * 业务处理对应提示
     */
    String getMessage();
}
