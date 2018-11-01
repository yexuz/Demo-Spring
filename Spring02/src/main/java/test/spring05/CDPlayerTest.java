package test.spring05;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes= {SoundSystemConfig.class})
@ContextConfiguration(locations= "classpath:cd-config2.xml")
public class CDPlayerTest {

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
//	@Autowired
//	@Qualifier("sgtPeppers")
//	private CompactDisc cd;
//	
	@Autowired
	@Qualifier("blankDisc2")
	private CompactDisc cd2;
//	@Autowired
//	@Qualifier("blankDisc3")
//	private CompactDisc cd3;
	
	@Autowired
	@Qualifier("cdPlayer")
	private MediaPlayer player;
	
	
	@Test
	public void cdShouldNotBeNull() {	
//		assertNotNull(cd);
//		cd.play();
		cd2.play();
//		cd3.play();
		System.out.println(cd2);
		
	}
	
	@Test
	public void play() {
		player.play();
		System.out.println(systemOutRule.getLog());
		assertEquals("Hello World by 也_xu\r\n", systemOutRule.getLog());
	}
	
	
	
	
	
}
