package org.example.io;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ClassUtil;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ClassPathResource implements Resource{
    /**
     * 路径
     */
    private final String path;

    /**
     * 类加载器
     */
    private final ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtil.getClassLoader());
    }

    @Override
    public InputStream getInputStream() throws FileNotFoundException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null) {
            throw new FileNotFoundException(this.path + " cannot be opened because is does not exist");
        }
        return is;
    }
}
