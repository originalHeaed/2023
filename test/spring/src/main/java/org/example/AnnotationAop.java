package org.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration //标记当前类是：配置类
@ComponentScan( basePackages = "org.example") //配置注解扫描
@EnableAspectJAutoProxy //开启AOP自动代理
public class AnnotationAop {

}