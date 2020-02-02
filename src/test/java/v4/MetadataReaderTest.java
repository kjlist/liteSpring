package v4;


import core.annotation.AnnotationAttributes;
import core.io.ClassPathResource;
import core.type.AnnotationMetadata;
import core.type.classreading.MetadataReader;
import core.type.classreading.SimpleMetadataReader;
import org.junit.Assert;
import org.junit.Test;
import stereotype.Component;


import java.io.IOException;

public class MetadataReaderTest {
	@Test
	public void testGetMetadata() throws IOException {
		ClassPathResource resource = new ClassPathResource("v4/entity/PetStoreService.class");

		MetadataReader reader = new SimpleMetadataReader(resource);
		//注意：不需要单独使用ClassMetadata
		//ClassMetadata clzMetadata = reader.getClassMetadata();
		AnnotationMetadata amd = reader.getAnnotationMetadata();

		String annotation = Component.class.getName();

		Assert.assertTrue(amd.hasAnnotation(annotation));
		AnnotationAttributes attributes = amd.getAnnotationAttributes(annotation);
		Assert.assertEquals("petStore", attributes.get("value"));

		//注：下面对class metadata的测试并不充分
		Assert.assertFalse(amd.isAbstract());
		Assert.assertFalse(amd.isFinal());
		Assert.assertEquals("v4.entity.PetStoreService", amd.getClassName());

	}
}
