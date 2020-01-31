package v1;

import io.ClassPathResource;
import io.FileSystemResource;
import io.Resource;
import org.junit.Assert;
import org.junit.Test;


import java.io.InputStream;

public class ResourceTest {

	@Test
	public void testClassPathResource() throws Exception {

		Resource r = new ClassPathResource("petstore-v1.xml");

		InputStream is = null;

		try {
			is = r.getInputStream();
			// 注意：这个测试其实并不充分！！
			Assert.assertNotNull(is);
		} finally {
			if (is != null) {
				is.close();
			}
		}

	}

	@Test
	public void testFileSystemResource() throws Exception {

//		Resource r = new FileSystemResource("E:\\code\\liteSpring\\src\\test\\resources\\petstore-v1.xml");
//
//		InputStream is = null;
//
//		try {
//			is = r.getInputStream();
//			// 注意：这个测试其实并不充分！！
//			Assert.assertNotNull(is);
//		} finally {
//			if (is != null) {
//				is.close();
//			}
//		}

	}

}
