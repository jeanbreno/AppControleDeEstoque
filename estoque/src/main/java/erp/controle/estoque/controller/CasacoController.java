package erp.controle.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import erp.controle.estoque.model.domain.Casaco;
import erp.controle.estoque.model.domain.Usuario;
import erp.controle.estoque.model.service.CasacoService;
import erp.controle.estoque.model.service.RoupaService;

@Controller
public class CasacoController {
	
	@Autowired
	private CasacoService casacoService;
	@Autowired
	private RoupaService roupaService;

	@GetMapping(value = "/casacos")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("casacoLista", casacoService.obterLista(usuario));
		
		return "casaco/lista";
	}

	@GetMapping(value = "/casaco")
	public String telaCadastro() {
		return "casaco/cadastro";
	}

	@PostMapping(value = "/casaco/incluir")
	public String incluir(Model model, Casaco casaco, @SessionAttribute("user") Usuario usuario) {
		
		casaco.setUsuario(usuario);

		roupaService.incluir(casaco);
		
		model.addAttribute("mensagem", "A casaco " + casaco.getDescricao() + " foi incluída com sucesso!!!");

		return telaLista(model, usuario);
	}

	@GetMapping(value = "/casaco/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Casaco casaco = (Casaco) roupaService.obterPorId(id);
		
		if(casaco != null) {
			try {
				roupaService.excluir(id);				
				model.addAttribute("mensagem", "A casaco "+casaco.getDescricao()+" foi excluída com sucesso!!!");
			} catch (Exception e) {
				model.addAttribute("mensagem", "Impossível realizar a exclusão! A casaco "+casaco.getDescricao()+" está associada a um pedido!!!");
			}
		} else {
			model.addAttribute("mensagem", "Casaco inexistente.. impossível realizar a exclusão!!!");			
		}
		
		return telaLista(model, usuario);
	}
}