package com.weker.nvwa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 服务启动类
 *
 * @author jiuxin.zhang@cgtz.com
 * @since 06/01/2017
 */
@SpringBootApplication(scanBasePackages = "com.weker.nvwa")
@ServletComponentScan
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1200)
@ImportResource({
        "classpath:datasource.xml",
        "classpath:oss.xml",
        "classpath:spring-aop.xml",
        "classpath:dubbo-provider.xml" })
public class BootStarp {

    public static void main(String[] args) {
        SpringApplication.run(BootStarp.class);
    }
}
