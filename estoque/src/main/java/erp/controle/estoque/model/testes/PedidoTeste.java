package erp.controle.estoque.model.testes;

import java.util.ArrayList;
import java.util.List;
import erp.controle.estoque.model.domain.Pedido;
import erp.controle.estoque.model.domain.Roupa;
import erp.controle.estoque.model.domain.Calca;
import erp.controle.estoque.model.domain.Camisa;
import erp.controle.estoque.model.domain.Casaco;
import erp.controle.estoque.model.domain.Loja;


public class PedidoTeste {

	public static void main(String[] args) {
		
		List<Roupa> listaRoupas = new ArrayList<Roupa>();
		
		Camisa esporte = new Camisa("Blusa esporte", 20, "Imediata", "G", 2);
		esporte.setMarca("NIKE");
		esporte.setEspecial(false);
		esporte.setSecao("Adulto Esporte");
		
		Calca skinny = new Calca("Calca Skinny", 31, "2 dias", "44", 3);
		skinny.setMarca("Riachuelo");
		skinny.setEspecial(false);
		skinny.setComCinto(false);
		skinny.setSecao("Jeans Skinny");
		skinny.setEstilo("Skinny");
		
		Casaco golaAlta = new Casaco("Casaco Linho Gola Alta", 76, "Imediato", "P", 1);
		golaAlta.setMarca("Adidas");
		golaAlta.setEspecial(false);
		golaAlta.setTemCapuz(false);
		golaAlta.setSecao("Casaco");
		golaAlta.setEstilo("Linho Gola Alta");
		
		listaRoupas.add(esporte);
		listaRoupas.add(skinny);
		listaRoupas.add(golaAlta);
		
		Loja loja = new Loja("Mundo das Roupas", "3341-9822", "90.985.964/0001-22");
		
		Pedido pedido = new Pedido();
		pedido.setNumeroPedido("Pedido 98928");
		pedido.setLoja(loja);
		pedido.setRoupas(listaRoupas);
		System.out.println(pedido);

	}
}