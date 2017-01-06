package com.weker.nvwa.web.filter;

/**
 * filter 执行先后顺序
 *
 * @author jiuxin.zhang@cgtz.com
 * @since 07/12/2016
 */
public enum FilterOrdered {

    /**
     * 异常处理
     */
    EXCEPTION_HANDLER_FILTER,

    /**
     * 登录
     */
    SSO_FILTER,

    /**
     * 权限验证
     */
    OAUTH_FILTER
}
