package v3;

import beans.BeanDefinition;
import beans.factory.support.ConstructorResolver;
import beans.factory.support.DefaultBeanFactory;
import beans.factory.xml.XmlBeanDefinitionReader;
import io.ClassPathResource;
import io.Resource;
import org.junit.Assert;
import org.junit.Test;
import v3.entity.PetStoreService;


public class ConstructorResolverTest {

	@Test
	public void testAutowireConstructor() {

		DefaultBeanFactory factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		Resource resource = new ClassPathResource("petstore-v3.xml");
		reader.loadBeanDefinitions(resource);

		BeanDefinition bd = factory.getBeanDefinition("petStore");

		ConstructorResolver resolver = new ConstructorResolver(factory);

		PetStoreService petStore = (PetStoreService)resolver.autowireConstructor(bd);

		// 验证参数version 正确地通过此构造函数做了初始化
		// PetStoreService(AccountDao accountDao, ItemDao itemDao,int version)
		Assert.assertEquals(1, petStore.getVersion());

		Assert.assertNotNull(petStore.getAccountDao());
		Assert.assertNotNull(petStore.getItemDao());


	}
}
