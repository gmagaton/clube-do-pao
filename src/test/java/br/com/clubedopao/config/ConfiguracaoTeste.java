//package br.com.clubedopao.config;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableJpaRepositories("br.com.clubedopao")
//@EnableTransactionManagement
//public class ConfiguracaoTeste {
//
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
//			DataSource dataSource) {
//		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
//		emf.setPackagesToScan("br.com.clubedopao.modelo");
//		emf.setDataSource(dataSource);
//		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		emf.setJpaVendorAdapter(vendorAdapter);
//		emf.setJpaProperties(jpaProperties());
//		return emf;
//	}
//	
//	Properties jpaProperties() {
//	      return new Properties() {
//	         {  // Hibernate Specific: 
//	            setProperty("hibernate.hbm2ddl.auto", "update");
//	            setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
//	            setProperty("hibernate.show_sql", "true");
//	            setProperty("hibernate.format_sql", "true");
//	         }
//	      };
//	   }
//
//	@Bean
//	public DataSource dataSource() {
//		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//		return builder.setType(EmbeddedDatabaseType.HSQL).build();
//	}
//
//	@Bean
//	public JpaTransactionManager transactionManager(
//			final LocalContainerEntityManagerFactoryBean emf) {
//		return new JpaTransactionManager(emf.getObject());
//	}
//
//}
