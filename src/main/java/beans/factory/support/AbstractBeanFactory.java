package beans.factory.support;


import beans.BeanDefinition;
import beans.factory.BeanCreationException;
import beans.factory.config.ConfigurableBeanFactory;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {
	protected abstract Object createBean(BeanDefinition bd) throws BeanCreationException;
}
