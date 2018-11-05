//package spittr.config;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration.Dynamic;
//
//import org.springframework.web.WebApplicationInitializer;
//
//import spittr.filter.MyFilter;
//import spittr.serlvet.MyServlet;
//
//public class MyServletInitializer implements WebApplicationInitializer {
//
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		// 定义servlet
//		Dynamic myServlet = servletContext.addServlet("myServlet", MyServlet.class);
//
//		// 映射servlet
//		myServlet.addMapping("/custom/**");
//
//		
//		// 注册一个filter
//	    javax.servlet.FilterRegistration.Dynamic filter = servletContext.addFilter("myFilter", MyFilter.class);
//	    // 添加映射
//	    filter.addMappingForUrlPatterns(null, false, "/custom/*");
//
//	}
//
//}
