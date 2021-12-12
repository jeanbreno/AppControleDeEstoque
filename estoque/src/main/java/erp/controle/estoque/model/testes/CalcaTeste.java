package erp.controle.estoque.model.testes;

import erp.controle.estoque.model.domain.Calca;

public class CalcaTeste {
	public static void main(String[] args) {
		
		Calca skinny = new Calca("Calca Skinny Festival", 110, "2 dias", "53", 6);
		skinny.setEspecial(true);
		skinny.setComCinto(false);
		System.out.println("Valor total do item Skinny: " + skinny.calcularValorTotalDoItem());
		
		Calca saruel = new Calca("Calca Saruel Holliday", 55, "9 dias", "44", 3);
		saruel.setEspecial(false);
		saruel.setComCinto(true);
		System.out.println("Valor total do item Saruel: " + saruel.calcularValorTotalDoItem());
		
		Calca normal = new Calca("Calca Jeans Normal", 37, "Imediato", "42", 5);
		normal.setEspecial(false);
		normal.setComCinto(false);
		System.out.println("Valor total do item Normal: " + normal.calcularValorTotalDoItem());
		
		Calca wide = new Calca("Calca Wide Ro", 150, "10 dias", "55", 2);
		wide.setEspecial(true);
		wide.setComCinto(true);
		System.out.println("Valor total do item Wide: " + wide.calcularValorTotalDoItem());
	}
}
