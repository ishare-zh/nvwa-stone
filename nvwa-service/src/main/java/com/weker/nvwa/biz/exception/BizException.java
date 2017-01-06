package com.weker.nvwa.biz.exception;

import com.weker.nvwa.common.model.Code;
import lombok.Getter;

/**
 * 业务异常
 *
 * @author jiuxin.zhang@cgtz.com
 * @since 08/12/2016
 */
public class BizException extends RuntimeException {

    @Getter
    private Code code;

    public BizException(String message) {
        super(message);
    }

    public BizException(Code code) {
        this(code.getMessage());
        this.code = code;
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Code code, Throwable cause) {
        this(code.getMessage(), cause);
        this.code = code;
    }
}
