package test.spring05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
public class CDConfig {
	@Bean
	public CompactDisc sgtPeppers() {
		return new SgtPeppers();
	}
}
