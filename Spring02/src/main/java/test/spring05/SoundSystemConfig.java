package test.spring05;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;


@Configuration
@Import({CDPlayerConfig.class})
@ImportResource(value = { "classpath:cd-config.xml"})
public class SoundSystemConfig {

	
}
