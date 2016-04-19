package cn.wa.net.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

/**
 * 反射工具类
 * 
 * @author qinpeng
 * 
 */
public class ReflectUtil {

	/**
	 * 判断给类中有没有相应方法名的方法
	 * 
	 * @param clz
	 * @param methodName
	 * @return
	 */
	public static boolean containsMethod(Class<?> clz, String methodName) {
		Method[] methods = clz.getDeclaredMethods();
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断类中有没有相应属性名的属性
	 * 
	 * 
	 * @param clz
	 * @param fieldName
	 * @return
	 */
	public static boolean containsField(Class<?> clz, String fieldName) {
		Field[] fields = clz.getDeclaredFields();
		for (Field field : fields) {
			if (field.getName().equals(fieldName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 原始类型转换成包装类型
	 * 
	 * @param primitiveType
	 * @return
	 */
	public static Class<?> convertToWrapClass(Class<?> primitiveType) {
		Class<?> wrapClass = null;
		if (primitiveType == boolean.class) {
			wrapClass = Boolean.class;
		} else if (primitiveType == int.class) {
			wrapClass = Integer.class;
		} else if (primitiveType == short.class) {
			wrapClass = Short.class;
		} else if (primitiveType == long.class) {
			wrapClass = Long.class;
		} else if (primitiveType == byte.class) {
			wrapClass = Byte.class;
		} else if (primitiveType == float.class) {
			wrapClass = Float.class;
		} else if (primitiveType == double.class) {
			wrapClass = Double.class;
		} else if (primitiveType == char.class) {
			wrapClass = Character.class;
		}
		return wrapClass;
	}

	/**
	 * 包装类型转换为原始类型
	 * 
	 * @param wrapClass
	 * @return
	 * @throws Exception
	 */
	public static Class<?> convertToPrimitiveType(Class<?> wrapClass) throws Exception {
		return (Class<?>) wrapClass.getField("TYPE").get(null);
	}

	/**
	 * 判断是否是包装类
	 * 
	 * @param clz
	 * @return
	 */
	public static boolean isWrapClass(Class<?> clz) {
		try {
			return ((Class<?>) clz.getField("TYPE").get(null)).isPrimitive();
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isPrimitiveType(Class<?> clz) {
		return clz.isPrimitive();
	}

	/**
	 * 判断类的继承关系
	 * 
	 * @param subClass
	 * @param parentClass
	 * @return
	 */
	public static boolean isSubClass(Class<?> subClass, Class<?> parentClass) {
		return Arrays.asList(subClass.getInterfaces()).contains(parentClass);
	}

	/**
	 * 判断是不是同一类型，或是某类的子类
	 * 
	 * @param clz
	 * @param desClz
	 * @return
	 */
	public static boolean isClass(Class<?> clz, Class<?> desClz) {
		return isSubClass(clz, desClz) || clz == desClz;
	}

	/**
	 * 判断是不是同一类型，或是某类的子类，原始类型和包装类型如果相对于那个，被认为是一种类型 如：boolean.class 和 Boolean.class是同一类型
	 * 
	 * @param clz
	 * @param desClz
	 * @return
	 * @throws Exception
	 */
	public static boolean isClassIgnoredPrimitive(Class<?> clz, Class<?> desClz) throws Exception {
		if (clz.isPrimitive() && isWrapClass(desClz)) {
			if (clz == convertToPrimitiveType(desClz)) {
				return true;
			}
		} else if (isWrapClass(clz) && desClz.isPrimitive()) {
			if (convertToPrimitiveType(clz) == desClz) {
				return true;
			}
		} else {
			if (isSubClass(clz, desClz) || clz == desClz) {
				return true;
			}
		}
		return false;
	}

	public static boolean isSameCollectionIgnoredArray(Class<?> clz, Class<?> desClz) throws Exception {
		if (Collection.class.isAssignableFrom(clz) && desClz.isArray()) {
			return true;
		} else if (Collection.class.isAssignableFrom(clz) && Collection.class.isAssignableFrom(desClz)) {
			return true;
		} else if (clz.isArray() && Collection.class.isAssignableFrom(desClz)) {
			return true;
		}
		return false;
	}

	public static boolean isClassIgnoredPrimitveAndArray(Class<?> clz, Class<?> desClz) throws Exception {
		if (clz.isPrimitive() && isWrapClass(desClz)) {
			if (clz == convertToPrimitiveType(desClz)) {
				return true;
			}
		} else if (isWrapClass(clz) && desClz.isPrimitive()) {
			if (convertToPrimitiveType(clz) == desClz) {
				return true;
			}
		} else if (isSameCollectionIgnoredArray(clz, desClz)) {
			return true;
		} else {
			if (isSubClass(clz, desClz) || clz == desClz) {
				return true;
			}
		}
		return false;
	}

}
