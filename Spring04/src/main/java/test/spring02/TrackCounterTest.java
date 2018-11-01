package test.spring02;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes= TrackCounterConfig.class)
@ContextConfiguration(locations= "classpath:application2.xml")
public class TrackCounterTest {
	private static final CompactDisc Encoreable = null;

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Autowired
	private CompactDisc cd;
	
	@Autowired
	private TrackCounter counter;
	
	@Test
	public void testTrackCounter( ) {
		cd.play();
		cd.playTrack(1);
		Encoreable e = (Encoreable) cd;
		e.performEncore();
//		cd.playTrack(2);
//		cd.playTrack(3);
//		cd.playTrack(4);
//		cd.playTrack(1);
//		cd.playTrack(3);
//		cd.playTrack(3);
//		cd.playTrack(0);
		
		assertEquals(1, counter.getPlayCount(1));
//		assertEquals(2, counter.getPlayCount(1));
//		assertEquals(1, counter.getPlayCount(2));
//		assertEquals(4, counter.getPlayCount(1));
//		assertEquals(0, counter.getPlayCount(5));
//		assertEquals(1, counter.getPlayCount(1));
//		assertEquals(1, counter.getPlayCount(1));

	}

}
