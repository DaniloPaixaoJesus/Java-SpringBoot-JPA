package br.com.danilopaixao.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.danilopaixao.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}
