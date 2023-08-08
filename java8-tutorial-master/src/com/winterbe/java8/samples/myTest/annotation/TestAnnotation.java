package com.winterbe.java8.samples.myTest.annotation;

import java.lang.annotation.*;

/**
 * 测试注解
 */
public class TestAnnotation {
    /* 在 JDK1.8 之前重复注解使用方法，只能使用一个容器来包裹 */
    public @interface myAnno {
        int value();
    }

    public @interface myContainer {
        myAnno[] value();
    }

    class MyTest1 {
        @myContainer({@myAnno(value = 3), @myAnno(value = 3)})
        public void test() {

        }
    }

    /* 在 JDK1.8 之后，使用 @Repeatable，可以不写容器 */
    @Repeatable(myContainer2.class)
    public @interface myAnno2 {
        int value();
    }

    public @interface myContainer2 {
        myAnno2[] value();
    }

    class MyTest2 {
        @myAnno2(value = 3)
        @myAnno2(value = 3)
        public void test() {

        }
    }

}
