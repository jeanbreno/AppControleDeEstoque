package erp.controle.estoque.model.testes;

import erp.controle.estoque.model.domain.Camisa;

//import erp.controle.estoque.model.domain.Roupa;

public class RoupaTeste {

	public static void main(String[] args) {
		
		Camisa esporte = new Camisa("Blusa esporte", 16, "Imediata", "G", 5);
		esporte.setMarca("NIKE");
		esporte.setEspecial(false);
		esporte.setSecao("Adulto Esporte");
		System.out.println(esporte);
		
	}

}