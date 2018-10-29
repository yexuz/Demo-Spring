package test.spring02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages= {"test.spring01",})
//@ComponentScan(basePackageClasses= {SgtPeppers.class,})
public class CDPlayerConfig {

	@Bean(name="ss")
	public CompactDisc sgtPeppers() {
		return new SgtPeppers();
	}
//	
//	@Bean
//	public MediaPlayer cdPlayer() {
//		return new CDPlayer();
//	}
	@Bean
	public MediaPlayer cdPlayer(CompactDisc compactDisc) {
		CDPlayer cdPlayer = new CDPlayer(compactDisc);
//		System.out.println(sgtPeppers().equals(compactDisc));
		
		return cdPlayer;
	}
	
}
