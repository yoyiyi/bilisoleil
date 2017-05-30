package com.yoyiyi.soleil.utils;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/21 23:11
 * 描述:装换
 */
public class NumberUtils {
    public static String format   (String num) {
        Integer integer = Integer.valueOf(num);
        if (integer < 10000) {
            return String.valueOf(num);
        }
        String unit = "万";
        double newNum = integer / 10000.0;
        String numStr = String.format("%." + 1 + "f", newNum);
        return numStr + unit;
    }
}
