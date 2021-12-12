package erp.controle.estoque.model.testes;

import erp.controle.estoque.model.domain.Loja;

public class LojaTeste {
	
	public static void main(String[] args) {
	
	Loja loja = new Loja("Mundo das Roupas", "3341-9822", "90.985.964/0001-22");
	System.out.println(loja);
	
	}
}
