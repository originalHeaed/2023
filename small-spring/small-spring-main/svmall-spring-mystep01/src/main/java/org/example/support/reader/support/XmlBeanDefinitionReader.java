package org.example.support.reader.support;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.example.Exception.BeansException;
import org.example.config.BeanDefinition;
import org.example.config.BeanReference;
import org.example.config.PropertyValue;
import org.example.io.Resource;
import org.example.io.ResourceLoader;
import org.example.support.reader.support.AbstractBeanDefinitionReader;
import org.example.support.register.BeanDefinitionRegister;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

/**
 * 以 xml 信息读取 beanDefinition 对象
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegister beanDefinitionRegister) {
        super(beanDefinitionRegister);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegister beanDefinitionRegister, ResourceLoader resourceLoader) {
        super(beanDefinitionRegister, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        /* 特殊情况判断 */
        if (resources.length == 0) return;
        for (Resource resource : resources) {
            try {
                doLoadBeanDefinitions(resource.getInputStream());
            } catch (Exception e) {
                throw new BeansException("parsing xml document is wrong from:" + resource, e);
            }
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        Resource resource = getResourceLoader().getResource(location);
        loadBeanDefinitions(resource);
    }

    /**
     * 从输入流中获取 xml 数据
     *
     * @param inputStream
     */
    private void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException, BeansException {
        Document document = XmlUtil.readXML(inputStream);
        Element root = document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        /* 遍历所有节点 */
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            /* 1.排除非 bean 节点 */
            if (!(node instanceof Element) || !"bean".equals(node.getNodeName())) continue;
            /* 2.解析 bean 标签 */
            Element ele = (Element) node;
            String id = ele.getAttribute("id");
            String name = ele.getAttribute("name");
            String ref = ele.getAttribute("class");
            Class<?> aClass = Class.forName(ref);
            String beanName = StrUtil.isNotBlank(id) ? id : name;
            if (StrUtil.isBlank(beanName)) {
                beanName = StrUtil.lowerFirst(aClass.getSimpleName());
            }
            /* 3.创建 BeanDefinition */
            BeanDefinition beanDefinition = new BeanDefinition(aClass);
            /* 4.读取属性并填充 */
            for (int j = 0; j < node.getChildNodes().getLength(); j++) {
                Node childNode = node.getChildNodes().item(j);
                // 筛选
                if (!(childNode instanceof Element) || !"property".equals(childNode.getNodeName())) continue;
                // 获取属性
                Element childEle = (Element) childNode;
                String chileName = childEle.getAttribute("name");
                String chileVal = childEle.getAttribute("value");
                String chileRef = childEle.getAttribute("ref");
                Object val = StrUtil.isNotBlank(chileVal) ? chileVal : new BeanReference(chileRef);
                PropertyValue pv = new PropertyValue(chileName, val);
                beanDefinition.getPropertyValues().addPropertyValue(pv);
            }
            /* 去重判断 */
            if (getBeanDefinitionRegister().containBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            getBeanDefinitionRegister().registerBeanDefinition(beanName, beanDefinition);
        }
    }
}
