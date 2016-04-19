package cn.wa.net.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by liupd on 15-11-17.
 **/
public class DataHandler {

    public static String DateToStr(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  sdf.format(date);
    }

    public static String DateToFileName(String nameFormat, String fileType) {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat(nameFormat);
        String fileName = dateFormat.format(date) + fileType;
        return fileName;
    }

    public static void copyProperties(Object from, Object to) {
        try{
            Method[] fromMethods = from.getClass().getDeclaredMethods();
            Method[] toMethods = to.getClass().getDeclaredMethods();
            Method fromMethod = null, toMethod = null;
            String fromMethodName = null, toMethodName = null;
            for (int i = 0; i < fromMethods.length; i++) {
                fromMethod = fromMethods[i];
                fromMethodName = fromMethod.getName();
                if (!fromMethodName.contains("get"))
                    continue;
                toMethodName = "set" + fromMethodName.substring(3);
                toMethod = findMethodByName(toMethods, toMethodName);
                if (toMethod == null)
                    continue;
                Object value = fromMethod.invoke(from, new Object[0]);
                if(value == null)
                    continue;
                //集合类判空处理
                if(value instanceof Collection) {
                    Collection newValue = (Collection)value;
                    if(newValue.size() <= 0)
                        continue;
                }
                toMethod.invoke(to, new Object[] {value});
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static Method findMethodByName(Method[] methods, String name) {
        for (int j = 0; j < methods.length; j++) {
            if (methods[j].getName().equals(name))
                return methods[j];
        }
        return null;
    }

    public static void transMapToBean(Map<String, Object> map, Object obj) {
        if (map == null || obj == null) {
            return;
        }
        try {
            BeanUtils.populate(obj, map);
        } catch (Exception e) {
            System.out.println("transMap2Bean2 Error " + e.getMessage());
        }
    }

}
