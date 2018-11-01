package test.spring02;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TrackCounter {

	
	@DeclareParents(value="test.spring02.CompactDisc+", defaultImpl=DefaultEncoreable.class)
	public static Encoreable encoreable;
	
	private Map<Integer, Integer> trackCounts = new HashMap<Integer, Integer>();
	
	@Pointcut("execution(* test.spring02.CompactDisc.playTrack(int))" + 
	"&& args(trackNumber)")
	public void trackPlayed(int trackNumber) {}
	
	@Before("trackPlayed(trackNumber)")
	public void countTrack(int trackNumber) {
		System.out.println("123456");
		int currentCount = getPlayCount(trackNumber);
		trackCounts.put(trackNumber, currentCount + 1);
		
		
	}

	public int getPlayCount(int trackNumber) {
		return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackNumber) : 0;
	}
}
