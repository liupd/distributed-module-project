package cn.wa.net.utils;


import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by liupd on 2015/12/28 0028.
 **/
public class StrUtils {
    public static String getFormatSqlInString(String[] elements){
        return "'" + StringUtils.join(elements, ",")+"'";
    }

    public static String getFormatSqlInString(List<String> elements){
        return "'" +StringUtils.join(elements,",")+"'";
    }

    public static String DateToStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        return str;
    }



}
