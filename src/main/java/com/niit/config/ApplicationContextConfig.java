package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.CategoryDAO;
import com.niit.dao.CategoryDAOImpl;
import com.niit.dao.ProductDAO;
import com.niit.dao.ProductDAOImpl;
import com.niit.models.Category;
import com.niit.models.Product;
import com.niit.models.Supplier;
import com.niit.models.UserDetails;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/Shopping");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		System.out.println("Datasource");
		return dataSource;

	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		System.out.println("Hibernate Properties");
		return properties;

	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(Category.class);
		sessionBuilder.addAnnotatedClasses(Product.class);
		sessionBuilder.addAnnotatedClasses(UserDetails.class);
		sessionBuilder.addAnnotatedClasses(Supplier.class);
		System.out.println("Session");
		
		return sessionBuilder.buildSessionFactory();
		
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction");
		return transactionManager;
	}

	@Autowired
	@Bean(name = "categoryDAO")
	public CategoryDAO getCategorDao(SessionFactory sessionFactory) {
		return new CategoryDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "productDAO")
	public ProductDAO getProductDao(SessionFactory sessionFactory) {
			return new ProductDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "getSuppliertDAO")
	public ProductDAO getSuppliertDAO(SessionFactory sessionFactory) {
			return new ProductDAOImpl(sessionFactory);
	}
	

}
