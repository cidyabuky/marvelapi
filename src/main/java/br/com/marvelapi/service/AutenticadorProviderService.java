package br.com.marvelapi.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import br.com.marvelapi.model.Characters;
import br.com.marvelapi.model.Credentials;
import br.com.marvelapi.repository.CharactersRepository;
import br.com.marvelapi.repository.MarvelRestRepository;

@Component
public class AutenticadorProviderService implements AuthenticationProvider {

	private static final Logger log = LoggerFactory.getLogger(AutenticadorProviderService.class);

	@Autowired
	private MarvelRestRepository marvelService;
	@Autowired
	protected CharactersRepository personagemRepository;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String publicKey = auth.getName();
		String privateKey = auth.getCredentials().toString();

		Credentials credenciais = new Credentials(privateKey, publicKey);

		try {
			List<Characters> charactersList = marvelService.getCaracterByCredentials(credenciais);
			log.info(charactersList.toString());
			personagemRepository.save(charactersList);
			List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			RequestContextHolder.getRequestAttributes().setAttribute("credenciais", credenciais, RequestAttributes.SCOPE_SESSION);
			return new UsernamePasswordAuthenticationToken(publicKey, privateKey, authList);
		} catch (RestClientException e) {
			throw new UsernameNotFoundException("Chave publica e/ou privada inválidas.");
		}
	}

	@Override
	public boolean supports(Class<?> auth) {
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}

}
