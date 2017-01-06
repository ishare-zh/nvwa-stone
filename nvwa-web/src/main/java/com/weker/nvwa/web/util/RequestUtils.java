package com.weker.nvwa.web.util;

import com.google.common.base.Strings;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletRequest;

/**
 * http request 请求工具类
 *
 * @author jiuxin.zhang@cgtz.com
 * @since 27/12/2016
 */
public class RequestUtils {

    /**
     * 获取客户端id地址
     *
     */
    public static String getRemoteAddr(HttpServletRequest req) {
        String ipStr = req.getHeader("X-Forwarded-For");
        if (!Strings.isNullOrEmpty(ipStr)) {
            String[] ips = ipStr.split(",");
            if (!ArrayUtils.isEmpty(ips)) {
                for (String ip : ips) {
                    if (Strings.isNullOrEmpty(ip))
                        continue;

                    ip = ip.trim();
                    if (isIPAddr(ip) && !ip.startsWith("10.") && !ip.startsWith("192.168.") && !"127.0.0.1".equals(ip)) {
                        return ip.trim();
                    }
                }
            }
        }

        ipStr = req.getHeader("x-real-ip");
        if (isIPAddr(ipStr)) {
            return ipStr;
        }

        ipStr = req.getRemoteAddr();
        if (ipStr.indexOf('.') == -1) {
            ipStr = "127.0.0.1";
        }
        return ipStr;
    }

    /**
     * 判断是否为搜索引擎
     * 
     */
    public static boolean isRobot(HttpServletRequest req) {
        String agent = req.getHeader(HttpHeaders.USER_AGENT);
        return !Strings.isNullOrEmpty(agent)
                &&
                (agent.contains("Baiduspider") 
                        || agent.contains("Googlebot") 
                        || agent.contains("sogou") 
                        || agent.contains("sina") 
                        || agent.contains("iaskspider") 
                        || agent.contains("ia_archiver") 
                        || agent.contains("Sosospider") 
                        || agent.contains("YoudaoBot") 
                        || agent.contains("yahoo") 
                        || agent.contains("yodao") 
                        || agent.contains("MSNBot") 
                        || agent.contains("spider") 
                        || agent.contains("Twiceler") 
                        || agent.contains("Sosoimagespider") 
                        || agent.contains("naver.com/robots") 
                        || agent.contains("Nutch") 
                        || agent.contains("spider") );
    }

    private static boolean isIPAddr(String ip) {
        if (Strings.isNullOrEmpty(ip)) {
            return false;
        }
        String[] ips = ip.split("\\.");
        if (ips.length != 4) {
            return false;
        }

        try {
            int ipa = Integer.parseInt(ips[0]);
            int ipb = Integer.parseInt(ips[1]);
            int ipc = Integer.parseInt(ips[2]);
            int ipd = Integer.parseInt(ips[3]);
            return ipa >= 0 && ipa <= 255 && ipb >= 0 && ipb <= 255 && ipc >= 0
                    && ipc <= 255 && ipd >= 0 && ipd <= 255;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取refer
     *
     */
    public static String getRefer(HttpServletRequest req) {
        return req.getHeader(HttpHeaders.REFERER);
    }
}
