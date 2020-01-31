package v1;

import beans.BeanDefinition;
import beans.factory.BeanCreationException;
import beans.factory.BeanDefinitionStoreException;
import beans.factory.support.DefaultBeanFactory;
import beans.factory.xml.XmlBeanDefinitionReader;
import io.ClassPathResource;
import org.junit.Before;
import v1.entity.PetStoreService;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BeanFactoryTest {
    DefaultBeanFactory factory;
    XmlBeanDefinitionReader reader;
    @Before
    public void setUp(){
        this.factory = new DefaultBeanFactory();
        this.reader = new XmlBeanDefinitionReader(this.factory);
    }

    @Test
    public void testGetBean(){
        reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
        BeanDefinition bd = factory.getBeanDefinition("petStore");
        Assert.assertEquals("v1.entity.PetStoreService",bd.getBeanClassName());


        assertTrue(bd.isSingleton());

        assertFalse(bd.isPrototype());

        assertEquals(BeanDefinition.SCOPE_DEFAULT,bd.getScope());


        PetStoreService petStoreService = (PetStoreService) factory.getBean("petStore");
        Assert.assertNotNull(petStoreService);

        PetStoreService petStoreService1 = (PetStoreService)factory.getBean("petStore");

        assertTrue(petStoreService.equals(petStoreService1));
    }


    @Test
    public void testInvalidBean(){
        reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
        try{
            factory.getBean("invalidBean");
        }catch(BeanCreationException e){
            return;
        }
        Assert.fail("expect BeanCreationException ");
    }

    @Test
    public void testInvalidXML(){
        try{
            reader.loadBeanDefinitions(new ClassPathResource("xxx.xml"));
        }catch(BeanDefinitionStoreException e){
            return;
        }
        Assert.fail("expect BeanDefinitionStoreException");
    }
}
