import cn.hutool.core.io.IoUtil;
import org.example.Exception.BeansException;
import org.example.config.BeanDefinition;
import org.example.config.BeanReference;
import org.example.config.PropertyValue;
import org.example.config.PropertyValues;
import org.example.io.ClassPathResource;
import org.example.io.DefaultResourceLoader;
import org.example.io.Resource;
import org.example.io.ResourceLoader;
import org.example.support.DefaultListableBeanFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class BeanWrapperTest {
    private ResourceLoader defaultResourceLoader;
    @Before
    public void before() {
        defaultResourceLoader = new DefaultResourceLoader();
    }

    /**
     * 测试从 class_path 下加载资源
     * @throws IOException
     */
    @Test
    public void testClassPath() throws IOException {
        Resource resource = defaultResourceLoader.getResource("classpath:important.properties");
        System.out.println(IoUtil.readUtf8(resource.getInputStream()));
    }

    /**
     * 测试从本地文件系统中加载文件资源
     */
    @Test
    public void testFilePath() throws IOException {
        Resource resource = defaultResourceLoader.getResource("E:\\个人学习\\2023\\small-spring\\small-spring-main\\svmall-spring-mystep01\\src\\test\\resources\\important.properties");
        System.out.println(IoUtil.readUtf8(resource.getInputStream()));
    }

    public void testUrlPath() {
        Resource resource = defaultResourceLoader.getResource("E:\\个人学习\\2023\\small-spring\\small-spring-main\\svmall-spring-mystep01\\src\\test\\resources\\important.properties");

    }


    /**
     * 原生，不使用文件或注解实现 ioc
     * @throws BeansException
     */
    @Test
    public void test() throws BeansException {
        //https://github.com/originalHeaed/2023/blob/main/small-spring/small-spring-main/important.properties

        /* 1.创建容器 */
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        /* 2.向容器中注册 beandefinition */
        // 向 ioc 容器中注入 dao class
        defaultListableBeanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
        // 向 ioc 容器中注入 service class
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("userId", 1));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
        defaultListableBeanFactory.registerBeanDefinition("userService", new BeanDefinition(UserService.class, propertyValues));
        /* 3.从容器中获取 bean 实例 */
        UserService userService = (UserService) defaultListableBeanFactory.getBean("userService");
        userService.queryUserInfo();


    }
}
