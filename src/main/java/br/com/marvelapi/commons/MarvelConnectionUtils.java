package br.com.marvelapi.commons;

import com.google.common.base.Joiner;

import br.com.marvelapi.model.Credentials;

public class MarvelConnectionUtils {

	private static final String BASE_ENDPOINT = "http://gateway.marvel.com/v1/public/";
	private static final String BASE_PARAMETERS = "?apikey={0}&hash={1}&ts={2}&limit={3}";
	private static final String BASE_ID_PARAMETERS = "/{ID}" + BASE_PARAMETERS;
	private static final String BASE_ID_ENDPOINT_PARAMETERS = "/{ID}" + "/{ME}" + BASE_PARAMETERS;
	
	public static String getEndpointFrom(MarvelEndpointEnum marvelEndpoint, Credentials credenciais, Integer limit) {
		String parameters = BASE_PARAMETERS.replace("{0}", credenciais.getPublicKey())
										   .replace("{1}", credenciais.getHash())
										   .replace("{2}", String.valueOf(credenciais.getTimeStamp()))
										   .replace("{3}", String.valueOf(limit));

		String endepoint = Joiner.on("").join(BASE_ENDPOINT, marvelEndpoint.toLowerCase(), parameters);

		return endepoint;
	}
	
	public static String getEndpointFromId(MarvelEndpointEnum marvelEndpoint, Integer id, Credentials credenciais, Integer limit) {
		String parameters = BASE_ID_PARAMETERS.replace("{ID}", id.toString())
											  .replace("{0}", credenciais.getPublicKey())
										      .replace("{1}", credenciais.getHash())
										      .replace("{2}", String.valueOf(credenciais.getTimeStamp()))
										      .replace("{3}", String.valueOf(limit));

		String endepoint = Joiner.on("").join(BASE_ENDPOINT, marvelEndpoint.toLowerCase(), parameters);

		return endepoint;
	}
	
	public static String getEndpointFromIdAndEndpoint(MarvelEndpointEnum marvelEndpointPrincipal,MarvelEndpointEnum marvelEndpointSecond, Integer id, Credentials credenciais, Integer limit) {
		String parameters = BASE_ID_ENDPOINT_PARAMETERS.replace("{ID}", id.toString())
											  .replace("{ME}", marvelEndpointSecond.toLowerCase())
											  .replace("{0}", credenciais.getPublicKey())
										      .replace("{1}", credenciais.getHash())
										      .replace("{2}", String.valueOf(credenciais.getTimeStamp()))
										      .replace("{3}", String.valueOf(limit));

		String endepoint = Joiner.on("").join(BASE_ENDPOINT, marvelEndpointPrincipal.toLowerCase(), parameters);

		return endepoint;
	}
}
