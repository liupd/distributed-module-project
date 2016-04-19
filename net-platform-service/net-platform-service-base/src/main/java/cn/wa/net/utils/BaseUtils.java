package cn.wa.net.utils;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import javax.xml.crypto.Data;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by dell on 2015/6/2.
 **/
public class BaseUtils {

    //结果集转List
    public static List<Map> convertToList(List<Map> list){
        List<Map> resultList = new ArrayList<Map>();
        if(list == null){
            return resultList;
        }
        for(Map map:list){
            resultList.add(convertToMap(map));
        }
        return resultList;
    }

    //结果集转Map
    public static Map convertToMap(Map map){
        Map resultMap = new HashMap();
        if(null!=map){
            Set keySet = map.keySet();
            for(Object key:keySet){
                resultMap.put(keyConvert((String)key),map.get(key));
            }

        }
        return resultMap;
    }


    //key转换
    private static String keyConvert(String key){
        String[] keyArr = key.split("_");
        StringBuffer str = new StringBuffer();
        for(int i=0;i<keyArr.length;i++){
            if(i!=0){
                str.append(toUpperCaseFirstOne(keyArr[i]));
            }else{
                str.append(keyArr[i]);
            }
        }
        return  str.toString();
    }

    //首字母转大写
    private static String toUpperCaseFirstOne(String s)
    {
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    ///map 转voList
    public static List<Object>  convertList(Class clazz,List<Map> mapList) throws IllegalAccessException,InstantiationException{
        List<Object> list = new ArrayList<Object>();
        for(Map map:mapList){
                list.add(convert(clazz,map));
        }
        return list;
    }

    //map 转vo
    public static Object convert(Class clazz,Map map) throws IllegalAccessException,InstantiationException{
        Object obj = null;
            obj = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for(Field f:fields){
            StringBuffer dataField = new StringBuffer();
            String fieldName = f.getName();
            f.setAccessible(true);
            for(int i = 0; i < fieldName.length(); i++){
                char c = fieldName.charAt(i);
                if(Character.isUpperCase(c)&&i!=0&&i!=fieldName.length()-1){
                    dataField.append("_");
                    dataField.append(Character.toLowerCase(c));
                }else{
                    dataField.append(c);
                }
            }
            Set keySet = map.keySet();
            if(keySet.contains(dataField.toString())){
                    f.set(obj,map.get(dataField.toString()));
            }
        }
        return obj;
    }



    public static Object convert2(Class clazz,Map map) throws IllegalAccessException, InstantiationException {
        Object obj = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for(Field f:fields){
            StringBuffer dataField = new StringBuffer();
            String fieldName = f.getName();
            f.setAccessible(true);
            for(int i = 0; i < fieldName.length(); i++){
                char c = fieldName.charAt(i);
                if(Character.isUpperCase(c)&&i!=0&&i!=fieldName.length()-1){
                    dataField.append("_");
                    dataField.append(Character.toLowerCase(c));
                }else{
                    dataField.append(c);
                }
            }
            Set keySet = map.keySet();
            if(keySet.contains(dataField.toString())){
                f.set(obj,map.get(dataField.toString()));
            }
        }
        return obj;
    }

    public static Object objectFilter(Object obj,String filter) throws IllegalAccessException {
        Set strSet = new HashSet();
        if(StringUtil.isNotNullStr(filter)){
            CollectionUtils.addAll(strSet,filter.split(","));
        }
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field f:fields){
            String fieldName = f.getName();
            f.setAccessible(true);
            if(!strSet.contains(fieldName)){
                f.set(obj,null);
            }
        }
        return obj;
    }

    /**
     * 对象之间属性copy，包含继承关系
     * @param src
     * @param des
     */
    public static void  convert(Object src,Object des) throws InvocationTargetException, IllegalAccessException {
        Class desclazz = des.getClass();
        Class srcclazz = src.getClass();
        Field[] fields = srcclazz.getDeclaredFields();

        for(Field field : fields){
            if (Modifier.isFinal(field.getModifiers())) {
                continue;
            }
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            if (Modifier.isTransient(field.getModifiers())) {
                continue;
            }
            String fieldName = field.getName();
            Method srcMethod =getMethods(srcclazz,fieldName);
            Object value = srcMethod.invoke(src);

            Field desField = getField(desclazz,fieldName);
            if(desField != null && value != null){
                desField.setAccessible(true);
                desField.set(des,value);
                desField.setAccessible(false);
            }
        }
    }


    public static Field getField(Class srcclazz,String fieldName){
        Field f = null;
        try{
            f = srcclazz.getDeclaredField(fieldName);
        }catch (Exception e){
            String name = srcclazz.getSuperclass().getName();
            if(name.contains("cn.wa")){
                return getField(srcclazz.getSuperclass(),fieldName);
            }
        }
        return f;
    }

    public static Method getMethods(Class srcclazz,String fieldName){
        Method getMethod = null;
        try{
            Field f = srcclazz.getDeclaredField(fieldName);
            String isMethodName = "is" + StringUtils.capitalize(fieldName);
            String getMethodName = "get" + StringUtils.capitalize(fieldName);
            if (ReflectUtil.containsMethod(srcclazz, isMethodName)) {
                getMethod = srcclazz.getDeclaredMethod(isMethodName);
            } else if (ReflectUtil.containsMethod(srcclazz, getMethodName)) {
                getMethod = srcclazz.getDeclaredMethod(getMethodName);
            }
        }catch (Exception e){
            return getMethods(srcclazz.getSuperclass(),fieldName);
        }
        return getMethod;
    }

    public static String getCovertString(String[] arrays){
        StringBuilder auditStatus=new StringBuilder("");
        for(String str:arrays){
            auditStatus.append("'").append(str).append("'").append(",");
        }
        auditStatus.deleteCharAt(auditStatus.toString().length()-1);
        return auditStatus.toString();
    }

    public static List<String> getListString(String data){
        String[] splitStr=data.split(",");
        List<String> list=new ArrayList<>();
        for(String str:splitStr){
            list.add(str);
        }
        return list;
    }

    /**
     * 对象转Map
     * @param bean;
     * @return Map;
     */
    public static Map convertBean(Object bean){
        Class type = bean.getClass();
        Map returnMap = new HashMap();
        try{
            BeanInfo beanInfo = Introspector.getBeanInfo(type);
            PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
            for (int i = 0; i< propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (!propertyName.equals("class")) {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(bean, new Object[0]);
                    if (result != null) {
                        returnMap.put(propertyName, result);
                    } else {
                        returnMap.put(propertyName, "");
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return returnMap;
    }


    public static Map<String, Object> objectToMap(Object obj){
        if(obj == null)
            return null;
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (key.compareToIgnoreCase("class") == 0) {
                    continue;
                }
                Method getter = property.getReadMethod();
                Object value = getter!=null ? getter.invoke(obj) : null;
                map.put(key, value);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }



}
