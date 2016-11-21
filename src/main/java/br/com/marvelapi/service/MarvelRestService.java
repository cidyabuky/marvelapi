package br.com.marvelapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.marvelapi.commons.MarvelConnectionUtils;
import br.com.marvelapi.commons.MarvelEndpointEnum;
import br.com.marvelapi.model.Body;
import br.com.marvelapi.model.Credentials;

@Repository
public class MarvelRestService {
	private static final Logger log = LoggerFactory.getLogger(MarvelRestService.class);
	private RestTemplate restTemplate;

	public Body getCaracterByCredentials(Credentials credentials) throws RestClientException {
		Body body = null;
		body = getRestTemplate().getForObject(MarvelConnectionUtils.getEndpointFrom(MarvelEndpointEnum.CHARACTERS, credentials, 100), Body.class);
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
