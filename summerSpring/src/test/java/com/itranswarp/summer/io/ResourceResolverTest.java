package com.itranswarp.summer.io;

import org.junit.Test;
import spring.ioc.ResourceResolver;
import sub.AnnoScan;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;


public class ResourceResolverTest {

    /**
     * 扫描 com.itranswarp.scan 下所有以 .calss 为结尾的资源，并返回 class 路径
     */
    @Test
    public void scanClass() {
        String pkg = "com.itranswarp.scan"; // 需要扫描的包
        ResourceResolver rr = new ResourceResolver(pkg);
        List<String> classes = rr.scan(res -> {
            String name = res.getName();
            if (name.endsWith(".class")) {
                return name.substring(0, name.length() - 6).replace("/", ".").replace("\\", ".");
            }
            return null;
        });
        Collections.sort(classes);
        System.out.println(classes);
        String[] listClasses = new String[] {
                // list of some scan classes:
                "com.itranswarp.scan.convert.ValueConverterBean", //
                "com.itranswarp.scan.destroy.AnnotationDestroyBean", //
                "com.itranswarp.scan.init.SpecifyInitConfiguration", //
                "com.itranswarp.scan.proxy.OriginBean", //
                "com.itranswarp.scan.proxy.FirstProxyBeanPostProcessor", //
                "com.itranswarp.scan.proxy.SecondProxyBeanPostProcessor", //
                "com.itranswarp.scan.nested.OuterBean", //
                "com.itranswarp.scan.nested.OuterBean$NestedBean", //
                "com.itranswarp.scan.sub1.Sub1Bean", //
                "com.itranswarp.scan.sub1.sub2.Sub2Bean", //
                "com.itranswarp.scan.sub1.sub2.sub3.Sub3Bean", //
        };
        for (String clazz : listClasses) {
            assertTrue(classes.contains(clazz));
        }
    }

    /**
     * 扫描指定 jar 下的 class
     */
    @Test
    public void scanJar() {
        String pkg = PostConstruct.class.getPackage().getName();
        ResourceResolver rr = new ResourceResolver(pkg);
        List<String> classes = rr.scan(res -> {
            String name = res.getName();
            if (name.endsWith(".class")) {
                return name.substring(0, name.length() - 6).replace("/", ".").replace("\\", ".");
            }
            return null;
        });
        // classes in jar:
        assertTrue(classes.contains(PostConstruct.class.getName()));
        assertTrue(classes.contains(PreDestroy.class.getName()));
        // jakarta.annotation.sub.AnnoScan is defined in classes:
        assertTrue(classes.contains(AnnoScan.class.getName()));
    }

    @Test
    public void scanTxt() {
        String pkg = "com.itranswarp.scan";
        ResourceResolver rr = new ResourceResolver(pkg);
        List<String> classes = rr.scan(res -> {
            String name = res.getName();
            if (name.endsWith(".txt")) {
                return name.replace("\\", "/");
            }
            return null;
        });
        Collections.sort(classes);
        assertArrayEquals(new String[] {
                // txt files:
                "com/itranswarp/scan/sub1/sub1.txt", //
                "com/itranswarp/scan/sub1/sub2/sub2.txt", //
                "com/itranswarp/scan/sub1/sub2/sub3/sub3.txt", //
        }, classes.toArray(new String[0]));
    }
}
