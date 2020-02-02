package v4;

import beans.BeanDefinition;
import beans.factory.support.DefaultBeanFactory;
import beans.factory.xml.XmlBeanDefinitionReader;
import context.annotation.ScannedGenericBeanDefinition;
import core.annotation.AnnotationAttributes;
import core.io.ClassPathResource;
import core.io.Resource;
import core.type.AnnotationMetadata;
import org.junit.Assert;
import org.junit.Test;
import stereotype.Component;

public class XmlBeanDefinitionReaderTest {

	@Test
	public void testParseScanedBean(){

		DefaultBeanFactory factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		Resource resource = new ClassPathResource("petstore-v4.xml");
		reader.loadBeanDefinitions(resource);
		String annotation = Component.class.getName();

		//下面的代码和ClassPathBeanDefinitionScannerTest重复，该怎么处理？
		{
			BeanDefinition bd = factory.getBeanDefinition("petStore");
			Assert.assertTrue(bd instanceof ScannedGenericBeanDefinition);
			ScannedGenericBeanDefinition sbd = (ScannedGenericBeanDefinition)bd;
			AnnotationMetadata amd = sbd.getMetadata();


			Assert.assertTrue(amd.hasAnnotation(annotation));
			AnnotationAttributes attributes = amd.getAnnotationAttributes(annotation);
			Assert.assertEquals("petStore", attributes.get("value"));
		}
		{
			BeanDefinition bd = factory.getBeanDefinition("accountDao");
			Assert.assertTrue(bd instanceof ScannedGenericBeanDefinition);
			ScannedGenericBeanDefinition sbd = (ScannedGenericBeanDefinition)bd;
			AnnotationMetadata amd = sbd.getMetadata();
			Assert.assertTrue(amd.hasAnnotation(annotation));
		}
		{
			BeanDefinition bd = factory.getBeanDefinition("itemDao");
			Assert.assertTrue(bd instanceof ScannedGenericBeanDefinition);
			ScannedGenericBeanDefinition sbd = (ScannedGenericBeanDefinition)bd;
			AnnotationMetadata amd = sbd.getMetadata();
			Assert.assertTrue(amd.hasAnnotation(annotation));
		}
	}

}
