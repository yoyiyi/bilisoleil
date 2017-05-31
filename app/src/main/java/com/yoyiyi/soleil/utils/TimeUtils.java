package com.yoyiyi.soleil.utils;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/31 15:51
 * 描述:
 */

public class TimeUtils {

    public static String long2String(String time) {
        Integer integer = Integer.valueOf(time);
        StringBuffer buffer = new StringBuffer();
        int minute = integer / 60;
        int second = integer % 60;
        if (minute < 10) {
            buffer.append("0" + minute);
        } else {
            buffer.append(minute);
        }
        buffer.append(":");
        if (second < 10) {
            buffer.append("0" + second);
        } else {
            buffer.append(second);
        }
        return buffer.toString();
    }
}
