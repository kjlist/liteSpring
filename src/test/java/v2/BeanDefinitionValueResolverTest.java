package v2;

import beans.factory.config.RuntimeBeanReference;
import beans.factory.config.TypedStringValue;
import beans.factory.support.BeanDefinitionValueResolver;
import beans.factory.support.DefaultBeanFactory;
import beans.factory.xml.XmlBeanDefinitionReader;
import core.io.ClassPathResource;
import org.junit.Assert;
import org.junit.Test;
import v2.entity.AccountDao;

public class BeanDefinitionValueResolverTest {

	@Test
	public void testResolveRuntimeBeanReference() {
		DefaultBeanFactory factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(new ClassPathResource("petstore-v2.xml"));
		
		BeanDefinitionValueResolver resolver = new BeanDefinitionValueResolver(factory);
		
		RuntimeBeanReference reference = new RuntimeBeanReference("accountDao");
		Object value = resolver.resolveValueIfNecessary(reference);
		
		Assert.assertNotNull(value);		
		Assert.assertTrue(value instanceof AccountDao);
	}
	@Test
	public void testResolveTypedStringValue() {
		DefaultBeanFactory factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(new ClassPathResource("petstore-v2.xml"));

		BeanDefinitionValueResolver resolver = new BeanDefinitionValueResolver(factory);

		TypedStringValue stringValue = new TypedStringValue("test");
		Object value = resolver.resolveValueIfNecessary(stringValue);
		Assert.assertNotNull(value);
		Assert.assertEquals("test", value);

	}
}
