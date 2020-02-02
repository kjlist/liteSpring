package v3;

import beans.BeanDefinition;
import beans.ConstructorArgument;
import beans.factory.config.RuntimeBeanReference;
import beans.factory.config.TypedStringValue;
import beans.factory.support.DefaultBeanFactory;
import beans.factory.xml.XmlBeanDefinitionReader;
import io.ClassPathResource;
import io.Resource;
import org.junit.Assert;
import org.junit.Test;


import java.util.List;

public class BeanDefinitionTestV3 {

	@Test
	public void testConstructorArgument() {
		
		DefaultBeanFactory factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		Resource resource = new ClassPathResource("petstore-v3.xml");
		reader.loadBeanDefinitions(resource);

		BeanDefinition bd = factory.getBeanDefinition("petStore");
		Assert.assertEquals("v3.entity.PetStoreService", bd.getBeanClassName());
		
		ConstructorArgument args = bd.getConstructorArgument();
		List<ConstructorArgument.ValueHolder> valueHolders = args.getArgumentValues();
		
		Assert.assertEquals(3, valueHolders.size());
		
		RuntimeBeanReference ref1 = (RuntimeBeanReference)valueHolders.get(0).getValue();
		Assert.assertEquals("accountDao", ref1.getBeanName());
		RuntimeBeanReference ref2 = (RuntimeBeanReference)valueHolders.get(1).getValue();
		Assert.assertEquals("itemDao", ref2.getBeanName());
		
		TypedStringValue strValue = (TypedStringValue)valueHolders.get(2).getValue();
		Assert.assertEquals( "1", strValue.getValue());
	}

}
