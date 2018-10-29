package test.spring01;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages= {"test.spring01",})
@ComponentScan(basePackageClasses= {SgtPeppers.class,})
public class CDPlayerConfig {

}
