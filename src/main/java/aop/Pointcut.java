package aop;



public interface Pointcut {
	MethodMatcher getMethodMatcher();
	String getExpression();
}
