package com.chenq.aspose.generator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.druid.pool.DruidDataSource;

@Component
public class Application implements ApplicationContextAware{
	
	private static final Log LOGGER = LogFactory.getLog(Application.class);
	private static ApplicationContext applicationContext;
	private static JdbcTemplate jdbcTemplate;

	public Application() {}
	
	@SuppressWarnings("static-access")
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	protected Application(ApplicationContext context) {
		applicationContext = context;
	}
	
	public static ApplicationContext getApplicationContext() {
		if (applicationContext == null) {
			throw new IllegalStateException("server dose not start");
		}
		return applicationContext;
	}
	
	public static Object getBean(String beanName) {
		return getApplicationContext().getBean(beanName);
	}
	
	public static <T> T getBean(Class<T> beanClazz) {
		return getApplicationContext().getBean(beanClazz);
	}
	
	public static JdbcTemplate getJdbcTemplate() {
		if (jdbcTemplate == null) {
			jdbcTemplate = new JdbcTemplate(applicationContext.getBean("dataSource", DruidDataSource.class));
		}
		return jdbcTemplate;  
	}
	
	public static <T> T queryForObject(String sql, Class<T> clazz) {
		try {
			return getJdbcTemplate().queryForObject(sql, clazz);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	/**
	 * 本地调试启动
	 */
	public static void debug() {
		if (applicationContext != null) {
			LOGGER.warn("Application already started!");
			return;
		}
		LOGGER.warn("*********************** WITH DEBUG(DEV) MODE ***********************");
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "spring/spring-context.xml" });
		new Application(ctx);
	}
}
