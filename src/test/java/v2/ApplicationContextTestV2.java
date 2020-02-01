package v2;

import context.ApplicationContext;
import context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
import v2.entity.AccountDao;
import v2.entity.ItemDao;
import v2.entity.PetStoreService;

import static org.junit.Assert.*;

public class ApplicationContextTestV2 {

	@Test
	public void testGetBeanProperty() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v2.xml");
		PetStoreService petStore = (PetStoreService)ctx.getBean("petStore");
		
		assertNotNull(petStore.getAccountDao());
		assertNotNull(petStore.getItemDao());
		
		assertTrue(petStore.getAccountDao() instanceof AccountDao);
		assertTrue(petStore.getItemDao() instanceof ItemDao);
		
		assertEquals("kkk",petStore.getOwner());
		assertEquals(1, petStore.getVersion());
		
	}

}
