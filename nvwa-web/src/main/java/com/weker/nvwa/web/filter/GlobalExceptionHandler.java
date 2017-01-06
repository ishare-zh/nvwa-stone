package com.weker.nvwa.web.filter;

import com.weker.nvwa.biz.exception.BizException;
import com.weker.nvwa.common.model.CommonCode;
import com.weker.nvwa.common.model.Response;
import com.weker.nvwa.web.util.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;

/**
 * 处理spring全局异常信息
 *
 * @author jiuxin.zhang@cgtz.com
 * @since 27/12/2016
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Throwable.class)
    public Response<Void> handle(HttpServletRequest request, Throwable t) throws Exception {
        if (t instanceof BizException) {
            BizException be = (BizException) t;
            return Response.wrapError(be.getCode());
        } else if (t.getCause() instanceof BizException) {
            BizException be = (BizException) t.getCause();
            return Response.wrapError(be.getCode());
        }
        if (logger.isInfoEnabled()) {
            logger.info(buildErrorMsg(request), t);
        }
        return Response.wrapError(CommonCode.FAILURE);
    }

    private String buildErrorMsg(HttpServletRequest request) {
        return MessageFormat.format("系统异常，IP: {0}, isRobot: {1}, URL: {2}, Refer: {3}",
                RequestUtils.getRemoteAddr(request),
                RequestUtils.isRobot(request),
                request.getRequestURL().toString(),
                RequestUtils.getRefer(request));
    }
}
