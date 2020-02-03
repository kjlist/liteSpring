package beans.factory.support;


import beans.BeanDefinition;
import beans.ConstructorArgument;
import beans.PropertyValue;

import java.util.ArrayList;
import java.util.List;

public class GenericBeanDefinition implements BeanDefinition {
	private String id;
	private String beanClassName;
	private boolean singleton = true;
	private boolean prototype = false;
	private String scope = SCOPE_DEFAULT;
	private Class<?> beanClass;
	private ConstructorArgument constructorArgument = new ConstructorArgument();
	List<PropertyValue> propertyValues = new ArrayList<PropertyValue>();
	public GenericBeanDefinition(String id, String beanClassName) {
		this.id = id;
		this.beanClassName = beanClassName;
	}
	public GenericBeanDefinition() {

	}
	public boolean isSingleton() {
		return this.singleton;
	}
	public boolean isPrototype() {
		return this.prototype;
	}
	public String getScope() {
		return this.scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
		this.singleton = SCOPE_SINGLETON.equals(scope) || SCOPE_DEFAULT.equals(scope);
		this.prototype = SCOPE_PROTOTYPE.equals(scope);

	}

	public void setBeanClassName(String className){
		this.beanClassName = className;
	}

	public String getBeanClassName() {
		return this.beanClassName;
	}

	public List<PropertyValue> getPropertyValues() {
		return this.propertyValues;
	}

	public ConstructorArgument getConstructorArgument() {
		return this.constructorArgument;
	}

	public String getID() {
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}

	public boolean hasConstructorArgumentValues() {
		return !this.constructorArgument.isEmpty();
	}

	public Class<?> resolveBeanClass(ClassLoader classLoader) throws ClassNotFoundException{
		String className = getBeanClassName();
		if (className == null) {
			return null;
		}
		Class<?> resolvedClass = classLoader.loadClass(className);
		this.beanClass = resolvedClass;
		return resolvedClass;
	}
	public Class<?> getBeanClass() throws IllegalStateException {
		if(this.beanClass == null){
			throw new IllegalStateException(
					"Bean class name [" + this.getBeanClassName() + "] has not been resolved into an actual Class");
		}
		return this.beanClass;
	}
	public boolean hasBeanClass(){
		return this.beanClass != null;
	}
}
