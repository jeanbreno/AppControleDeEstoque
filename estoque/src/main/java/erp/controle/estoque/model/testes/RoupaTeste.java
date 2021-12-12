package erp.controle.estoque.model.testes;

import erp.controle.estoque.model.domain.Calca;
import erp.controle.estoque.model.domain.Camisa;

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
		skinny.setSecao("Jeans Skinny Normal");
		skinny.setEstilo("Skinny");
		System.out.println(skinny);
	}

}
