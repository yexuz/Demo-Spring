package test.spring03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages= {"test.spring01",})
//@ComponentScan(basePackageClasses= {SgtPeppers.class,})
public class CDPlayerConfig {


	public CompactDisc sgtPeppers() {
		return new SgtPeppers();
	}
//	
//	@Bean
//	public MediaPlayer cdPlayer() {
//		return new CDPlayer();
//	}

	public MediaPlayer cdPlayer(CompactDisc compactDisc) {
		CDPlayer cdPlayer = new CDPlayer(compactDisc);
//		System.out.println(sgtPeppers().equals(compactDisc));
		
		return cdPlayer;
	}
	
}
