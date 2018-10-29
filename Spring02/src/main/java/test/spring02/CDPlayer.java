package test.spring02;

import org.springframework.beans.factory.annotation.Autowired;


public class CDPlayer implements MediaPlayer {

	private CompactDisc cd;
	
	@Autowired
	public CDPlayer(CompactDisc cd) {
		this.cd = cd;
	}
	
	@Autowired
	public void SetCompactDisc(CompactDisc cd) {
		this.cd = cd;
	}
	
	public CDPlayer() {}
	
	public void play() {
		cd.play();

	}

}
