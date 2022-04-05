package erp.controle.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import erp.controle.estoque.model.domain.Camisa;
import erp.controle.estoque.model.domain.Usuario;
import erp.controle.estoque.model.service.RoupaService;
import erp.controle.estoque.model.service.CamisaService;

@Controller
public class CamisaController {
	
	@Autowired
	private CamisaService camisaService;
	@Autowired
	private RoupaService roupaService;

	@GetMapping(value = "/camisas")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("camisaLista", camisaService.obterLista(usuario));
		
		return "camisa/lista";
	}

	@GetMapping(value = "/camisa")
	public String telaCadastro() {
		return "camisa/cadastro";
	}

	@PostMapping(value = "/camisa/incluir")
	public String incluir(Model model, Camisa camisa, @SessionAttribute("user") Usuario usuario) {
		
		camisa.setUsuario(usuario);

		roupaService.incluir(camisa);
		
		model.addAttribute("mensagem", "A camisa " + camisa.getDescricao() + " foi incluída com sucesso!!!");

		return telaLista(model, usuario);
	}

	@GetMapping(value = "/camisa/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Camisa camisa = (Camisa) roupaService.obterPorId(id);
		
		if(camisa != null) {
			try {
				roupaService.excluir(id);				
				model.addAttribute("mensagem", "A camisa "+camisa.getDescricao()+" foi excluída com sucesso!!!");
			} catch (Exception e) {
				model.addAttribute("mensagem", "Impossível realizar a exclusão! A camisa "+camisa.getDescricao()+" está associada a um pedido!!!");
			}
		} else {
			model.addAttribute("mensagem", "Camisa inexistente.. impossível realizar a exclusão!!!");			
		}
		
		return telaLista(model, usuario);
	}
}