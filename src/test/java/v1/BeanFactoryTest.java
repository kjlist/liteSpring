package v1;

import beans.BeanDefinition;
import beans.factory.BeanCreationException;
import beans.factory.BeanDefinitionStoreException;
import beans.factory.BeanFactory;
import beans.factory.support.DefaultBeanFactory;
import v1.entity.PetStoreService;
import org.junit.Assert;
import org.junit.Test;

public class BeanFactoryTest {


    @Test
    public void testGetBean(){
        BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");
        BeanDefinition bd = factory.getBeanDefinition("petStore");
        Assert.assertEquals("v1.entity.PetStoreService",bd.getBeanClassName());

        PetStoreService petStoreService = (PetStoreService) factory.getBean("petStore");
        Assert.assertNotNull(petStoreService);
    }


    @Test
    public void testInvalidBean(){
        BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");
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
            new DefaultBeanFactory("xxx.xml");
        }catch(BeanDefinitionStoreException e){
            return;
        }
        Assert.fail("expect BeanDefinitionStoreException");
    }
}
