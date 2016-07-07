package com.myblogspro.admin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Map;
import java.util.logging.Logger;

/**
 * @author Jitendra Singh.
 */
@Configuration
@ConfigurationProperties(prefix = "url", locations = "classpath:config/urlMappings.yml")
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	private static Logger logger = Logger.getLogger(WebMvcConfig.class.getName());

	private Map<String, String> mappings;

	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		logger.config("Simple Url handler configuring");
		if (!ObjectUtils.isEmpty(mappings)) {
			logger.config("Static url mappings fetched. " + mappings.toString());
			mappings.forEach(registry::addRedirectViewController);
		}
	}

	public Map<String, String> getMappings() {
		return mappings;
	}

	public WebMvcConfig setMappings(Map<String, String> mappings) {
		this.mappings = mappings;
		return this;
	}

}
