package erp.controle.estoque.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import erp.controle.estoque.model.domain.Pedido;
import erp.controle.estoque.model.domain.Roupa;
import erp.controle.estoque.model.domain.Usuario;
import erp.controle.estoque.model.service.PedidoService;
import erp.controle.estoque.model.service.RoupaService;
import erp.controle.estoque.model.service.LojaService;

@Controller
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private LojaService lojaService;
	@Autowired
	private RoupaService roupaService;

	@GetMapping(value = "/pedido")
	public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("lojaLista", lojaService.obterLista(usuario));
		
		model.addAttribute("roupaLista", roupaService.obterLista(usuario));

		return "pedido/cadastro";
	}
	
	@GetMapping(value = "/pedidos")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("pedidoLista", pedidoService.obterLista(usuario));

		return "pedido/lista";
	}

	@PostMapping(value = "/pedido/incluir")
	public String incluir(@RequestParam String[] idsRoupas, Pedido pedido, Model model, @SessionAttribute("user") Usuario usuario){
		
		List<Roupa> roupas = new ArrayList<Roupa>();
		
		for(String idRoupa : idsRoupas) {
			
			Roupa roupa = roupaService.obterPorId(Integer.valueOf(idRoupa));
			
			roupas.add(roupa);
		}
		
		pedido.setUsuario(usuario);
		
		pedido.setRoupas(roupas);

		pedidoService.incluir(pedido);

		model.addAttribute("mensagem", "O pedido " + pedido.getDescricao() + " foi incluído com sucesso!!!");
		
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/pedido/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Pedido pedido = pedidoService.obterPorId(id);
				
		if(pedido != null) {			
			pedidoService.excluir(id);			
			model.addAttribute("mensagem", "O pedido "+pedido.getDescricao()+" foi excluído com sucesso!!!");
		} else {
			model.addAttribute("mensagem", "Pedido inexistente.. impossível realizar a exclusão!!!");			
		}
		
		return telaLista(model, usuario);
	}
}