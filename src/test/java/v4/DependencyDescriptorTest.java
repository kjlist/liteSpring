package v4;

import beans.factory.config.DependencyDescriptor;
import beans.factory.support.DefaultBeanFactory;
import beans.factory.xml.XmlBeanDefinitionReader;
import core.io.ClassPathResource;
import core.io.Resource;
import org.junit.Assert;
import org.junit.Test;
import v4.entity.AccountDao;
import v4.entity.PetStoreService;


import java.lang.reflect.Field;

public class DependencyDescriptorTest {

	@Test
	public void testResolveDependency() throws Exception {
		
		DefaultBeanFactory factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		Resource resource = new ClassPathResource("petstore-v4.xml");
		reader.loadBeanDefinitions(resource);
		
		Field f = PetStoreService.class.getDeclaredField("accountDao");
		DependencyDescriptor descriptor = new DependencyDescriptor(f,true);
		Object o = factory.resolveDependency(descriptor);
		Assert.assertTrue(o instanceof AccountDao);
	}

}
