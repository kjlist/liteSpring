package v4;

import context.ApplicationContext;
import context.support.ClassPathXmlApplicationContext;
import org.junit.Assert;
import org.junit.Test;
import v4.entity.PetStoreService;


public class ApplicationContextTest4 {

	@Test
	public void testGetBeanProperty() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v4.xml");
		PetStoreService petStore = (PetStoreService)ctx.getBean("petStore");

		Assert.assertNotNull(petStore.getAccountDao());
		Assert.assertNotNull(petStore.getItemDao());
		
	}	
}
