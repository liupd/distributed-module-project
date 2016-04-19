package cn.wa.net.utils;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.UUID;
import java.util.regex.Pattern;

@SuppressWarnings("unchecked")
public class StringUtil {
	/**
	 * @Description:用, 号分割，返回数组
	 * @param str;
	 * @return ;
	 */
	public static String sortStrForComma(String str) {
		if (!isNotNullStr(str))
			return null;
		String[] temp = splitStrForComma(str);
		Arrays.sort(temp);

		String tempStr = joinStrForComma(temp);
		return tempStr;
	}

	public static String joinStrForComma(String[] strs) {
		String temp = "";
		for (String str : strs) {
			if (isEmpty(temp)) {
				temp = str;
			} else {
				temp = temp + "," + str;
			}
		}
		return temp;
	}

	/**
	 * @Description: 检查一个以逗号分割的字符串里面是否包含 一个字符串
	 * @param strs
	 *            逗号分组数据
	 * @param str
	 *            检查数据
	 * @return
	 */
	public static boolean containsForSplitComma(String strs, String str) {
		String[] array = splitStrForComma(strs);
		return ArrayUtils.contains(array, str);
	}

	/**
	 * @Description:用, 号分割，返回数组
	 * @param str
	 * @return
	 */
	public static String[] splitStrForComma(String str) {
		if (!isNotNullStr(str))
			return null;
		return StringUtils.split(str, ",");
	}

	/**
	 * 返回字符串到到boolea 类型 Y 是 true N 是 false
	 * 
	 * @param str
	 * @return
	 */
	public static boolean getBoolean(String str) {
		return str.toUpperCase().equals("Y");
	}

	/**
	 * 判断是否为null
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str) {
		return null != str;
	}

	/**
	 * 判断是否为空字符串
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNullStr(String str) {
		if (null == str || str.equals("null") || str == "") {
			return false;
		}
		return StringUtils.isNotEmpty(str);
	}

	public static boolean isEmpty(String str) {
		return str == null || str.trim().equals("");
	}

	/**
	 * 判断是否相同
	 * 
	 * @param one
	 * @param two
	 * @return
	 */
	public static boolean isEqual(String one, String two) {
		return StringUtils.equals(one, two);
	}

	public static String toNvlStr(String str, String defstr) {
		return isNotNullStr(str) ? str : defstr;
	}

	public static boolean toBoolean(String str) {
		String lowstr = str.toLowerCase();
		return lowstr.equals("y") || lowstr.equals("yes") || lowstr.equals("true") || lowstr.equals("t");
	}

	public static String toYesOrNoLowstr(boolean status) {
		return status ? "y" : "n";
	}

	/**
	 * 左补齐
	 * 
	 * @Description:
	 * @param str
	 * @param size
	 *            长度
	 * @param padchar
	 *            补齐字符
	 * @return
	 */
	public static String leftPad(String str, int size, String padchar) {
		return StringUtils.leftPad(str, size, padchar);
	}

	/**
	 * 右补齐
	 * 
	 * @Description:
	 * @param str
	 * @param size
	 *            长度
	 * @param padchar
	 *            补齐字符
	 * @return
	 */
	public static String rightPad(String str, int size, String padchar) {
		return StringUtils.rightPad(str, size, padchar);
	}

	/**
	 * @Description:
	 * @param str
	 * @return
	 */
	public static String likePad(String str) {
		if (!isNotNullStr(str))
			return str;
		if (!str.substring(0, 1).equals("%"))
			str = "%" + str;
		if (!str.substring(str.length() - 1, str.length()).equals("%"))
			str = str + "%";
		return StringEscapeUtils.escapeSql(str);
	}

	public static String removeLineFeed(String str) {
		char lf = '\n';
		char lr = '\r';
		return StringUtils.remove(StringUtils.remove(str, lr), lf);

	}
	
	public static String replaceStr(String content, String oldcontent,
			String newcontent) {
		String rc = encodeToUnicode(newcontent);
		String target = "";
		oldcontent = "#" + oldcontent + "#";
		target = content.replace(oldcontent, rc);
		return target;
	}

	public static String encodeToUnicode(String str) {
		if (str == null)
			return "";
		StringBuilder sb = new StringBuilder(str.length() * 2);
		for (int i = 0; i < str.length(); i++) {
			sb.append(encodeToUnicode(str.charAt(i)));
		}
		return sb.toString();
	}

	public static String encodeToUnicode(char character) {
		if (character > 255) {
			return "&#" + (character & 0xffff) + ";";
		} else {
			return String.valueOf(character);
		}
	}
	

	public static String formatMessage(String str,String...params){
		 return java.text.MessageFormat.format(str, params);
	}
	

    /**
     * 验证邮箱地址是否正确
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        return Pattern.compile("^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$").matcher(email).matches();
    }

    /**
     * 验证手机号码
     * @param mobiles
     * @return  [0-9]{5,9}
     */
    public static boolean checkMobileNO(String mobiles){
        return Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$").matcher(mobiles).matches();
    }

    public static void main(String [] args){
        String a="13888888888";
        boolean res=checkMobileNO(a);

        System.out.print(res);
    }

	public static String genUUID4NoLine() {
		UUID uuid = UUID.randomUUID();
		String s = uuid.toString();//
		int p = 0;
		int j = 0;
		char[] buf = new char[32];
		while (p < s.length()) {
			char c = s.charAt(p);
			p += 1;
			if (c == '-') continue;
			buf[j] = c;
			j += 1;
		}
		return new String(buf);
	}

	public static String getUUID2String(){
		return UUID.randomUUID().toString();
	}
}
