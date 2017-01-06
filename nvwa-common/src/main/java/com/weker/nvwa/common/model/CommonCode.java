package com.weker.nvwa.common.model;

/**
 * 通用业务处理代码
 *
 * @author jiuxin.zhang@cgtz.com
 * @since 08/12/2016
 */
public enum CommonCode implements Code {
    SUCCESS(200, "成功"),
    FAILURE(500, "失败");

    /**
     * 业务码
     */
    private int    code;

    /**
     * 提示
     */
    private String message;

    CommonCode(int code, String message) {
        this.code    = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
