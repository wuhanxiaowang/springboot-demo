package com.github.mall.util;

import org.apache.commons.lang.StringUtils;

/**
 * @Auther: wy
 * @Date: 2020/2/29 09:43
 * @Description:
 */
public class CreateNumber {
    static String PRE = "ABC-";

    public static String getNumber(String num) {
        String number = null;
        String s = StringUtils.substringAfter(num, "-");
        int i = Integer.parseInt(s);
        int next = i + 1;
        number = PRE + String.format("%04d", next);
        return number;
    }
}
