package org.example.config;

import java.util.LinkedList;
import java.util.List;

/**
 * bean 属性name-value 的集合类
 */
public class PropertyValues {
    /**
     * 存放name-value 的集合
     */
    private final List<PropertyValue> list;

    public PropertyValues() {
        list = new LinkedList<>();
    }

    /**
     * 将集合转为数组返回
     * @return
     */
    public PropertyValue[] getPropertyValues() {
        return list.toArray(new PropertyValue[0]);
    }

    /**
     * 向集合中添加数据
     * @param pv
     */
    public void addPropertyValue(PropertyValue pv) {
        list.add(pv);
    }

    /**
     * 根据 name 从集合中获取数据
     * @param propertyName
     * @return
     */
    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : list) {
            if (pv.getName().equals(propertyName)) return pv;
        }
        return null;
    }
}
