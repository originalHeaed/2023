package spring.propertyResolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.Function;

public class PropertyResolver {
    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 保存配置文件中的 key - value 键值对
     */
    private Map<String, String> map;

    /**
     * 存储 value 的转换
     */
    private Map<Class<?>, Function<String, Object>> converters = new HashMap<>();

    public PropertyResolver(Properties props) {
        /* `Returns` an unmodifiable string map view of the current system environment. */
        map.putAll(System.getenv());
        Set<String> strings = props.stringPropertyNames();
    }

    /**
     * 新增值的转换规则
     * @param cl 转换后的类型
     * @param function 转换规则
     */
    public void addNewConverter(Class<?> cl, Function<String, Object> function) {
        converters.put(cl, function);
    }

}
