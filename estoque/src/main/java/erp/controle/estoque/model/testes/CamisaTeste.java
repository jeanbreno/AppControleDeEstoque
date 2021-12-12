package erp.controle.estoque.model.testes;

import erp.controle.estoque.model.domain.Camisa;

public class CamisaTeste {
	
	public static void main(String[] args) {
		
		Camisa esporte = new Camisa("Blusa esporte", 19, "Imediata", "G", 5);
		esporte.setMarca("NIKE");
		esporte.setEspecial(false);
		esporte.setSecao("Adulto Esporte");
		System.out.println("Valor total do item: " + esporte.calcularValorTotalDoItem());
	}
}
