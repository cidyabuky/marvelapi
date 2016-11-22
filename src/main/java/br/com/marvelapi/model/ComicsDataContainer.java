package br.com.marvelapi.model;

import java.util.List;

public class ComicsDataContainer extends DefaultDataContainer {

	private static final long serialVersionUID = -7015778104295647640L;

	private List<Comics> results;

	public ComicsDataContainer() {
	}

	public List<Comics> getResults() {
		return results;
	}

	public void setResults(List<Comics> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "CharacterDataContainer [results=" + results + "]";
	}

}
