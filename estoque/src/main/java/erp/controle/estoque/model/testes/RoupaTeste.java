package erp.controle.estoque.model.testes;

import erp.controle.estoque.model.domain.Calca;
import erp.controle.estoque.model.domain.Camisa;
import erp.controle.estoque.model.domain.Casaco;

//import erp.controle.estoque.model.domain.Roupa;

public class RoupaTeste {

	public static void main(String[] args) {
		
		Camisa esporte = new Camisa("Blusa esporte", 16, "Imediata", "G", 5);
		esporte.setMarca("NIKE");
		esporte.setEspecial(false);
		esporte.setSecao("Adulto Esporte");
		System.out.println(esporte);
		
		Calca skinny = new Calca("Calca Skinny", 31, "2 dias", "44", 9);
		skinny.setMarca("Riachuelo");
		skinny.setEspecial(false);
		skinny.setComCinto(false);
		skinny.setSecao("Jeans Skinny");
		skinny.setEstilo("Skinny");
		System.out.println(skinny);
		
		Casaco golaAlta = new Casaco("Casaco Linho Gola Alta", 76, "Imediato", "P", 3);
		golaAlta.setMarca("Adidas");
		golaAlta.setEspecial(false);
		golaAlta.setTemCapuz(false);
		golaAlta.setSecao("Casaco");
		golaAlta.setEstilo("Linho Gola Alta");
		System.out.println(golaAlta);
	
	}

}
