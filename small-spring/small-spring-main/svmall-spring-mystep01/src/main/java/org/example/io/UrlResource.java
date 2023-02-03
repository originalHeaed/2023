package org.example.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 云服务、git、gittee 中读取文件（通过 http 方式读取内容）
 */
public class UrlResource implements Resource{
    /**
     * 读取内容的 url
     */
    private final URL url;

    public UrlResource(URL url) {
        Assert.notNull(url, "url cannot be null");
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection = this.url.openConnection();
        try {
            return urlConnection.getInputStream();
        } catch (IOException e) {
            if (urlConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) urlConnection).disconnect();
            }
            throw e;
        }
    }
}
