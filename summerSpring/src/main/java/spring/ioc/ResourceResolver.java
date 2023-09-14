package spring.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.function.Function;

public class ResourceResolver {

    Logger logger = LoggerFactory.getLogger(getClass());

    String basePackage;

    public ResourceResolver(String basePackage) {
        this.basePackage = basePackage;
    }

    /**
     * 从 basePackage 加载指定的资源，加载资源的规则由 mapper 定制
     * @param mapper 需要资源的规则
     * @return 资源对象
     * @param <R>
     */
    public <R> List<R> scan(Function<Resource, R> mapper) {
        String basePackagePath = this.basePackage.replace(".", "/");
        String path = basePackagePath;
        try {
            List<R> collector = new ArrayList<>();
            scan0(basePackagePath, path, collector, mapper);
            return collector;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 使用指定的类加载器从 path 下加载所有资源，然后判断该资源是否符合 mapper 的过滤要求，如果是则将保留该资源，否则舍弃
     */
    private <R> void scan0(String basePackagePath, String path, List<R> collector, Function<Resource, R> mapper) throws URISyntaxException, IOException {
        logger.atDebug().log("scan path:{}", path);
        Enumeration<URL> en = getContextClassLoader().getResources(path);
        while (en.hasMoreElements()) {
            URL url = en.nextElement();
            URI uri = url.toURI();
            String uriStr = removeTrailingSlash(uriToString(uri));
            String uriBaseStr = uriStr.substring(0, uriStr.length() - basePackagePath.length());
            if (uriBaseStr.startsWith("file:")) {
                uriBaseStr = uriBaseStr.substring(5);
            }
            if (uriStr.startsWith("jar:")) {
                scanFile(true, uriBaseStr, jarUriToPath(basePackagePath, uri), collector, mapper);
            } else {
                scanFile(false, uriBaseStr, Paths.get(uri), collector, mapper);
            }
        }
    }

    /**
     * 扫描指定路径下的所有文件，然后将符合要求的加入到 collector 中
     */
    private <R> void scanFile(boolean isJar, String base, Path root, List<R> collector, Function<Resource, R> mapper) throws IOException {
        String baseDir = removeTrailingSlash(base);
        /**
         * 遍历根目录下的文件，然后将文件构造成 resource 最后过滤出需要的结果加入 collector 中
         */
        Files.walk(root).filter(Files::isRegularFile).forEach(file -> {
            Resource res = null;
            if (isJar) {
                res = new Resource(baseDir, removeLeadingSlash(file.toString()));
            } else {
                String path = file.toString();
                String name = removeLeadingSlash(path.substring(baseDir.length()));
                res = new Resource("file:" + path, name);
            }
            logger.atDebug().log("found resource：{}", res);
            R r = mapper.apply(res);
            if (r != null) collector.add(r);
        });
    }

    /**
     * 获取类加载器
     * Web应用的ClassLoader不是JVM提供的基于Classpath的ClassLoader，而是Servlet容器提供的ClassLoader，
     * 它不在默认的Classpath搜索，而是在/WEB-INF/classes目录和/WEB-INF/lib的所有jar包搜索，
     * 从Thread.getContextClassLoader()可以获取到Servlet容器专属的ClassLoader；
     */
    private ClassLoader getContextClassLoader() {
        ClassLoader cl = null;
        cl = Thread.currentThread().getContextClassLoader();
        if (cl == null) cl = getClass().getClassLoader();
        return cl;
    }

    private Path jarUriToPath(String basePackage, URI jarUri) throws IOException {
        return FileSystems.newFileSystem(jarUri, new HashMap<>()).getPath(basePackage);
    }

    /**
     * 将 URL 进行解码
     */
    private String uriToString(URI uri) throws UnsupportedEncodingException {
        return URLDecoder.decode(uri.toString(), String.valueOf(StandardCharsets.UTF_8));
    }

    /**
     * 去掉首部的文件分割符号
     */
    private String removeLeadingSlash(String s) {
        if (s.startsWith("/") || s.startsWith("\\")) {
            s = s.substring(1);
        }
        return s;
    }

    /**
     * 去掉尾部后缀文件分割符号
     */
    private String removeTrailingSlash(String s) {
        if (s.endsWith("/") || s.endsWith("\\")) {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }
}
