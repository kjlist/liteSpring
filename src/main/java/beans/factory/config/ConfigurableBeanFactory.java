package beans.factory.config;


import beans.factory.BeanFactory;

public interface ConfigurableBeanFactory extends BeanFactory {
	void setBeanClassLoader(ClassLoader beanClassLoader);
	ClassLoader getBeanClassLoader();
}
