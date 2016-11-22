package br.com.marvelapi.model;

import java.util.List;

public class CharacterDataContainer extends DefaultDataContainer {

	private static final long serialVersionUID = -7015778104295647640L;

	private List<Characters> results;

	public CharacterDataContainer() {
	}

	public List<Characters> getResults() {
		return results;
	}

	public void setResults(List<Characters> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "CharacterDataContainer [results=" + results + "]";
	}

}
