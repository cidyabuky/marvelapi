package br.com.marvelapi.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import br.com.marvelapi.model.Credentials;
import br.com.marvelapi.repository.CharactersRepository;

@Controller
public class CharactersController {

	private static final Logger log = LoggerFactory.getLogger(CharactersController.class);

	@Autowired
	protected CharactersRepository personagemRepository;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("listapersonagens")
	public String listaPersonagens(Model model, @SortDefault("name") Pageable pageable) {
		Object attribute = RequestContextHolder.getRequestAttributes().getAttribute("credenciais", RequestAttributes.SCOPE_SESSION);
		Credentials credenciais = (Credentials) attribute;
		log.info(credenciais.toString());
		Object usuarioLogado = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		log.info(usuarioLogado.toString());
		model.addAttribute("page", personagemRepository.findAll(pageable));

		return "listapersonagens";
	}
}
