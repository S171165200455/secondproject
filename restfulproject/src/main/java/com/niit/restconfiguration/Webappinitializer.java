package com.niit.restconfiguration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Webappinitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected String[] getServletMappings() {
	return new String[]{"/"};
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
	// TODO Auto-generated method stub
	return new Class[]{Webapp.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
	// TODO Auto-generated method stub
	return null;
	}
}
