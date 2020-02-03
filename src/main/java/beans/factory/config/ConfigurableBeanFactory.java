package beans.factory.config;


import beans.factory.BeanFactory;

import java.util.List;

public interface ConfigurableBeanFactory extends AutowireCapableBeanFactory {
	void setBeanClassLoader(ClassLoader beanClassLoader);
	ClassLoader getBeanClassLoader();
	void addBeanPostProcessor(BeanPostProcessor postProcessor);
	List<BeanPostProcessor> getBeanPostProcessors();
}
