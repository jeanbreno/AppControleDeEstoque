package erp.controle.estoque.model.testes;

import erp.controle.estoque.exceptions.QuantidadeInvalidaException;
import erp.controle.estoque.exceptions.TamanhoInvalidoException;
import erp.controle.estoque.exceptions.ValorInvalidoException;
import erp.controle.estoque.model.domain.Casaco;

public class CasacoTeste {

	public static void main(String[] args) {
		
		Casaco golaAlta;
		try {
			golaAlta = new Casaco("1","Casaco Linho", 76, "Imediato", "P", 3);
			golaAlta.setEspecial(false);
			golaAlta.setTemCapuz(false);
			System.out.println("Valor total do item Gola Alta: " + golaAlta.calcularValorTotalDoItem());
		} catch (ValorInvalidoException | TamanhoInvalidoException | QuantidadeInvalidaException e) {
			e.printStackTrace();
		}

		Casaco canguru;
		try {
			canguru = new Casaco("1","Casaco Urso", 0, "10 dias", "M", 3);
			canguru.setEspecial(false);
			canguru.setTemCapuz(true);
			System.out.println("Valor total do item Canguru: " + canguru.calcularValorTotalDoItem());
		} catch (ValorInvalidoException | TamanhoInvalidoException | QuantidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		Casaco esporte;
		try {
			esporte = new Casaco("1","Casaco Corta Vento", 37, "2 dias", null, 5);
			esporte.setEspecial(true);
			esporte.setTemCapuz(false);
			System.out.println("Valor total do item Esporte: " + esporte.calcularValorTotalDoItem());
		} catch (ValorInvalidoException | TamanhoInvalidoException | QuantidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}

		Casaco social;
		try {
			social = new Casaco("1","Casaco Social Rajado", 89, "8 dias", "XGG", -5);
			social.setEspecial(true);
			social.setTemCapuz(true);
			System.out.println("Valor total do item Social: " + social.calcularValorTotalDoItem());
		} catch (ValorInvalidoException | TamanhoInvalidoException | QuantidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
}

}
