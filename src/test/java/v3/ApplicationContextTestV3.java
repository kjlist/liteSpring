package v3;

import context.ApplicationContext;
import context.support.ClassPathXmlApplicationContext;
import org.junit.Assert;
import org.junit.Test;
import v3.entity.PetStoreService;


public class ApplicationContextTestV3 {

	@Test
	public void testGetBeanProperty() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v3.xml");
		PetStoreService petStore = (PetStoreService)ctx.getBean("petStore");
		
		Assert.assertNotNull(petStore.getAccountDao());
		Assert.assertNotNull(petStore.getItemDao());		
		Assert.assertEquals(1, petStore.getVersion());
		
	}

}
