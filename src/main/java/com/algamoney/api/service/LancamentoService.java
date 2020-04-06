package com.algamoney.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.algamoney.api.model.Lancamento;
import com.algamoney.api.model.Pessoa;
import com.algamoney.api.repository.LancamentoRepository;
import com.algamoney.api.repository.PessoaRepository;
import com.algamoney.api.repository.filter.LancamentoFilter;
import com.algamoney.api.repository.projection.ResumoLancamento;
import com.algamoney.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Page<Lancamento> pesquisar(LancamentoFilter lancamentoFilter, Pageable pageable){
		return this.lancamentoRepository.filtrar(lancamentoFilter, pageable);
	}

	public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable){
		return this.lancamentoRepository.resumir(lancamentoFilter, pageable);
	}
	
	public Lancamento bucarPorCodigo(Long codigo) {
		Lancamento lancamento = this.lancamentoRepository.findOne(codigo);
		if (null != lancamento) {
			return lancamento;
		} else {
			throw new EmptyResultDataAccessException(1);
		}
		
	}
	
	public Lancamento criar(Lancamento lancamento) {
		Pessoa pessoa = this.pessoaRepository.findOne(lancamento.getPessoa().getCodigo());
		if (null == pessoa || pessoa.isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		}
		return this.lancamentoRepository.save(lancamento);
	}

	public void remover(Long codigo) {
		this.lancamentoRepository.delete(codigo);
	}

	public Lancamento atualizar(Long codigo, Lancamento lancamento) {
		Lancamento lancamentoSalvo = this.buscarLancamentoExistente(codigo);
		if (!lancamento.getPessoa().equals(lancamentoSalvo.getPessoa())) {
			this.validarPessoa(lancamento);
		}
		
		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");
		
		return this.lancamentoRepository.save(lancamentoSalvo);
	}
	
	private void validarPessoa(Lancamento lancamento) {
		Pessoa pessoa = null;
		if (null  != lancamento.getPessoa().getCodigo()) {
			pessoa = this.pessoaRepository.findOne(lancamento.getPessoa().getCodigo());
		}
		
		if (null == pessoa || pessoa.isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		}
	}
	
	private Lancamento buscarLancamentoExistente(Long codigo) {
		Lancamento lancamentoSalvo = this.lancamentoRepository.findOne(codigo);
		if (null  == lancamentoSalvo) {
			throw new IllegalArgumentException();
		}
		return lancamentoSalvo;
	}

	
}
