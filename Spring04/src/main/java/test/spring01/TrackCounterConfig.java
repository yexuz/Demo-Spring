package test.spring01;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {

	@Bean
	public CompactDisc sgtPeppers() {
		BlankDisc cd = new BlankDisc("xxx", "yyy");
		
		List<String> tracks = new ArrayList<String>();
		tracks.add("aa");
		tracks.add("bb");
		tracks.add("cc");
		tracks.add("ddd");
		tracks.add("eee");
		tracks.add("fff");
		cd.setTracks(tracks);
		return cd;
	}
	
	@Bean
	public TrackCounter trackCounter() {
		return new TrackCounter();
	}
	
	
}	
