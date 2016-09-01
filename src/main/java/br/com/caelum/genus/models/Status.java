package br.com.caelum.genus.models;

public enum Status {
    TO_START,
    BEGAN,
    ONGOING,
    GIVE_UP,
    DISMISSED,
    DELAYED,
    READY;
	public String getName() { 
		return name(); 
	}
}
