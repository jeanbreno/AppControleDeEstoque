package erp.controle.estoque.model.testes;

import erp.controle.estoque.exceptions.QuantidadeInvalidaException;
import erp.controle.estoque.exceptions.TamanhoInvalidoException;
import erp.controle.estoque.exceptions.ValorInvalidoException;
import erp.controle.estoque.model.domain.Calca;

public class CalcaTeste {
	public static void main(String[] args) {
		
		Calca skinny;
		try {
			skinny = new Calca("1","Calca Skinny Festival", 110, "2 dias", "53", 6);
			skinny.setEspecial(true);
			skinny.setComCinto(false);
			System.out.println("Valor total do item Skinny: " + skinny.calcularValorTotalDoItem());
		} catch (ValorInvalidoException | TamanhoInvalidoException | QuantidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}

		Calca saruel;
		try {
			saruel = new Calca("1","Calca Saruel Holliday", 55, "9 dias", null, 3);
			saruel.setEspecial(false);
			saruel.setComCinto(true);
			System.out.println("Valor total do item Saruel: " + saruel.calcularValorTotalDoItem());
		} catch (ValorInvalidoException | TamanhoInvalidoException | QuantidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
	
		Calca normal;
		try {
			normal = new Calca("1","Calca Jeans Normal", 0, "Imediato", "42", 5);
			normal.setEspecial(false);
			normal.setComCinto(false);
			System.out.println("Valor total do item Normal: " + normal.calcularValorTotalDoItem());
		
		} catch (ValorInvalidoException | TamanhoInvalidoException | QuantidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
	
		Calca wide;
		try {
			wide = new Calca("1","Calca Wide Ro", 150, "10 dias", "55", -5);
			wide.setEspecial(true);
			wide.setComCinto(true);
			System.out.println("Valor total do item Wide: " + wide.calcularValorTotalDoItem());
		} catch (ValorInvalidoException | TamanhoInvalidoException | QuantidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
}
}
