package erp.controle.estoque.model.testes;

import erp.controle.estoque.model.domain.Roupa;

public class RoupaTeste {

	public static void main(String[] args) {
		
		Roupa roupa = new Roupa("Camisa Polo", 35, true, "M");
		System.out.println(roupa);
	}

}
