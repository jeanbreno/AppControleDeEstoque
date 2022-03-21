package erp.controle.estoque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import erp.controle.estoque.model.domain.Aluno;

@Controller
public class ProdutoController {
	
	//@RequestMapping(value = "/produto", method = RequestMethod.GET)
	@GetMapping(value = "/produto")
	public String telaCadastro() {
		return "produto/cadastro";
	}
	
	@PostMapping(value = "/aluno/incluir")
	public String incluir(Aluno aluno) {
		System.out.println("entrei...");
		return "index";
	}
}
