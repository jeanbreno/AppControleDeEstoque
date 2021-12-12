package erp.controle.estoque.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Pedido {
	
	private String numeroPedido;
	private LocalDateTime data;
	private Loja loja;
	private List<Roupa> roupas;
	
	public Pedido()  {
		this.numeroPedido = "Pedido #####";
		this.data = LocalDateTime.now();
	}

	@Override
	public String toString() {
		
		for (int i = 0; i < roupas.size() ; i++) {
			System.out.println("Pedido "+ (i+1) + " : " + roupas.get(i));
		}
		
		DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		return String.format("%s - %s - %s - %d",
				this.data.format(formataData),
				this.numeroPedido,
				this.loja,
				roupas.size()
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

	public List<Roupa> getRoupas() {
		return roupas;
	}

	public void setRoupas(List<Roupa> roupas) {
		this.roupas = roupas;
	}
}
