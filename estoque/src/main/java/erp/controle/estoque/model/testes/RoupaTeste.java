package erp.controle.estoque.model.testes;

import erp.controle.estoque.exceptions.QuantidadeInvalidaException;
import erp.controle.estoque.exceptions.TamanhoInvalidoException;
import erp.controle.estoque.exceptions.ValorInvalidoException;
import erp.controle.estoque.model.domain.Calca;
import erp.controle.estoque.model.domain.Camisa;
import erp.controle.estoque.model.domain.Casaco;

//import erp.controle.estoque.model.domain.Roupa;

public class RoupaTeste {

	public static void main(String[] args) {
		
		try {
			Camisa esporte = new Camisa("Blusa esporte", 16, "Imediata", "G", 5);
			esporte.setMarca("NIKE");
			esporte.setEspecial(false);
			esporte.setSecao("Adulto Esporte");
			System.out.println(esporte);
		} catch (ValorInvalidoException | TamanhoInvalidoException | QuantidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Calca skinny = new Calca("Calca Skinny", 31, "2 dias", null, 9);
			skinny.setMarca("Riachuelo");
			skinny.setEspecial(false);
			skinny.setComCinto(false);
			skinny.setSecao("Jeans Skinny");
			skinny.setEstilo("Skinny");
			System.out.println(skinny);
		} catch (ValorInvalidoException | TamanhoInvalidoException | QuantidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Casaco golaAlta = new Casaco("Casaco Linho Gola Alta", 0, "Imediato", "P", 3);
			golaAlta.setMarca("Adidas");
			golaAlta.setEspecial(false);
			golaAlta.setTemCapuz(false);
			golaAlta.setSecao("Casaco");
			golaAlta.setEstilo("Linho Gola Alta");
			System.out.println(golaAlta);
		} catch (ValorInvalidoException | TamanhoInvalidoException | QuantidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Casaco golaAlta = new Casaco("Casaco Linho Gola Alta", 8, "Imediato", "P", -9);
			golaAlta.setMarca("Adidas");
			golaAlta.setEspecial(false);
			golaAlta.setTemCapuz(false);
			golaAlta.setSecao("Casaco");
			golaAlta.setEstilo("Linho Gola Alta");
			System.out.println(golaAlta);
		} catch (ValorInvalidoException | TamanhoInvalidoException | QuantidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
	}

}
