package br.com.marvelapi.commons;

public enum MarvelEndpointEnum {

	CHARACTERS,
	COMICS,
	CREATORS,
	EVENTS,
	SERIES,
	STORIES;
	
	public String toLowerCase(){
		return name().toLowerCase();
	}
}
