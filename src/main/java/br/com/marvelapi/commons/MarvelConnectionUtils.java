package br.com.marvelapi.commons;

import com.google.common.base.Joiner;

import br.com.marvelapi.model.Credentials;

public class MarvelConnectionUtils {

	private static final String BASE_ENDPOINT = "http://gateway.marvel.com/v1/public/";
	private static final String BASE_PARAMETERS = "?apikey={0}&hash={1}&ts={2}&limit={3}";

	public static String getEndpointFrom(MarvelEndpointEnum marvelEndpoint, Credentials credenciais, Integer limit) {
		String parameters = BASE_PARAMETERS.replace("{0}", credenciais.getPublicKey())
										   .replace("{1}", credenciais.getHash())
										   .replace("{2}", String.valueOf(credenciais.getTimeStamp()))
										   .replace("{3}", String.valueOf(limit));

		String endepoint = Joiner.on("").join(BASE_ENDPOINT, marvelEndpoint.toLowerCase(), parameters);

		return endepoint;
	}
}
