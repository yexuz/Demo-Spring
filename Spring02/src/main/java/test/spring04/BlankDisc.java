package test.spring04;

import java.util.List;

import test.spring04.CompactDisc;

public class BlankDisc implements CompactDisc {

	private String title = "Hello2";
	private String artist = "也_xu2";
	private List<String> tracks;
	
	public BlankDisc(String title, String artist) {
		super();
		this.title = title;
		this.artist = artist;
	}

	public BlankDisc(String title, String artist, List<String> tracks) {
		super();
		this.title = title;
		this.artist = artist;
		this.tracks = tracks;
	}

	public void play() {
		System.out.println(title + " World by " + artist);
		if(tracks != null && tracks.size() > 0) {
			System.out.println(tracks);
		}
//		System.out.println("Hello World");
	}

}
