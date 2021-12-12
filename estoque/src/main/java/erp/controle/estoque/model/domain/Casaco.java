package erp.controle.estoque.model.domain;

public class Casaco extends Roupa {

	private String marca;
	private boolean especial;
	private String secao;
	private String estilo;
	private boolean temCapuz;
	
	public Casaco(String descricao, float valor, String disponibilidade, String tamanho, int quantidade) {
		super(descricao, valor, disponibilidade, tamanho, quantidade);
	}

	@Override
	public float calcularValorTotalDoItem() {
		
		float valorEspecial = (float) (this.getValor() * 1.20);
		float valorTotalDoItem = (especial ? ((temCapuz ? 10 : 0) + valorEspecial)  * getQuantidade() : ((temCapuz ? 5 : 0) + this.getValor()) * getQuantidade());
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
		sb.append(temCapuz);
		
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

	public boolean isTemCapuz() {
		return temCapuz;
	}

	public void setTemCapuz(boolean temCapuz) {
		this.temCapuz = temCapuz;
	}

}

