package erp.controle.estoque.model.testes;

import erp.controle.estoque.exceptions.CnpjInvalidoException;
import erp.controle.estoque.exceptions.ContatoInvalidoException;
import erp.controle.estoque.exceptions.NomeInvalidoException;
import erp.controle.estoque.model.domain.Loja;

public class LojaTeste {
	
	public static void main(String[] args) {
	
		try {
			Loja loja = new Loja(null, "3341-9822", "90.985.964/0001-22");
			System.out.println(loja);
		} catch (NomeInvalidoException | ContatoInvalidoException | CnpjInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Loja loja = new Loja("Mundo das Roupas", null, "90.985.964/0001-22");
			System.out.println(loja);
		} catch (NomeInvalidoException | ContatoInvalidoException | CnpjInvalidoException e) {
			System.out.println(e.getMessage());
		}
	
		try {
			Loja loja = new Loja("Mundo das Roupas", "3341-9822", null);
			System.out.println(loja);
		} catch (NomeInvalidoException | ContatoInvalidoException | CnpjInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Loja loja = new Loja("Mundo das Roupas", "3341-9822", "90.985.964/0001-22");
			System.out.println(loja);
		} catch (NomeInvalidoException | ContatoInvalidoException | CnpjInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}
}
