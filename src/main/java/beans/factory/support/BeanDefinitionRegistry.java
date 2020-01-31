package beans.factory.support;


import beans.BeanDefinition;

public interface BeanDefinitionRegistry {
	BeanDefinition getBeanDefinition(String beanId);
	void registerBeanDefinition(String beanId, BeanDefinition bd);
}
