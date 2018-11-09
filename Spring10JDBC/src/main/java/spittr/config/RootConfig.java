package spittr.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages= {"spittr"},
	excludeFilters= {
			@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)
	})
public class RootConfig {
	
	//JNDI
	@Bean
	@Profile("ds1")
	public JndiObjectFactoryBean dataSource1(){
	  JndiObjectFactoryBean jndiObjectFB = new JndiObjectFactoryBean();
	  jndiObjectFB.setJndiName("/jdbc/SpitterDS");
	  jndiObjectFB.setResourceRef(true);
	  jndiObjectFB.setProxyInterface(javax.sql.DataSource.class);
	  return jndiObjectFB;
	}
	
	//DBCP
	@Bean
	@Profile("ds2")
	public BasicDataSource dataSource2(){
	  BasicDataSource ds = new BasicDataSource();
	  ds.setDriverClassName("com.mysql.jdbc.Driver");
	  ds.setUrl("jdbc:mysql://127.0.0.1:3306/springtest?useUnicode=true&amp;characterEncoding=UTF-8");
	  ds.setUsername("root");
	  ds.setPassword("123456");
	  ds.setInitialSize(5);
	  ds.setMaxActive(10);
	  return ds;
	}
	//JDBC
	@Profile("ds3")
	public DataSource dataSource3() {
		  DriverManagerDataSource ds = new DriverManagerDataSource();
		  ds.setDriverClassName("com.mysql.jdbc.Driver");
		  ds.setUrl("jdbc:mysql://127.0.0.1:3306/springtest?useUnicode=true&amp;characterEncoding=UTF-8");
		  ds.setUsername("root");
		  ds.setPassword("123456");
		  return ds;
	}
//	//嵌入式
//	@Bean
//	@Profile("ds4")
//	public DataSource dataSource4(){
//	  return new EmbeddedDatabaseBuilder()
//	    .setType(EmbeddedDatabaseType.H2)
//	    .addScript("classpath:schema.sql")
//	    .addScript("classpath:test-data.sql")
//	    .build();
//	}

	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
