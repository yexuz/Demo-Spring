package spittr.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.ldap.core.support.BaseLdapPathContextSource;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import spittr.data.SpitterUserServcie;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
//	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		//roles("USER")等同于authorities("ROLE_USER")
//		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and().withUser("admin")
//				.password("password").roles("USER", "ADMIN");
//
//	}

//	@Autowired
//	private DataSource dataSource;
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//使用默认配置
//		auth.jdbcAuthentication().dataSource(dataSource);
		//自定义查询
//		auth.jdbcAuthentication().dataSource(dataSource)
//			.usersByUsernameQuery("select username, password, true from spittr where username=?")
//			.authoritiesByUsernameQuery("select username, 'ROLE_USER' from spittr where username=?")
//			.passwordEncoder(new StandardPasswordEncoder("53cr3t"));
		
		
		
		//基于LDAP 方法userSearchFilter()和groupSearchFilter()用来为基础LDAP查询提供过滤条件，它们分别用于搜索用户和组。
//		auth.ldapAuthentication().userSearchFilter("{uid={0}}").groupSearchFilter("{member={0}}");
//		auth.ldapAuthentication().userSearchBase("ou=people").userSearchFilter("{uid={0}}").groupSearchBase("ou=groups").groupSearchFilter("{member={0}}");
		//配置密码比对
//		auth.ldapAuthentication()
//			.userSearchBase("ou=people").userSearchFilter("{uid={0}}")
//			.groupSearchBase("ou=groups").groupSearchFilter("{member={0}}")
//			.passwordCompare();
//		默认情况下，在登录表单中提供的密码将会与用户的LDAP条目中的userPassword属性进行比对。
//		如果密码被保存在不同的属性中，可以通过passwordAttribute()方法来声明密码属性的名称
//		auth.ldapAuthentication()
//		.userSearchBase("ou=people").userSearchFilter("{uid={0}}")
//		.groupSearchBase("ou=groups").groupSearchFilter("{member={0}}")
//		.passwordCompare().passwordEncoder(new Md5PasswordEncoder()).passwordAttribute("passcode");		
		//引用远程的LDAP服务器
//		auth.ldapAuthentication()
//		.userSearchBase("ou=people").userSearchFilter("{uid={0}}")
//		.groupSearchBase("ou=groups").groupSearchFilter("{member={0}}")
//		.contextSource().url("ldap://habuma.com:389/dc=habuma,dc=com");
		//如果你没有现成的LDAP服务器供认证使用 ，只需通过root()方法指定嵌入式服务器的根前缀就可以了：
		//你不想让Spring从整个根路径下搜索LDIF文件的话，那么可以通过调用ldif()方法来明确指定加载哪个LDIF文件
//		auth.ldapAuthentication()
//		.userSearchBase("ou=people").userSearchFilter("{uid={0}}")
//		.groupSearchBase("ou=groups").groupSearchFilter("{member={0}}")
//		.contextSource().root("dc=habuma,dc=com").ldif("classpath:user.ldif");
		
		//配置自定义的用户服务
//		auth.userDetailsService(new SpitterUserServcie());
//	}


	
	//请求拦截
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		 http.authorizeRequests()
//		     .antMatchers("/spitters/me").authenticated()
//		     .antMatchers(HttpMethod.POST,"/spittles").authenticated()
//		     .antMatchers("/spitters/me2").hasAnyAuthority("ROLE_SPITTER")
//		     .antMatchers("/spitters/me3").access("hasRole('ROLE_SPITTER')")
//		     .anyRequest().permitAll()
//		     .and()
//		     .requiresChannel() //强制通道的安全性
//		     .antMatchers("/spitter/form").requiresSecure()//需要HTTPS
//		     .antMatchers("/").requiresInsecure();//我们可以使用requiresInsecure()代替requiresSecure()方法，将首页声明为始终通过HTTP传送：
//
//	}
	
	
	//认证用户 默认页面
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.formLogin().and().authorizeRequests().antMatchers("/spitters/me").hasRole("SPITTER")
//		.antMatchers(HttpMethod.POST, "/spitters").hasRole("SPITTER").anyRequest().permitAll()
//		.and().requiresChannel().antMatchers("/spitters/form").requiresSecure();
//	}

	//HTTP Basic 认证
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login").and().httpBasic().realmName("Spittr");
	}
	
	
}