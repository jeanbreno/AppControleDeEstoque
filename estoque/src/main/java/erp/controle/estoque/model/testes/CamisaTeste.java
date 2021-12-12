package erp.controle.estoque.model.testes;

import erp.controle.estoque.model.domain.Camisa;

public class CamisaTeste {
	
	public static void main(String[] args) {
		
		Camisa esporte = new Camisa("Blusa esporte", 19, "Imediata", "G", 5);
		esporte.setEspecial(false);
		System.out.println("Valor total do item Esporte: " + esporte.calcularValorTotalDoItem());
		
		Camisa estampada = new Camisa("Blusa estampa Leão", 26, "Imediata", "P", 15);
		estampada.setEspecial(true);
		System.out.println("Valor total do item Estampada: " + estampada.calcularValorTotalDoItem());
	}
}
