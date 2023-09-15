package spring.propertyResolver;

public class PropertyExpr {
    /**
     * key 值
     */
    private String key;

    /**
     * 当 keu 不存在时，默认值
     */
    private String defaultValue;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public String toString() {
        return this + "{key:" + key + ", defaultVal:" + defaultValue + "}";
    }
}
