package v1;

import context.ApplicationContext;
import context.support.ClassPathXmlApplicationContext;
import io.ClassPathResource;
import org.junit.Assert;
import org.junit.Test;
import v1.entity.PetStoreService;


public class ApplicationContextTest {

	@Test
	public void testGetBean() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v1.xml");
		PetStoreService petStore = (PetStoreService)ctx.getBean("petStore");
		Assert.assertNotNull(petStore);
	}
    @Test 
	public void testGetBeanFromFileSystemContext(){
	    //注意啊，这里仍然是hardcode了一个本地路径，这是不好的实践!! 如何处理，留作作业
		/*ApplicationContext ctx = new FileSystemXmlApplicationContext("C:\\Users\\liuxin\\git-litespring\\src\\test\\resources\\petstore-v1.xml");
		PetStoreService petStore = (PetStoreService)ctx.getBean("petStore");
		Assert.assertNotNull(petStore);*/
		
	}

}
