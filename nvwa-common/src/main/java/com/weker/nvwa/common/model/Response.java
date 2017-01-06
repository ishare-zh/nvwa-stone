package com.weker.nvwa.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用Rest API结果实例
 *
 * @author jiuxin.zhang@cgtz.com
 * @since 08/12/2016
 */
@Data
public class Response<D> implements Serializable {

    private static final long serialVersionUID = 6047936162793064349L;

    /**
     * 数据
     */
    private D data;

    /**
     * 业务代码
     */
    private int code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 业务是否正常处理
     */
    private boolean success;

    public static <D> Response<D> wrapSuccess() {
        return wrapSuccess(null, null);
    }

    public static <D> Response<D> wrapSuccess(String message) {
        return wrapSuccess(null, message);
    }

    public static <D> Response<D> wrapSuccess(D data) {
        return wrapSuccess(data, null);
    }

    public static <D> Response<D> wrapSuccess(D data, String message) {
        Response<D> response = new Response<>();

        response.success = true;
        response.code    = CommonCode.SUCCESS.getCode();
        response.data    = data;
        response.message = message;

        return response;
    }

    public static <D> Response<D> wrapError(String message) {
        return wrapError(CommonCode.FAILURE.getCode(), message);
    }

    public static <D> Response<D> wrapError(Code code) {
        return wrapError(code.getCode(), code.getMessage());
    }

    public static <D> Response<D> wrapError(int code, String message) {
        Response<D> response = new Response<>();

        response.success = false;
        response.code    = code;
        response.data    = null;
        response.message = message;

        return response;
    }

}
