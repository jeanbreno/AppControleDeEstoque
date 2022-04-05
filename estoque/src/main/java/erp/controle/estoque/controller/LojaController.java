package erp.controle.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import erp.controle.estoque.model.domain.Loja;
import erp.controle.estoque.model.domain.Usuario;
import erp.controle.estoque.model.service.LojaService;

@Controller
public class LojaController {
	
	@Autowired
	private LojaService lojaService;

	@GetMapping(value = "/loja")
	public String telaCadastro() {
		return "loja/cadastro";
	}
	
	@GetMapping(value = "/lojas")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("lojaLista", lojaService.obterLista(usuario));

		return "loja/lista";
	}

	@PostMapping(value = "/loja/incluir")
	public String incluir(Loja loja, Model model, @SessionAttribute("user") Usuario usuario){
		
		loja.setUsuario(usuario);

		lojaService.incluir(loja);

		model.addAttribute("mensagem", "O loja " + loja.getNome() + " foi incluído com sucesso!!!");
		
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/loja/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Loja loja = lojaService.obterPorId(id);
				
		if(loja != null) {
			try {
				lojaService.excluir(id);				
				model.addAttribute("mensagem", "O loja "+loja.getNome()+" foi excluído com sucesso!!!");
			} catch (Exception e) {
				model.addAttribute("mensagem", "Impossível realizar a exclusão! O loja "+loja.getNome()+" está associado a um pedido!!!");
			}
		} else {
			model.addAttribute("mensagem", "Loja inexistente.. impossível realizar a exclusão!!!");			
		}
		
		return telaLista(model, usuario);
	}
}