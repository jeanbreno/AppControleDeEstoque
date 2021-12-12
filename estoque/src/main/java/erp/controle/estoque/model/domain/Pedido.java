package erp.controle.estoque.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pedido {
	
	private String descricao;
	private LocalDateTime data;
	private Loja loja;
	
	
	public Pedido() {
		this.descricao = "Sem descrição";
		this.data = LocalDateTime.now();
	}

	
	@Override
	public String toString() {
		DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		return String.format("%s - %s - %s ",
				this.data.format(formataData),
				this.descricao,
				this.loja
				);
	}



	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public LocalDateTime getData() {
		return data;
	}


	public Loja getLoja() {
		return loja;
	}


	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	
	
}
