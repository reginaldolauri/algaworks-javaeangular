package com.algamoney.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algamoney.api.model.Lancamento;
import com.algamoney.api.model.Pessoa;
import com.algamoney.api.repository.LancamentoRepository;
import com.algamoney.api.repository.PessoaRepository;
import com.algamoney.api.repository.filter.LancamentoFilter;
import com.algamoney.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Lancamento> Listar(LancamentoFilter lancamentoFilter){
		return this.lancamentoRepository.filtrar(lancamentoFilter);
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
		Pessoa pessoa = this.pessoaRepository.findById(lancamento.getPessoa().getCodigo()).get();
		if (null == pessoa || pessoa.isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		}
		return this.lancamentoRepository.save(lancamento);
	}

	
}
