import org.example.Exception.BeansException;
import org.example.config.BeanDefinition;
import org.example.support.DefaultListableBeanFactory;
import org.junit.Test;

public class BeanWrapperTest {
    @Test
    public void test() throws BeansException {
        String name = "service";
        /* 创建容器 */
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        /* 向容器中注册 beandefinition */
        defaultListableBeanFactory.registerBeanDefinition(name, new BeanDefinition(Service.class));
        /* 从容器中获取 beandefinition 代表类的实例对象 */
        ((Service) defaultListableBeanFactory.getBean(name)).test();
        ((Service) defaultListableBeanFactory.getBean(name, "ds")).test();
        /* 再次获取（验证是单例模式） */
        System.out.println(defaultListableBeanFactory.getBean(name, "ds") == defaultListableBeanFactory.getBean(name, "ds"));
    }
}
