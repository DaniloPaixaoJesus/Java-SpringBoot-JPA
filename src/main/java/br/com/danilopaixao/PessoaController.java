package br.com.danilopaixao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.danilopaixao.model.Pessoa;
import br.com.danilopaixao.repository.PessoaRepository;

@Controller
public class PessoaController {
	
	@Autowired
	private PessoaRepository repository;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("listapessoas")
	public String listaConvidados(Model model){
		
		Iterable<Pessoa> pessoas = repository.findAll();
		
		model.addAttribute("pessoas", pessoas);
		
		return "listapessoas";
	}
	
	@RequestMapping(value = "salvar", method = RequestMethod.POST )
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email")String email, 
			@RequestParam("telefone") String telefone, Model model){
		
		Pessoa novaPessoa = new Pessoa(nome, email, telefone);
		
		repository.save(novaPessoa);
		
		Iterable<Pessoa> pessoas = repository.findAll();
		
		
		model.addAttribute("pessoas", pessoas);
		
		return "listapessoas";
		
	}

}
