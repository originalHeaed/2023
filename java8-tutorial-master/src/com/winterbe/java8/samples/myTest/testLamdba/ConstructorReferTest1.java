package com.winterbe.java8.samples.myTest.testLamdba;

/**
 * 将构造方法引用传递给函数式接口测试
 * @author wanggh31690
 */
public class ConstructorReferTest1 {
    /**
     * 对象
     */
    static class Person {
        String name;
        public Person(String name) {
            this.name = name;
        }

        public String getName() {return this.name;}
    }

    /**
     * 函数式接口，内部定义了一个创建对象的抽象方法
     */
    @FunctionalInterface
    interface ICreatePerson {
        /**
         * 创建一个 Person 对象
         */
        Person myCreatePerson(String name);
    }

    public static void main(String[] args) {
        /**
         * 与方法引用传递不同的是，"::" 关键字后面不是接方法名，而是接 new
         * 本质逻辑与方法引用传递一致
         * 在 Person 的构造方法中入参为 String 类型，返回值虽然没有明写，但是实际上返回的是 this，也就是 Person 类型的
         * 在函数式接口中抽象方法 myCreatePerson 入参为 String 类型，返回值为 Person 类型
         * 从上面两个对比可以知道，本质也是一个方法引用的传递
         */
        ICreatePerson createPerson = Person::new;
        /**
         * 实际上调用的是 Person 的构造方法
         */
        Person person = createPerson.myCreatePerson("wgh");
        System.out.println(person.getName());
    }
}
