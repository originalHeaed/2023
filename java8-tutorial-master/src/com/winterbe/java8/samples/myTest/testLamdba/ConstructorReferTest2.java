package com.winterbe.java8.samples.myTest.testLamdba;

/**
 * 构造方法引用传递给函数式接口测试2 - 函数式接口中抽象方法入参和构造犯法入参不一致
 * @author wanggh31690
 */
public class ConstructorReferTest2 {
    /**
     * 对象
     */
    static class Person {
        String name;

        /**
         * 构造方法
         */
        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    /**
     * 创建 Person 对象的函数式接口，但是入参为两个
     */
    @FunctionalInterface
    interface ICreatePerson {
        Person myCreatePerson(String name, String age);
    }

    public static void main(String[] args) {
        /**
         * 这里会报错，因为函数式接口的抽象方法入参和 Person 构造方法入参个数和类型不一致
         */
//        ICreatePerson createPerson = Person::new;
    }
}