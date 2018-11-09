package spittr.data;

import spittr.Spitter;

public interface SpitterRepository {
	public void addSpitter(Spitter spitter);
	public Spitter findOne(long id);
	
}
