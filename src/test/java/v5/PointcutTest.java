package v5;

import aop.MethodMatcher;
import aop.aspectj.AspectJExpressionPointcut;
import org.junit.Assert;
import org.junit.Test;
import v5.entity.PetStoreService;


import java.lang.reflect.Method;


public class PointcutTest {
	@Test
	public void testPointcut() throws Exception {
		
		String expression = "execution(* v5.entity.*.placeOrder(..))";
		
		AspectJExpressionPointcut pc = new AspectJExpressionPointcut();
		pc.setExpression(expression);
		
		MethodMatcher mm = pc.getMethodMatcher();
		
		{
			Class<?> targetClass = PetStoreService.class;
			
			Method method1 = targetClass.getMethod("placeOrder");
			Assert.assertTrue(mm.matches(method1));
			
			Method method2 = targetClass.getMethod("getAccountDao");
			Assert.assertFalse(mm.matches(method2));
		}
		
		{
			Class<?> targetClass = v4.entity.PetStoreService.class;
		
			Method method = targetClass.getMethod("getAccountDao");
			Assert.assertFalse(mm.matches(method));
		}
		
	}
}
