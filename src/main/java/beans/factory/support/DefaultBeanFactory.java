package beans.factory.support;

import beans.BeanDefinition;
import beans.factory.BeanCreationException;
import beans.factory.BeanDefinitionStoreException;
import beans.factory.BeanFactory;
import beans.factory.config.ConfigurableBeanFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import util.ClassUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultBeanFactory
    extends DefaultSingletonBeanRegistry
        implements
        BeanDefinitionRegistry,
        ConfigurableBeanFactory {

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(64);

    private ClassLoader beanClassLoader;

    public DefaultBeanFactory() {

    }
    public BeanDefinition getBeanDefinition(String beanId) {
        return this.beanDefinitionMap.get(beanId);
    }

    public void registerBeanDefinition(String beanId, BeanDefinition bd) {
        this.beanDefinitionMap.put(beanId,bd);
    }

//    public Object getBean(String beanId) {
//        BeanDefinition bd = this.getBeanDefinition(beanId);
//        if(bd == null){
//            throw new BeanCreationException("BeanCreationException");
//        }
//        ClassLoader cl = this.getBeanClassLoader();
//        String beanClassName = bd.getBeanClassName();
//        try {
//            Class<?> clz = cl.loadClass(beanClassName);
//            return clz.newInstance();
//        } catch (Exception e) {
//            throw new BeanCreationException("create bean for "+ beanClassName +" failed",e);
//        }
//    }


    public Object getBean(String beanID) {
        BeanDefinition bd = this.getBeanDefinition(beanID);
        if(bd == null){
            return null;
        }

        if(bd.isSingleton()){
            Object bean = this.getSingleton(beanID);
            if(bean == null){
                bean = createBean(bd);
                this.registerSingleton(beanID, bean);
            }
            return bean;
        }
        return createBean(bd);
    }
    private Object createBean(BeanDefinition bd) {
        ClassLoader cl = this.getBeanClassLoader();
        String beanClassName = bd.getBeanClassName();
        try {
            Class<?> clz = cl.loadClass(beanClassName);
            return clz.newInstance();
        } catch (Exception e) {
            throw new BeanCreationException("create bean for "+ beanClassName +" failed",e);
        }
    }
    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.beanClassLoader = beanClassLoader;
    }

    public ClassLoader getBeanClassLoader() {
        return (this.beanClassLoader != null ? this.beanClassLoader : ClassUtils.getDefaultClassLoader());
    }
}
