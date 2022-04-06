package erp.controle.estoque.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import erp.controle.estoque.model.domain.Usuario;
import erp.controle.estoque.model.domain.Calca;
import erp.controle.estoque.model.domain.Casaco;
import erp.controle.estoque.model.domain.Roupa;
import erp.controle.estoque.model.service.RoupaService;

@Controller
public class RoupaController {
	
	// criando objeto
	@Autowired
	private RoupaService roupaService;
	
//	private static List<Roupa> roupas = new ArrayList<Roupa>();

	@GetMapping(value = "/roupas")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("roupaLista", roupaService.obterLista(usuario));
		
		return "roupa/lista";
	}
	
	@GetMapping(value = "/roupa/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Roupa roupa = roupaService.obterPorId(id);
		
		String tipoRoupa = obterTipoRoupa(roupa);
				
		if(roupa != null) {			
			roupaService.excluir(id);			
			model.addAttribute("mensagem", tipoRoupa + " " +roupa.getNome()+" foi excluído com sucesso!");
		} else {
			model.addAttribute("mensagem", "Roupa não existente. Impossível realizar exclusão!");			
		}
		
		return telaLista(model, usuario);
	}
	
	private String obterTipoRoupa(Roupa roupa) {
		String tipoRoupa = null;
		
		if(roupa instanceof Calca) {
			tipoRoupa = "calca";
		}else if (roupa instanceof Casaco) {
			tipoRoupa = "casaco";
		}else {
			tipoRoupa = "camisa";
		}
		
		return tipoRoupa;
	}
}
