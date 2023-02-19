import org.junit.Test;
import staticProxy.Target;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class EasyTest {

    @Test
    public void test1() {
        /* 生成代理的字节码 */
        byte[] bytes = ProxyGenerator.generateProxyClass("com.sun.proxy.$Proxy1", new Class[]{Target.class});

        try (FileOutputStream outputStream = new FileOutputStream("C:\\Users\\wanggh31690\\Desktop\\test.txt");) {
            outputStream.write(bytes);
        } catch (Exception e) {

        }
    }
}
