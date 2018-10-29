package test.spring01;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Autowired
	private CompactDisc cd;
	
	@Autowired
	private MediaPlayer player;
	
	@Test
	public void cdShouldNotBeNull() {	
		assertNotNull(cd);
	}
	
	@Test
	public void play() {
		player.play();
//		System.out.println(systemOutRule.getLog());
		assertEquals("Hello World by 也_xu\r\n", systemOutRule.getLog());
	}
	
	
	
	
}
