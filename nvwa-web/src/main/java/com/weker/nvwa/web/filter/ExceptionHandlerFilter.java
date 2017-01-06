package com.weker.nvwa.web.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.weker.nvwa.biz.exception.BizException;
import com.weker.nvwa.common.model.CommonCode;
import com.weker.nvwa.common.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 异常处理
 *
 * @author jiuxin.zhang@cgtz.com
 * @since 07/12/2016
 */
public class ExceptionHandlerFilter extends OncePerRequestFilter {

    static Logger logger = LoggerFactory.getLogger(ExceptionHandlerFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {

            filterChain.doFilter(request, response);

        } catch (Throwable e) {
            response.setStatus(HttpStatus.OK.value());
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

            Response result ;
            if (e instanceof BizException) {
                BizException be = (BizException) e;
                if (logger.isInfoEnabled()) {
                    logger.info(be.getMessage(), e);
                }
                result = Response.wrapError(be.getCode());
            } else if (e.getCause() instanceof BizException) {
                BizException be = (BizException) e.getCause();
                if (logger.isInfoEnabled()) {
                    logger.info(be.getMessage(), e);
                }
                result = Response.wrapError(be.getCode());
            } else {
                logger.error("系统异常：", e);
                result = Response.wrapError(CommonCode.FAILURE);
            }

            response.getWriter().write(JSON.toJSONString(result, SerializerFeature.WriteMapNullValue));
        }
    }
}
