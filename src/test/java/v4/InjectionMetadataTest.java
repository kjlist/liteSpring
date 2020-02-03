package v4;

import beans.factory.annotation.AutowiredFieldElement;
import beans.factory.annotation.InjectionElement;
import beans.factory.annotation.InjectionMetadata;
import beans.factory.support.DefaultBeanFactory;
import beans.factory.xml.XmlBeanDefinitionReader;
import core.io.ClassPathResource;
import core.io.Resource;
import org.junit.Assert;
import org.junit.Test;
import v4.entity.AccountDao;
import v4.entity.ItemDao;
import v4.entity.PetStoreService;


import java.lang.reflect.Field;
import java.util.LinkedList;

public class InjectionMetadataTest {

	@Test
	public void testInjection() throws Exception {
		
		DefaultBeanFactory factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		Resource resource = new ClassPathResource("petstore-v4.xml");
		reader.loadBeanDefinitions(resource);
		
		Class<?> clz = PetStoreService.class;
		LinkedList<InjectionElement> elements = new LinkedList<InjectionElement>();
		
		{
			Field f = PetStoreService.class.getDeclaredField("accountDao");
			InjectionElement injectionElem = new AutowiredFieldElement(f,true,factory);
			elements.add(injectionElem);
		}
		{
			Field f = PetStoreService.class.getDeclaredField("itemDao");
			InjectionElement injectionElem = new AutowiredFieldElement(f,true,factory);
			elements.add(injectionElem);
		}
		
		InjectionMetadata metadata = new InjectionMetadata(clz,elements);
		
		PetStoreService petStore = new PetStoreService();
		
		metadata.inject(petStore);
		
		Assert.assertTrue(petStore.getAccountDao() instanceof AccountDao);
		
		Assert.assertTrue(petStore.getItemDao() instanceof ItemDao);
		
	}
}
