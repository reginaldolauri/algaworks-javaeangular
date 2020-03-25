package com.algamoney.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algamoney.api.model.Pessoa;
import com.algamoney.api.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping
	public List<Pessoa> listar() {
		return this.pessoaRepository.findAll();
	}
}
