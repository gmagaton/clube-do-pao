//package br.com.clubedopao.config;
//
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.UrlBasedViewResolver;
//import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
//import org.springframework.web.servlet.view.tiles2.TilesView;
//
//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = { "br.com.clubedopao.controller",
//		"br.com.clubedopao.dao", "br.com.clubedopao.service" })
//public class ViewConfig extends WebMvcConfigurerAdapter {
//
//	@Override
//	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/bootstrap/**").addResourceLocations(
//				"/bootstrap/");
//	}
//	
//	@Bean
//	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
//	public TilesConfigurer tilesConfigurer() {
//		final TilesConfigurer tilesConfigurer = new TilesConfigurer();
//		final String[] definitions = { "/WEB-INF/tiles.xml" };
//		tilesConfigurer.setDefinitions(definitions);
//		return tilesConfigurer;
//	}
//
//	@Bean
//	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
//	public UrlBasedViewResolver tilesViewResolver() {
//		UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
//		tilesViewResolver.setViewClass(TilesView.class);
//		return tilesViewResolver;
//	}
//	
//	
//	@Bean
//	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
//	public LocalValidatorFactoryBean validator() {
//		return new LocalValidatorFactoryBean();
//	}
//
// }
