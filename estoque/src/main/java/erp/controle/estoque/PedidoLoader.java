package erp.controle.estoque;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import erp.controle.estoque.model.domain.Pedido;
import erp.controle.estoque.model.domain.Roupa;
import erp.controle.estoque.model.domain.Loja;
import erp.controle.estoque.model.domain.Usuario;
import erp.controle.estoque.model.service.PedidoService;
import erp.controle.estoque.model.service.RoupaService;

@Order(4)
@Component
public class PedidoLoader implements ApplicationRunner {
	
	@Autowired
	private RoupaService roupaService;
	@Autowired
	private PedidoService pedidoService;

	@Override
	public void run(ApplicationArguments args) {
		try {
			List<Roupa> roupas = new ArrayList<Roupa>(
						roupaService.obterLista()
					);
	
			Loja loja = new Loja();
			loja.setId(1);
			
			Usuario usuario = new Usuario();
			usuario.setId(1);
	
			Pedido pedido = new Pedido(loja);
			pedido.setDescricao("Reposicao de roupa Loja X");
			pedido.setNumeroPedido("53");
			pedido.setRoupas(roupas);
			pedido.setUsuario(usuario);
			
			pedidoService.incluir(pedido);
		} catch (Exception e) {
			System.out.println("Impossível realizar a inclusão: " + e.getMessage());
		}
	}
}