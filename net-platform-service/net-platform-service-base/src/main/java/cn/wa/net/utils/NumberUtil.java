package cn.wa.net.utils;

import java.text.DecimalFormat;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.math.RandomUtils;


public class NumberUtil {

    /**
     * 返回一个随机的array数组，不包含重复值，最大值不超过 max
     *
     * @Description:
     * @param arraysize
     * @param max
     * @return
     */
    public static int[] createRandomIntArray(int arraysize, int max) {
        int[] randomarray = new int[arraysize];
        int index = 0;
        while (index < arraysize - 1) {
            int tmp = RandomUtils.nextInt(max);
            if (!ArrayUtils.contains(randomarray, tmp)) {
                randomarray[index] = tmp;
                index++;
            }
        }
        return randomarray;
    }
    /**
     * 传入16进制或者8进制的字符串，生成int类型
     *
     * @param str
     * @return
     */
    public static int createInt(String str) {
        return NumberUtils.createInteger(str);
    }

    /**
     * 格式化 string，返回 int 值
     *
     * @param str
     * @return
     */
    public static int toInt(String str) {
        return NumberUtils.toInt(str);
    }

    /**
     * 格式化string，返回long值
     *
     * @param str
     * @return
     */
    public static long toLong(String str) {
        return NumberUtils.toLong(str);
    }

    public static double toDouble(String str){
        return NumberUtils.toDouble(str, 0.0);
    }

    public static float toFloat(String str){
        return NumberUtils.toFloat(str,0);
    }


    public static boolean isNumber(String str) {
        return NumberUtils.isNumber(str);
    }


    public static boolean isDigits(String str) {
        return NumberUtils.isDigits(str);
    }

    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        if (!isNumber(str)) {
            return false;
        }
        if (str.length() > Math.max(Integer.toString(Integer.MAX_VALUE).length(), Integer.toString(Integer.MIN_VALUE).length())) {
            return false;
        }
        Long value = Long.parseLong(str);
        return value >= Integer.MIN_VALUE && value <= Integer.MAX_VALUE;
    }

    public static String format(String pattern, String str) throws Exception {
        if (isNumber(str)) {
            return format(pattern, Double.parseDouble(str));
        } else {
            throw new Exception("The input number is invalid.");
        }
    }

    public static String format(String pattern, double x) {
        DecimalFormat df = new DecimalFormat(pattern);
        return df.format(x);
    }
}

