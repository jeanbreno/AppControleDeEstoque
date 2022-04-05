package erp.controle.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import erp.controle.estoque.model.domain.Calca;
import erp.controle.estoque.model.domain.Usuario;
import erp.controle.estoque.model.service.CalcaService;
import erp.controle.estoque.model.service.RoupaService;

@Controller
public class CalcaController {
	
	@Autowired
	private CalcaService calcaService;
	@Autowired
	private RoupaService roupaService;

	@GetMapping(value = "/calcas")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("calcaLista", calcaService.obterLista(usuario));
		
		return "calca/lista";
	}

	@GetMapping(value = "/calca")
	public String telaCadastro() {
		return "calca/cadastro";
	}

	@PostMapping(value = "/calca/incluir")
	public String incluir(Model model, Calca calca, @SessionAttribute("user") Usuario usuario) {
		
		calca.setUsuario(usuario);

		roupaService.incluir(calca);
		
		model.addAttribute("mensagem", "A calca " + calca.getDescricao() + " foi incluída com sucesso!!!");

		return telaLista(model, usuario);
	}

	@GetMapping(value = "/calca/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Calca calca = (Calca) roupaService.obterPorId(id);
		
		if(calca != null) {
			try {
				roupaService.excluir(id);				
				model.addAttribute("mensagem", "A calca "+calca.getDescricao()+" foi excluída com sucesso!!!");
			} catch (Exception e) {
				model.addAttribute("mensagem", "Impossível realizar a exclusão! A calca "+calca.getDescricao()+" está associada a um pedido!!!");
			}
		} else {
			model.addAttribute("mensagem", "Calca inexistente.. impossível realizar a exclusão!!!");			
		}
		
		return telaLista(model, usuario);
	}
}