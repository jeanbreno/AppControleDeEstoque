package erp.controle.estoque.model.testes;

import erp.controle.estoque.model.domain.Pedido;
import erp.controle.estoque.model.domain.Loja;
public class PedidoTeste {

	public static void main(String[] args) {
		
		Loja loja = new Loja("Mundo das Roupas", "3341-9822", "90.985.964/0001-22");
		
		Pedido pedido = new Pedido();
		pedido.setNumeroPedido("Pedido 98928");
		pedido.setLoja(loja);
		System.out.println(pedido);
	}
}