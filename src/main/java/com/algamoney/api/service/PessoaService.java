package com.algamoney.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algamoney.api.model.Pessoa;
import com.algamoney.api.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa buscarPorCodigo(Long codigo) {
		Optional<Pessoa> pessoa = this.pessoaRepository.findById(codigo);
		if (pessoa.isPresent()) {
			Pessoa pessoaObtida = pessoa.get();
			return pessoaObtida;
		} else {
			throw new EmptyResultDataAccessException(1);
		}
	}
	
}
