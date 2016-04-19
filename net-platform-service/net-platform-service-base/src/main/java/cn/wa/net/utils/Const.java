package cn.wa.net.utils;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * 常量存储,静态方法
 *
 * @author QINPENG
 *
 */
@SuppressWarnings("unchecked")
public class Const {

    public static final String DateFormat[] = new String[]{"yyyyMMdd", "yyyy-MM-dd", "yyyyMMddHH", "yyyyMMddHHmm", "yyyy-MM-dd HH", "yyyyMMddHHmmss",
            "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmssSSS"};


    public final static String orderCancel = "Y";

    public final static String DESC ="DESC";

    public static final String[] PIC_EXTNAME =  new  String[]{ "gif" , "jpg" , "png" , "bmp" ,"jpeg"};

    public static boolean isEmpty(List<?> list) {
        return list == null || list.size() == 0;
    }

    public static boolean notEmpty(List<?> list) {
        return !isEmpty(list);
    }

    /**
     * 添加list2中的元素到list1中去，返回list1和list2的所有元素的list
     *
     * @param list1
     * @param list2
     * @return
     */
    public static List addAll(List list1, List list2) {
        for (Object object : list2) {
            list1.add(object);
        }
        return list1;
    }

    /**
     * get sublist
     *
     * @param list
     * @param length
     * @return
     */
    public static List sublist(List list, int length) {
        if (isEmpty(list))
            return list;
        if (list.size() <= length)
            return list;
        return list.subList(0, length);
    }
    /**
     * 添加 array1,arrya2 到一个新的数组中去，返回的是包含array1，和array2 的新数组
     *
     * @param array1
     * @param array2
     * @return
     */
    public static byte[] addAll(byte[] array1, byte[] array2) {
        return ArrayUtils.addAll(array1, array2);
    }

    /**
     * 添加一个byte到新的数组中去，返回一个新的数组
     *
     * @param array1
     * @param element
     * @return
     */
    public static byte[] add(byte[] array1, byte element) {
        return ArrayUtils.add(array1, element);
    }

    public static String[] addAll(String[] array1, String[] array2) {
        return (String[]) ArrayUtils.addAll(array1, array2);
    }

    public static Object[] addAll(Object[] array1, Object[] array2) {
        return ArrayUtils.addAll(array1, array2);
    }

    public static Object[] add(Object[] array1, Object object) {
        return ArrayUtils.add(array1, object);
    }

    /**
     * 截取一个数组
     *
     * @param array
     * @param startIndex
     *            数组开始位置
     * @param endIndex
     *            数组结束位置
     * @return
     */
    public static byte[] subarray(byte[] array, int startIndex, int endIndex) {
        return ArrayUtils.subarray(array, startIndex, endIndex);
    }

    /**
     * 检查数字中是否包含这个字节
     *
     * @param array
     * @param valueToFind
     * @return
     */
    public static boolean contains(byte[] array, byte valueToFind) {
        return ArrayUtils.contains(array, valueToFind);
    }

    /**
     * test jdbc implete  isclose method
     *
     * @param rs
     * @return
     * @throws java.sql.SQLException
     */
    public static boolean hasIsCloseImpl(ResultSet rs) throws SQLException {
        try {
            rs.isClosed();
        } catch (AbstractMethodError e) {
            return false;
        }
        return true;
    }

    /**
     * @param hexstr
     * @return
     */
    public static String parseHexStrToShort(String hexstr) {
        if (hexstr.indexOf('x') > -1)
            return hexstr.substring(hexstr.indexOf('x') + 1);
        else {
            if (NumberUtil.isDigits(hexstr))
                return StringUtils.leftPad(String.valueOf(NumberUtil.toInt(hexstr)), 2, '0');
        }
        return hexstr;

    }

    /**
     * determine the OS name
     *
     * @return The name of the OS
     */
    public static String getOS() {
        return System.getProperty("os.name");
    }

    public static String NVL(String source, String def) {
        if (source == null || source.length() == 0)
            return def;
        return source;
    }

    public static boolean isNotNull(Object obj) {
        return obj != null && !obj.equals("");
    }

    public static final boolean onlySpaces(String str){
        for (int i = 0; i < str.length(); i++)
            if (!isSpace(str.charAt(i)))
                return false;
        return true;
    }

    public static final boolean isSpace(char c){
        return c == ' ' || c == '\t' || c == '\r' || c == '\n' || Character.isWhitespace(c);
    }

    public static String ltrim(String source) {
        if (source==null) return null;
        int from = 0;
        while (from < source.length() && isSpace(source.charAt(from)))
            from++;

        return source.substring(from);
    }


    public static String rtrim(String source) {
        if (source==null) return null;

        int max = source.length();
        while (max > 0 && isSpace(source.charAt(max - 1)))
            max--;

        return source.substring(0, max);
    }


    public static final String trim(String str)
    {
        if (str==null) return null;

        int max = str.length() - 1;
        int min = 0;

        while (min <= max && isSpace(str.charAt(min)))
            min++;
        while (max >= 0 && isSpace(str.charAt(max)))
            max--;

        if (max < min)
            return "";

        return str.substring(min, max + 1);
    }


    /**
     * 生成md5码
     * @param string;
     * @return
     */
    public static String md5(String string)
    {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
                'e', 'f' };
        try {
            byte[] bytes = string.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] updateBytes = messageDigest.digest();
            int len = updateBytes.length;
            char myChar[] = new char[len * 2];
            int k = 0;
            for (int i = 0; i < len; i++) {
                byte byte0 = updateBytes[i];
                myChar[k++] = hexDigits[byte0 >>> 4 & 0x0f];
                myChar[k++] = hexDigits[byte0 & 0x0f];
            }
            return new String(myChar);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 返回string
     * @param obj;
     * @return
     */
    public static String toString(Object obj){
        return obj==null?null:String.valueOf(obj);
    }

    public static Date toDate(Object obj){
        if(obj==null) return null;
        if(obj instanceof Date) return (Date)obj;
        else if(obj instanceof Timestamp) return (Date)obj;
        return null;

    }

    /**
     * 返回int
     * @param obj;
     * @param defaultvalue;
     * @return
     */
    public static int toInt(Object obj,int defaultvalue){
        try {
            if(obj==null) return defaultvalue;
            if(obj instanceof Integer) return (Integer)obj;
            return 	NumberUtil.toInt(obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultvalue;
    }

}

