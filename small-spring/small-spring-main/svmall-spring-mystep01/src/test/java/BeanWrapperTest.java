import org.example.Exception.BeansException;
import org.example.config.BeanDefinition;
import org.example.config.BeanReference;
import org.example.config.PropertyValue;
import org.example.config.PropertyValues;
import org.example.support.DefaultListableBeanFactory;
import org.junit.Test;

public class BeanWrapperTest {
    @Test
    public void test() throws BeansException {
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
