package com.nome;

import java.beans.PropertyVetoException;
import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@SpringBootApplication
//@EnableAspectJAutoProxy
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	/**
	 * 
	 * @Title: dataSource @Description: TODO @param @return @return
	 * DataSource @throws
	 */
	@Bean
	public DataSource dataSource() {

		com.mchange.v2.c3p0.ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/app_cat?useUnicode=true&amp;charaterEncoding=utf-8&"
				+ "zeroDateTimeBehavior=convertToNull");
		ds.setUser("root");
		ds.setPassword("123456");// elecon
		try {
			ds.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ds.setAcquireIncrement(5);
		ds.setInitialPoolSize(10);
		ds.setMinPoolSize(5);
		ds.setMaxPoolSize(60);
		ds.setMaxIdleTime(120);
		return ds;
	}

	/**
	 * 
	 * @Title: sessionFactory @Description: TODO @param @return @return
	 * SqlSessionFactoryBean @throws
	 */
	@Bean
	public SqlSessionFactoryBean sessionFactory() {

		SqlSessionFactoryBean sFactoryBean = new SqlSessionFactoryBean();
		sFactoryBean.setDataSource(dataSource());

		String packageSearchPath = "classpath*:mappers/*.xml";
		Resource[] resources = null;
		try {
			resources = new PathMatchingResourcePatternResolver().getResources(packageSearchPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sFactoryBean.setMapperLocations(resources);
		sFactoryBean.setTypeAliasesPackage("com.nome.po");
		
		return sFactoryBean;
	}

	/**
	 * 
	 * @Title: sessionTemplate @Description: TODO @param @return @return
	 * SqlSessionTemplate @throws
	 */
	@Bean
	public SqlSessionTemplate sessionTemplate() {

		SqlSessionTemplate sqlSessionTemplate = null;
		try {
			sqlSessionTemplate = new SqlSessionTemplate(sessionFactory().getObject());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlSessionTemplate;
	}

	/**
	 * 
	 * @Title: characterEncodingFilter @Description: TODO @param @return @return
	 * CharacterEncodingFilter @throws
	 */
	@Bean
	public CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		return filter;
	}

	public static void main(String[] args) throws Exception {

		SpringApplication.run(Application.class, args);

	}

}
