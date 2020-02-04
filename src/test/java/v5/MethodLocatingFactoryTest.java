package v5;

import aop.config.MethodLocatingFactory;
import beans.factory.support.DefaultBeanFactory;
import beans.factory.xml.XmlBeanDefinitionReader;
import core.io.ClassPathResource;
import core.io.Resource;
import org.junit.Assert;
import org.junit.Test;
import tx.TransactionManager;


import java.lang.reflect.Method;


public class MethodLocatingFactoryTest {
	@Test
	public void testGetMethod() throws Exception {
		DefaultBeanFactory beanFactory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		Resource resource = new ClassPathResource("petstore-v5.xml");
		reader.loadBeanDefinitions(resource);

		MethodLocatingFactory methodLocatingFactory = new MethodLocatingFactory();
		methodLocatingFactory.setTargetBeanName("tx");
		methodLocatingFactory.setMethodName("start");
		methodLocatingFactory.setBeanFactory(beanFactory);

		Method m = methodLocatingFactory.getObject();

		Assert.assertTrue(TransactionManager.class.equals(m.getDeclaringClass()));
		Assert.assertTrue(m.equals(TransactionManager.class.getMethod("start")));

	}
}
