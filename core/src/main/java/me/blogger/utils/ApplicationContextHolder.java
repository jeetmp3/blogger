package me.blogger.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

/**
 * @author Jitendra Singh.
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware {

	static ApplicationContext context;


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

	public static Object getBean(String name) throws BeansException {
		return context.getBean(name);
	}

	public static <T> T getBean(String name, Class<T> requiredType) throws BeansException {
		return context.getBean(name, requiredType);
	}

	public static <T> T getBean(Class<T> requiredType) throws BeansException {
		return context.getBean(requiredType);
	}

	public static Object getBean(String name, Object... args) throws BeansException {
		return context.getBean(name, args);
	}

	public static <T> T getBean(Class<T> requiredType, Object... args) throws BeansException {
		return context.getBean(requiredType, args);
	}

	public static boolean containsBean(String name) {
		return context.containsBean(name);
	}

	public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
		return context.isSingleton(name);
	}

	public static boolean isPrototype(String name) throws NoSuchBeanDefinitionException {
		return context.isPrototype(name);
	}

	public static boolean isTypeMatch(String name, ResolvableType typeToMatch) throws NoSuchBeanDefinitionException {
		return context.isTypeMatch(name, typeToMatch);
	}

	public static boolean isTypeMatch(String name, Class<?> typeToMatch) throws NoSuchBeanDefinitionException {
		return context.isTypeMatch(name, typeToMatch);
	}

	public static Class<?> getType(String name) throws NoSuchBeanDefinitionException {
		return context.getType(name);
	}

	public static String[] getAliases(String name) {
		return context.getAliases(name);
	}
}
