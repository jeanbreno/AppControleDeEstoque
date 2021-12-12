package erp.controle.estoque.model.testes;

import erp.controle.estoque.model.domain.Casaco;

public class CasacoTeste {

	public static void main(String[] args) {
		
		Casaco golaAlta = new Casaco("Casaco Linho", 76, "Imediato", "P", 3);
		golaAlta.setEspecial(false);
		golaAlta.setTemCapuz(false);
		System.out.println("Valor total do item Gola Alta: " + golaAlta.calcularValorTotalDoItem());
	
		Casaco canguru = new Casaco("Casaco Urso", 52, "10 dias", "M", 3);
		canguru.setEspecial(false);
		canguru.setTemCapuz(true);
		System.out.println("Valor total do item Canguru: " + canguru.calcularValorTotalDoItem());
		
		Casaco esporte = new Casaco("Casaco Corta Vento", 37, "2 dias", "XXG", 5);
		esporte.setEspecial(true);
		esporte.setTemCapuz(false);
		System.out.println("Valor total do item Esporte: " + esporte.calcularValorTotalDoItem());
		
		Casaco social = new Casaco("Casaco Social Rajado", 89, "8 dias", "XGG", 10);
		social.setEspecial(true);
		social.setTemCapuz(true);
		System.out.println("Valor total do item Social: " + esporte.calcularValorTotalDoItem());
	}

}
