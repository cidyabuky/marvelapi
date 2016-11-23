package br.com.marvelapi.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.marvelapi.commons.MarvelConnectionUtils;
import br.com.marvelapi.commons.MarvelEndpointEnum;
import br.com.marvelapi.model.CharacterDataWrapper;
import br.com.marvelapi.model.Characters;
import br.com.marvelapi.model.Comics;
import br.com.marvelapi.model.ComicsDataWrapper;
import br.com.marvelapi.model.Credentials;

@Repository
public class MarvelRestRepository {
	private static final Logger log = LoggerFactory.getLogger(MarvelRestRepository.class);
	private RestTemplate restTemplate;

	public List<Characters> getCaracterByCredentials(Credentials credentials) throws RestClientException {
		CharacterDataWrapper wrapper = null;
		wrapper = getRestTemplate().getForObject(MarvelConnectionUtils.getEndpointFrom(MarvelEndpointEnum.CHARACTERS, credentials, 100), CharacterDataWrapper.class);
		log.info(wrapper.toString());

		return wrapper.getData().getResults();
	}

	public List<Comics> getComicByCredentialsAndCharactersId(Credentials credentials, Integer id) throws RestClientException {
		ComicsDataWrapper wrapper = null;
		wrapper = getRestTemplate().getForObject(MarvelConnectionUtils.getEndpointFromIdAndEndpoint(MarvelEndpointEnum.CHARACTERS, MarvelEndpointEnum.COMICS, id, credentials, 100),
				ComicsDataWrapper.class);
		log.info(wrapper.toString());

		return wrapper.getData().getResults();
	}

	private RestTemplate getRestTemplate() {
		if (restTemplate == null) {
			restTemplate = new RestTemplate();
		}

		return restTemplate;
	}
}
