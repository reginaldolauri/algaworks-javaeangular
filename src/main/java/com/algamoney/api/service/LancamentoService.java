package com.algamoney.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algamoney.api.model.Lancamento;
import com.algamoney.api.repository.LancamentoRepository;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;

	public List<Lancamento> Listar(){
		return this.lancamentoRepository.findAll();
	}
	
	public Lancamento bucarPorCodigo(Long codigo) {
		Optional<Lancamento> lancamento = this.lancamentoRepository.findById(codigo);
		if (lancamento.isPresent()) {
			return lancamento.get();
		} else {
			throw new EmptyResultDataAccessException(1);
		}
		
	}
	
	public Lancamento criar(Lancamento lancamento) {
		return this.lancamentoRepository.save(lancamento);
	}

}
