package beans.factory;


import java.util.List;

public interface BeanFactory {
    Object getBean(String beanId);
    Class<?> getType(String name) throws NoSuchBeanDefinitionException;
    List<Object> getBeansByType(Class<?> type);
}
