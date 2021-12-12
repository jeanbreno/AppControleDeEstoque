package erp.controle.estoque.model.domain;

import erp.controle.estoque.exceptions.QuantidadeInvalidaException;
import erp.controle.estoque.exceptions.TamanhoInvalidoException;
import erp.controle.estoque.exceptions.ValorInvalidoException;

public class Calca extends Roupa {

	private String marca;
	private boolean especial;
	private String secao;
	private String estilo;
	private boolean comCinto;
	
	public Calca(String descricao, float valor, String disponibilidade, String tamanho, int quantidade) throws ValorInvalidoException, TamanhoInvalidoException, QuantidadeInvalidaException {
		super(descricao, valor, disponibilidade, tamanho, quantidade);
	}

	@Override
	public float calcularValorTotalDoItem() {
		
		float valorEspecial = (float) (this.getValor() * 1.15);
		float valorTotalDoItem = (especial ? ((comCinto ? 20 : 0) + valorEspecial)  * getQuantidade() : ((comCinto ? 10 : 0) + this.getValor()) * getQuantidade());
		return valorTotalDoItem;
	}

	@Override
	public float calcularQuantidadeDoItem() {
		return 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(" - ");
		sb.append(marca);
		sb.append(" - ");
		sb.append(especial);
		sb.append(" - ");
		sb.append(secao);
		sb.append(" - ");
		sb.append(estilo);
		sb.append(" - ");
		sb.append(comCinto);
		
		return sb.toString();
	}
	
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

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public boolean isComCinto() {
		return comCinto;
	}

	public void setComCinto(boolean comCinto) {
		this.comCinto = comCinto;
	}

}
