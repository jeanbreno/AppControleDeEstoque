package erp.controle.estoque.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import erp.controle.estoque.model.domain.Produto;
import erp.controle.estoque.model.service.ProdutoService;

@Controller
public class ProdutoController {
	
	// criando objeto
	@Autowired
	private ProdutoService produtoService;
	
//	private static List<Produto> produtos = new ArrayList<Produto>();

	@GetMapping(value = "/produtos")
	public String telaLista(Model model) {
		
		model.addAttribute("produtoLista", produtoService.obterLista());
		
		return "produto/lista";
	}
	
	@GetMapping(value = "/produto")
	public String telaCadastro() {
		
		return "produto/cadastro";
	}
	
	@PostMapping(value = "/produto/incluir")
	public String incluir(Produto  produto, Model model) {

		produtoService.incluir(produto);  
		
		model.addAttribute("mensagem", "Produto " + produto.getNome() + " cadastrado!");

		return telaLista(model);
		// return "redirect:/produtos";
		// return telaConfirmacao();
		// return "produto/lista";
	}
}
