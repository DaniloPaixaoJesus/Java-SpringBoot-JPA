package br.com.danilopaixao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danilopaixao.model.Pessoa;
import br.com.danilopaixao.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	public Iterable<Pessoa> listaConvidados() {
		Iterable<Pessoa> pessoas = repository.findAll();
		return pessoas;
	}

	public void salvar(Pessoa novaPessoa) {
		repository.save(novaPessoa);
	}

}
