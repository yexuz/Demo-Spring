package test.spring03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class CDPlayer implements MediaPlayer {

	
	private CompactDisc compactDisc;
	
	
	
	public CDPlayer(CompactDisc cd) {
		this.compactDisc = cd;
	}
	

	public CompactDisc getCompactDisc() {
		return compactDisc;
	}

	@Autowired
	@Qualifier("blankDisc3")
	public void setCompactDisc(CompactDisc compactDisc) {
		this.compactDisc = compactDisc;
	}


	public CDPlayer() {}
	
	public void play() {
		compactDisc.play();

	}

}
