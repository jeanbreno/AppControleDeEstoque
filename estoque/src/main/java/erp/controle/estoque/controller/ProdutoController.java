package erp.controle.estoque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import erp.controle.estoque.model.domain.Produto;

@Controller
public class ProdutoController {
	
	//@RequestMapping(value = "/produto", method = RequestMethod.GET)
	@GetMapping(value = "/produto")
	public String telaLista() {
		return "produto/cadastro";
	}
	
	@GetMapping(value = "/produtos")
	public String telaCadastro() {
		return "produto/lista";
	}
	
	@PostMapping(value = "/produto/incluir")
	public String incluir(Produto  produto, Model model) {
		
		model.addAttribute("mensagem", "Produto " + produto.getNome() + " cadastrado!");

		return "redirect:/produtos";
		// return telaConfirmacao();
	}
}
