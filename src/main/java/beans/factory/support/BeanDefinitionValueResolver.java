package beans.factory.support;

import beans.factory.config.RuntimeBeanReference;
import beans.factory.config.TypedStringValue;

public class BeanDefinitionValueResolver {
    private final DefaultBeanFactory beanFactory;

    public BeanDefinitionValueResolver(
            DefaultBeanFactory beanFactory) {

        this.beanFactory = beanFactory;
    }

    public Object resolveValueIfNecessary(Object value) {

        if (value instanceof RuntimeBeanReference) {
            RuntimeBeanReference ref = (RuntimeBeanReference) value;
            String refName = ref.getBeanName();
            Object bean = this.beanFactory.getBean(refName);
            return bean;

        }else if (value instanceof TypedStringValue) {
            return ((TypedStringValue) value).getValue();
        } else{
            //TODO
            throw new RuntimeException("the value " + value +" has not implemented");
        }
    }
}
