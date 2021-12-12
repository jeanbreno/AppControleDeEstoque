package erp.controle.estoque.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pedido {
	
	private String numeroPedido;
	private LocalDateTime data;
	private Loja loja;
	
	
	public Pedido() {
		this.numeroPedido = "Sem descrição";
		this.data = LocalDateTime.now();
	}

	
	@Override
	public String toString() {
		
		DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		return String.format("%s - %s : %s ",
				this.data.format(formataData),
				this.numeroPedido,
				this.loja
				);
	}



	public String getNumeroPedido() {
		return numeroPedido;
	}


	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
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
