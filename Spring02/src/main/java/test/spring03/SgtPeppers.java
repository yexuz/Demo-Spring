package test.spring03;

import org.springframework.stereotype.Component;

public class SgtPeppers implements CompactDisc {

	private String title = "Hello";
	private String artist = "也_xu";
	
	public void play() {
		System.out.println(title + " World by " + artist);
//		System.out.println("Hello World");
	}

}
