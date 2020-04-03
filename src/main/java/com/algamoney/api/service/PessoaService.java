package com.algamoney.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algamoney.api.model.Pessoa;
import com.algamoney.api.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Pessoa pessoaSalva = this.buscarPorCodigo(codigo);
		pessoaSalva.setAtivo(ativo);
		this.pessoaRepository.save(pessoaSalva);
	}

	public Pessoa buscarPorCodigo(Long codigo) {
		Pessoa pessoa = this.pessoaRepository.findOne(codigo);
		if (null != pessoa) {
			return pessoa;
		} else {
			throw new EmptyResultDataAccessException(1);
		}
	}

	
}
