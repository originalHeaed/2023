package org.example.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 默认资源加载器
 */
public class DefaultResourceLoader implements ResourceLoader{
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location cannot be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            /* classpath 资源加载器 */
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                /* url 资源加载器 */
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                /* file 资源加载器 */
                return new FileSystemResource(location);
            }
        }
    }
}
