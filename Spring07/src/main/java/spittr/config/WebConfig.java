package spittr.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configurable
@EnableWebMvc
@ComponentScan("spittr.web")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}
	
//	@Bean
//	public MultipartResolver multipartResolver() {
//	    return new StandardServletMultipartResolver();
//	    
//	}
	@Bean
	public MultipartResolver multipartResolver() throws IOException {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setUploadTempDir(new FileSystemResource("/tmp/spittr/uploads"));
	    multipartResolver.setMaxUploadSize(2097152);
	    multipartResolver.setMaxInMemorySize(0);
	    return multipartResolver;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

//	 @Bean
//	 public MessageSource messageSource() {
//	 ReloadableResourceBundleMessageSource messageSource = new
//	 ReloadableResourceBundleMessageSource();
//	 messageSource.setBasename("classpath:messages.properties");
//	 messageSource.setCacheSeconds(10);
//	 return messageSource;
//	 }

//	@Bean
//	public ITemplateResolver templateResolver() {
//		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//		templateResolver.setTemplateMode("HTML5");
////		templateResolver.setTemplateMode(TemplateMode.HTML);
//		templateResolver.setPrefix("/WEB-INF/templates/");
//		templateResolver.setSuffix(".html");
//		templateResolver.setCharacterEncoding("utf-8");
//		templateResolver.setOrder(1);
//
//		templateResolver.setCacheable(false);
//		return templateResolver;
//	}
//
//	@Bean
//	public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
//		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//		templateEngine.setTemplateResolver(templateResolver);
//		return templateEngine;
//	}
//
//	@Bean
//	 public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
//		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//		viewResolver.setTemplateEngine(templateEngine);
//		viewResolver.setCharacterEncoding("utf-8");
//		return viewResolver;
//
//	}
}
