package com.weker.nvwa.common.util;

import com.google.common.base.Strings;

import java.util.regex.Pattern;

/**
 * 匹配器
 *
 * @author jiuxin.zhang@cgtz.com
 * @since 14/12/2016
 */
public class MatcherUtils {

    /**
     * 手机格式正则
     */
    private final static String MOBILE_REGEX    = "^[1][3,5,7,8][0-9]{9}$";

    /**
     * 房间号正则
     */
    private final static String ROOM_NO_REGEX   = "\\d{1,2}0\\d";

    /**
     * 姓名正则
     */
    private final static String REALNAME_REGEX  = "^([\\u4e00-\\u9fa5]{1,20}|[a-zA-Z\\.\\s]{1,20})$";

    /**
     * 是否为手机号
     *
     * @param mobile    手机号码
     */
    public static boolean isMobile(String mobile) {
        if (Strings.isNullOrEmpty(mobile)) {
            return false;
        }
        return Pattern.compile(MOBILE_REGEX).matcher(mobile).matches();
    }

    /**
     * 是否为房间号
     *
     * @param roomNo    房间号
     */
    public static boolean isRoomNo(String roomNo) {
        if (Strings.isNullOrEmpty(roomNo)) {
            return false;
        }
        return Pattern.compile(ROOM_NO_REGEX).matcher(roomNo).matches();
    }

    /**
     * 是否为姓名
     *
     * @param name      名称
     */
    public static boolean isRealname(String name) {
        if (Strings.isNullOrEmpty(name)) {
            return false;
        }
        return Pattern.compile(REALNAME_REGEX).matcher(name).matches();
    }
}
