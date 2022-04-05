package erp.controle.estoque.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import erp.controle.estoque.exceptions.QuantidadeInvalidaException;
import erp.controle.estoque.exceptions.TamanhoInvalidoException;
import erp.controle.estoque.exceptions.ValorInvalidoException;

@Entity
@Table(name = "TCamisa")
public class Camisa extends Roupa {
	
	private String marca;
	private boolean especial;
	private String secao;
	
	String delimitador = ";";
	
	public Camisa() {
		//
	}
	
	public Camisa(String nome, String descricao, float valor, String disponibilidade, String tamanho, int quantidade) throws ValorInvalidoException, TamanhoInvalidoException, QuantidadeInvalidaException {
		super(nome, descricao, valor, disponibilidade, tamanho, quantidade);

	}
	
	@Override
	public float calcularValorTotalDoItem() {
		
		float valorEspecial = (float) (this.getValor() * 1.1);
		float valorTotalDoItem = (especial ? valorEspecial * getQuantidade() : this.getValor() * getQuantidade()) ;

		return valorTotalDoItem;
	}
	//@Override
	//public float calcularQuantidadeDoItem() {
	//	return 0;
	//}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(delimitador);
		sb.append(marca);
		sb.append(delimitador);
		sb.append(especial ? "Especial":"Nao Especial");
		sb.append(delimitador);
		sb.append(secao);
		
		return sb.toString();
	}
	
	// get set
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public boolean isEspecial() {
		return especial;
	}
	public void setEspecial(boolean especial) {
		this.especial = especial;
	}
	public String getSecao() {
		return secao;
	}
	public void setSecao(String secao) {
		this.secao = secao;
	}

}
