package erp.controle.estoque.model.testes;

import java.util.ArrayList;
import java.util.List;
import erp.controle.estoque.model.domain.Pedido;
import erp.controle.estoque.model.domain.Roupa;
import erp.controle.estoque.exceptions.CnpjInvalidoException;
import erp.controle.estoque.exceptions.EmailInvalidoException;
import erp.controle.estoque.exceptions.LojaNulaException;
import erp.controle.estoque.exceptions.NaoExisteRoupasException;
import erp.controle.estoque.exceptions.NomeInvalidoException;
import erp.controle.estoque.exceptions.QuantidadeInvalidaException;
import erp.controle.estoque.exceptions.TamanhoInvalidoException;
import erp.controle.estoque.exceptions.ValorInvalidoException;
import erp.controle.estoque.model.domain.Calca;
import erp.controle.estoque.model.domain.Camisa;
import erp.controle.estoque.model.domain.Casaco;
import erp.controle.estoque.model.domain.Loja;


public class PedidoTeste {

	public static void main(String[] args) {
		
		List<Roupa> listaRoupas = new ArrayList<Roupa>();
		
		try {
			Camisa esporte = new Camisa("1","Blusa esporte", 20, "Imediata", "G", 2);
			esporte.setMarca("NIKE");
			esporte.setEspecial(false);
			esporte.setSecao("Adulto Esporte");
			listaRoupas.add(esporte);
		} catch (ValorInvalidoException | TamanhoInvalidoException | QuantidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
	
		try {
			Calca skinny = new Calca("1","Calca Skinny", 31, "2 dias", "44", 3);
			skinny.setMarca("Riachuelo");
			skinny.setEspecial(false);
			skinny.setComCinto(false);
			skinny.setSecao("Jeans Skinny");
			skinny.setEstilo("Skinny");
			listaRoupas.add(skinny);
		} catch (ValorInvalidoException | TamanhoInvalidoException | QuantidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
	
		try {
			Casaco golaAlta = new Casaco("1","Casaco Linho Gola Alta", 76, "Imediato", "P", 1);
			golaAlta.setMarca("Adidas");
			golaAlta.setEspecial(false);
			golaAlta.setTemCapuz(false);
			golaAlta.setSecao("Casaco");
			golaAlta.setEstilo("Linho Gola Alta");
			listaRoupas.add(golaAlta);
		} catch (ValorInvalidoException | TamanhoInvalidoException | QuantidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Camisa esporte = new Camisa("1","Blusa esporte", 0, "Imediata", "G", 2);
			esporte.setMarca("NIKE");
			esporte.setEspecial(false);
			esporte.setSecao("Adulto Esporte");
			listaRoupas.add(esporte);
		} catch (ValorInvalidoException | TamanhoInvalidoException | QuantidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Camisa esporte = new Camisa("1","Blusa esporte", 20, "Imediata", "G", -5);
			esporte.setMarca("NIKE");
			esporte.setEspecial(false);
			esporte.setSecao("Adulto Esporte");
			//listaRoupas.add(esporte);
		} catch (ValorInvalidoException | TamanhoInvalidoException | QuantidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Camisa esporte = new Camisa("1","Blusa esporte", 20, "Imediata", null, 2);
			esporte.setMarca("NIKE");
			esporte.setEspecial(false);
			esporte.setSecao("Adulto Esporte");
			//listaRoupas.add(esporte);
		} catch (ValorInvalidoException | TamanhoInvalidoException | QuantidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Camisa esporte = new Camisa("1","Blusa esporte", 96, "Imediata", "G", 2);
			esporte.setMarca("ADIDAS");
			esporte.setEspecial(true);
			esporte.setSecao("Adulto Esporte");
			listaRoupas.add(esporte);
		} catch (ValorInvalidoException | TamanhoInvalidoException | QuantidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}

		try {
			Loja loja = new Loja("Roupas LTDA", "3341-9822", "90.985.964/0001-22");
			try {
				Pedido pedido = new Pedido(loja);
				pedido.setNumeroPedido("Pedido 98928");
				pedido.setRoupas(listaRoupas);
				pedido.relatorio();
			} catch (LojaNulaException | NaoExisteRoupasException e) {
				System.out.println(e.getMessage());
			}
		} catch (NomeInvalidoException | EmailInvalidoException | CnpjInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		Loja loja = null;
		try {
			loja = new Loja(null, "3341-9822", "90.985.964/0001-22");
		} catch (NomeInvalidoException | EmailInvalidoException | CnpjInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Pedido pedido = new Pedido(loja);
			pedido.setNumeroPedido("Pedido 98928");
			pedido.setRoupas(listaRoupas);
			pedido.relatorio();
		} catch (LojaNulaException | NaoExisteRoupasException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			loja = new Loja("Rei das Roupas", "3341-9822", "90.985.964/0001-22");
		} catch (NomeInvalidoException | EmailInvalidoException | CnpjInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Pedido pedido = new Pedido(loja);
			pedido.setNumeroPedido("Pedido 98928");
			//pedido.setRoupas(listaRoupas);
			pedido.relatorio();
		} catch (LojaNulaException | NaoExisteRoupasException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			loja = new Loja("Rei das Roupas", "3341-9822", "90.985.964/0001-22");
		} catch (NomeInvalidoException | EmailInvalidoException | CnpjInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Pedido pedido = new Pedido(loja);
			pedido.setNumeroPedido("Pedido 98928");
			pedido.setRoupas(listaRoupas);
			pedido.relatorio();
		} catch (LojaNulaException | NaoExisteRoupasException e) {
			System.out.println(e.getMessage());
		}
	}
}