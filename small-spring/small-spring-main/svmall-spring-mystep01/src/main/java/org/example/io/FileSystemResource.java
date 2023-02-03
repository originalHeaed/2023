package org.example.io;

import cn.hutool.core.lang.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件类资源加载器
 */
public class FileSystemResource implements Resource{
    /**
     * 文件对象
     */
    private final File file;

    /**
     * 文件资源路径
     */
    private final String path;

    public FileSystemResource(File file) {
        Assert.notNull(file, "File cannot be null");
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource(String path) {
        this(new File(path));
    }


    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public final String getPath() {
        return this.path;
    }
}
