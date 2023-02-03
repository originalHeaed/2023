package org.example.io;

/**
 * 包装资源类加载器
 */
public interface ResourceLoader {
    /**
     * 用于统一加载资源
     * @param location
     * @return
     */
    Resource getResource(String location);
}
