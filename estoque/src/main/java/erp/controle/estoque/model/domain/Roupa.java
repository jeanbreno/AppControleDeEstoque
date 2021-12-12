package erp.controle.estoque.model.domain;

public abstract class Roupa {
	
	private String descricao;
	private float valor;
	private String disponibilidade;
	private String tamanho;
	private int quantidade;
	
	public Roupa(String descricao, float valor, String disponibilidade, String tamanho, int quantidade) {
		this.descricao = descricao;
		this.valor = valor;
		this.disponibilidade = disponibilidade;
		this.tamanho = tamanho;
		this.quantidade = quantidade;
	}
	
	public abstract float calcularValorTotalDoItem();
	public abstract float calcularQuantidadeDoItem();
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(disponibilidade);
		sb.append(" - ");
		sb.append(descricao);
		sb.append(" - ");
		sb.append(tamanho);
		sb.append(" - ");
		sb.append(valor);
		sb.append(" - ");
		sb.append(quantidade);
		sb.append(" - ");
		sb.append(this.calcularValorTotalDoItem());
		sb.append(" - ");
		sb.append(this.calcularQuantidadeDoItem());
		
		return sb.toString();
	}

	public String getDescricao() {
		return descricao;
	}

	public float getValor() {
		return valor;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public String getTamanho() {
		return tamanho;
	}

	public int getQuantidade() {
		return quantidade;
	}
	
}
