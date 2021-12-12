package erp.controle.estoque.model.testes;

import erp.controle.estoque.model.domain.Calca;

public class CalcaTeste {
	public static void main(String[] args) {
		
		Calca skinny = new Calca("Calca Skinny", 37, "2 dias", "44", 3);
		skinny.setMarca("Riachuelo");
		skinny.setEspecial(false);
		skinny.setComCinto(true);
		skinny.setSecao("Jeans Skinny Normal");
		skinny.setEstilo("Skinny");
		System.out.println("Valor total do item: " + skinny.calcularValorTotalDoItem());
	}
}
