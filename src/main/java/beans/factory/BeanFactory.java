package beans.factory;

import beans.BeanDefinition;

public interface BeanFactory {
    BeanDefinition getBeanDefinition(String beanId);
    Object getBean(String beanId);
}
