package org.example.support;

import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("classpath:important.properties");
        StringBuilder sb = new StringBuilder();
        byte[] bytes = new byte[256];
        int read = -1;
        while ((read = inputStream.read(bytes)) != 256) {
            sb.append(new String(bytes, 0, read));
        }
        System.out.println(sb.toString());
    }

}
