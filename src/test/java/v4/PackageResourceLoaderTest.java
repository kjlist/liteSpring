package v4;

import core.io.Resource;
import core.io.support.PackageResourceLoader;
import org.junit.Assert;
import org.junit.Test;


import java.io.IOException;

public class PackageResourceLoaderTest {

	@Test
	public void testGetResources() throws IOException {
		PackageResourceLoader loader = new PackageResourceLoader();
		Resource[] resources = loader.getResources("v4.entity");
		Assert.assertEquals(3, resources.length);
		
	}

}
