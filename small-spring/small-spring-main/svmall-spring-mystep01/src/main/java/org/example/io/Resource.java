package org.example.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * io 接口
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
