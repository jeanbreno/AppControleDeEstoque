package erp.controle.estoque.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import erp.controle.estoque.model.domain.Usuario;
import erp.controle.estoque.model.domain.Roupa;
import erp.controle.estoque.model.service.RoupaService;

@Controller
public class RoupaController {
	
	// criando objeto
	@Autowired
	private RoupaService roupaService;
	
//	private static List<Roupa> roupas = new ArrayList<Roupa>();

	@GetMapping(value = "/roupas")
	public String telaLista(Model model, Usuario usuario) {
		
		model.addAttribute("roupaLista", roupaService.obterLista());
		
		return "roupa/lista";
	}
	
	@GetMapping(value = "/roupa")
	public String telaCadastro() {
		
		return "roupa/cadastro";
	}
	
	@PostMapping(value = "/roupa/incluir")
	public String incluir(Roupa  roupa, Model model, Usuario usuario) {

		roupaService.incluir(roupa);  
		
		model.addAttribute("mensagem", "["+roupa.getId()+"] Roupa " + roupa.getNome() + " cadastrado!");

		return telaLista(model, usuario);
		// return "redirect:/roupas";
		// return telaConfirmacao();
		// return "roupa/lista";
	}
	
	@GetMapping(value = "/roupa/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Roupa roupa = roupaService.obterPorId(id);
				
		if(roupa != null) {			
			roupaService.excluir(id);			
			model.addAttribute("mensagem", "O roupa "+roupa.getNome()+" foi excluído com sucesso!");
		} else {
			model.addAttribute("mensagem", "Roupa não existente. Impossível realizar exclusão!");			
		}
		
		return telaLista(model, usuario);
	}
}
