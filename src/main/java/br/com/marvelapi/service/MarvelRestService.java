package br.com.marvelapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.marvelapi.commons.MarvelConnectionUtils;
import br.com.marvelapi.commons.MarvelEndpointEnum;
import br.com.marvelapi.model.CharacterDataWrapper;
import br.com.marvelapi.model.ComicsDataWrapper;
import br.com.marvelapi.model.Credentials;

@Repository
public class MarvelRestService {
	private static final Logger log = LoggerFactory.getLogger(MarvelRestService.class);
	private RestTemplate restTemplate;

	public CharacterDataWrapper getCaracterByCredentials(Credentials credentials) throws RestClientException {
		CharacterDataWrapper body = null;
		body = getRestTemplate().getForObject(MarvelConnectionUtils.getEndpointFrom(MarvelEndpointEnum.CHARACTERS, credentials, 100), CharacterDataWrapper.class);
		log.info(body.toString());

		return body;
	}

	public CharacterDataWrapper getCaracterByCredentialsAndId(Credentials credentials, Integer id) throws RestClientException {
		CharacterDataWrapper body = null;
		body = getRestTemplate().getForObject(MarvelConnectionUtils.getEndpointFromId(MarvelEndpointEnum.CHARACTERS, id, credentials, 100), CharacterDataWrapper.class);
		log.info(body.toString());

		return body;
	}

	public ComicsDataWrapper getComicByCredentialsAndCharactersId(Credentials credentials, Integer id) throws RestClientException {
		ComicsDataWrapper body = null;
		body = getRestTemplate().getForObject(MarvelConnectionUtils.getEndpointFromIdAndEndpoint(MarvelEndpointEnum.CHARACTERS, MarvelEndpointEnum.COMICS, id, credentials, 100),
				ComicsDataWrapper.class);
		log.info(body.toString());

		return body;
	}

	private RestTemplate getRestTemplate() {
		if (restTemplate == null) {
			restTemplate = new RestTemplate();
		}

		return restTemplate;
	}
}
