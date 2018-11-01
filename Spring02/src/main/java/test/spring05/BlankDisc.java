package test.spring05;

import java.util.List;

import test.spring05.CompactDisc;

public class BlankDisc implements CompactDisc {

	private String title = "Hello2";
	private String artist = "也_xu2";
	private List<String> tracks;
	private String emial;
	private List<BlankDisc> blankDiscss;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public List<String> getTracks() {
		return tracks;
	}

	public void setTracks(List<String> tracks) {
		this.tracks = tracks;
	}

	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}

	@Override
	public String toString() {
		return "BlankDisc [title=" + title + ", artist=" + artist + ", tracks=" + tracks + ", emial=" + emial
				+ ", blankDiscss=" + blankDiscss + "]";
	}

	public List<BlankDisc> getBlankDiscss() {
		return blankDiscss;
	}

	public void setBlankDiscss(List<BlankDisc> blankDiscss) {
		this.blankDiscss = blankDiscss;
	}
	
	

	
}
