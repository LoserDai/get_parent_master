package com.df.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author feng.dai
 * @package com.df.util
 * @project get_parent_master
 * @Date 2022/9/19 10:19
 */
public class ObjectUtils {
    /**
     * 判断一个对象是否为空 使用时调用此方法即可
     *
     * @param obj     要判断的对象
     * @param strings 表当判断自定义对象时可以传入,其他类型传入 Null 即可
     * @return 不为空 ture 空 false
     */
    public static Boolean isEmpty(Object obj, List<String> strings) {
        Boolean empty = false;
        if (obj != null) {
            empty = switchBoolean(getType(obj), obj, strings);
        }
        return empty;
    }


    /**
     * 获取当前对象的类型
     *
     * @param object 要获取类型的对象
     * @return 当前对象的类型
     */
    public static String getType(Object object) {
        String type = object.getClass().getName();
        int length = type.lastIndexOf(".");
        if (object instanceof Map) {
            return "Map";
        }
        if (object instanceof List) {
            return "List";
        }
        return type.substring(length + 1);
    }

    /**
     * 当前对象为 String 类型时, 判断当前对象是否为 null 且 它是否为 "";
     *
     * @param obj String 类型的对象
     * @return 不为空  true 为空 false
     */
    public static Boolean strIsEmpty(Object obj) {
        return !"".equals(obj) && obj != null;
    }

    /**
     * 当已知当前对象为 map 类型,判断当前 map 的长度不为0 且它本身不为空 时返回 true
     *
     * @param obj 已知当前对象是 map 类型
     * @return 为空 返回 false 不为空 返回 true
     */
    public static Boolean mapIsEmpty(Object obj) {
        Map<?, ?> map = (Map<?, ?>) obj;
        return map != null && map.size() != 0;
    }

    /**
     * 当已知当前对象为 list 类型,判断当前 list 的长度不为 0 且它本身不为空时返回 true
     *
     * @param obj 已知当前对象是 map 类型
     * @return 为空 返回 false 不为空 返回 true
     */
    public static Boolean listIsEmpty(Object obj) {
        List<?> list = (List<?>) obj;
        return list != null && list.size() != 0;
    }

    /**
     * 判断 integer 类型的数据是不是空.
     *
     * @param obj 要判断的 Integer
     * @return 不为空就返回 true
     */
    public static Boolean integerIsEmpty(Object obj) {
        return obj != null;
    }

    /**
     * 当对象为自定义时,根据属性来判断当前对象是否为空
     *
     * @param obj     自定义对象
     * @param strings 当判断自定义对象时可以传入,其他类型传入 Null 即可
     * @return 只要有一个属性不为空 就返回 true 当所有属性都为空时返回 false
     */
    public static Boolean customizeIsEmpty(Object obj, List<String> strings) {
        // 从该对象中获取所有属性
        Field[] fields = obj.getClass().getDeclaredFields();
        Map<String, Boolean> map = new HashMap<>(5);
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object fieldObj = field.get(obj);
                map.put(field.getName(), isEmpty(fieldObj, strings));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return iteratorStrings(map, strings);
    }


    /**
     * 迭代获取到的 Map 分两种情况进行判断,如果传入的字符串默认需要某些属性才为true需要传入 List<String> 如果传入 Null 那么默认当前对象有一个属性就为 true
     *
     * @param map     迭代属性获取的map
     * @param strings 当判断自定义对象时可以传入,其他类型传入 Null 即可
     * @return 返回当前对象是否为空.
     */
    public static Boolean iteratorStrings(Map<String, Boolean> map, List<String> strings) {
        List<Boolean> list = new ArrayList<>();
        if (listIsEmpty(strings)) {
            for (String str : strings) {
                list.add(map.get(str));
            }
            return !list.contains(false);
        } else {
            for (String key : map.keySet()) {
                list.add(map.get(key));
            }
            return list.contains(true);
        }
    }


    /**
     * 将 switch 判断提取称方法 方便多重使用
     *
     * @param type    当前判断对象的类型,以 String 类型传入
     * @param obj     要判断的对象
     * @param strings 当判断自定义对象时可以传入,其他类型传入 Null 即可.
     * @return 当对象不为空时 true  为空时 false
     */
    public static Boolean switchBoolean(String type, Object obj, List<String> strings) {
        switch (type) {
            case "String":
                return strIsEmpty(obj);
            case "Integer":
                return integerIsEmpty(obj);
            case "Map":
                return mapIsEmpty(obj);
            case "List":
                return listIsEmpty(obj);
            default:
                return customizeIsEmpty(obj, strings);
        }
    }
}
