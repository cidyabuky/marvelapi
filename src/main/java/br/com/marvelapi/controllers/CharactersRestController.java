package br.com.marvelapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import br.com.marvelapi.model.Characters;
import br.com.marvelapi.model.Credentials;
import br.com.marvelapi.repository.CharactersRepository;
import br.com.marvelapi.repository.MarvelRestRepository;

@RestController
public class CharactersRestController {

	private static final Logger log = LoggerFactory.getLogger(CharactersRestController.class);

	@Autowired
	protected CharactersRepository personagemRepository;

	@Autowired
	private MarvelRestRepository marvelService;

	// @RequestMapping("/")
	// public String index() {
	// return "index";
	// }
	//
	// @RequestMapping("listapersonagens")
	// public String listaPersonagens(Model model, @SortDefault("name") Pageable
	// pageable) {
	// model.addAttribute("page", personagemRepository.findAll(pageable));
	//
	// return "listapersonagens";
	// }
	//
	// @RequestMapping(value = "characters")
	// public String detalharPersonagen(Model model, Integer id) {
	// Credentials credenciais = getCredentialSession();
	// Characters personagem = personagemRepository.findById(id);
	// List<Comics> comics =
	// marvelService.getComicByCredentialsAndCharactersId(credenciais,
	// personagem.getId());
	//
	// model.addAttribute("personagem", personagem);
	// model.addAttribute("revistas", comics);
	//
	// return "characters";
	// }

	private Credentials getCredentialSession() {
		Object attribute = RequestContextHolder.getRequestAttributes().getAttribute("credenciais", RequestAttributes.SCOPE_SESSION);
		Credentials credenciais = (Credentials) attribute;
		log.info(credenciais.toString());
		return credenciais;
	}

	@RequestMapping(value = "/public/characters", method = RequestMethod.GET)
	public ResponseEntity<List<Characters>> listar() {
		Iterable<Characters> personagens = personagemRepository.findAll();
		return new ResponseEntity<List<Characters>>(new ArrayList<Characters>(IteratorUtils.toList(personagens.iterator())), HttpStatus.OK);
	}
}
