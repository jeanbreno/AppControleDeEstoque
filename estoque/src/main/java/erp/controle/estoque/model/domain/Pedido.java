package erp.controle.estoque.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import erp.controle.estoque.exceptions.LojaNulaException;
import erp.controle.estoque.exceptions.NaoExisteRoupasException;

public class Pedido {
	
	private String numeroPedido;
	private LocalDateTime data;
	private Loja loja;
	private List<Roupa> roupas;
	
	String delimitador = ";";
	
	public Pedido(Loja loja) throws LojaNulaException  {
		
		if(loja == null) {
			throw new LojaNulaException("Não é possível seguir sem uma loja vinculada ao pedido.");
		}
		
		this.numeroPedido = "Pedido #####";
		this.data = LocalDateTime.now();
		this.loja = loja;
	}
	
	public float calcularValorTotalPedido() {
		
		float valorTotal = 0;
		
		for(Roupa rp : roupas) {
			valorTotal = valorTotal + rp.calcularValorTotalDoItem();
		}
		
		return valorTotal;
	}
	
	public String obterLinhaGravacaoArquivo() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(numeroPedido);
		sb.append(delimitador);
		sb.append(loja.getNome());
		sb.append(delimitador);
		sb.append(roupas.size());
		sb.append(delimitador);
		sb.append(calcularValorTotalPedido());
		sb.append("\r\n");
		
		return sb.toString();
	}
	
	public void relatorio() throws NaoExisteRoupasException {
		
		if(roupas == null) {
			throw new NaoExisteRoupasException("Não existem roupas associadas ao pedido(Pedido não associado a uma lista de pedidos).");
		}
		
		if(roupas.size() == 0) {
			throw new NaoExisteRoupasException("Não existem roupas associadas ao pedido(Lista de pedidos está vazia).");
		}
		
		System.out.println("Relatório: ");
		System.out.println(this);
		System.out.println("- Pedidos ");
		for(Roupa rp : roupas) {
			System.out.println(" # " + rp);
		}
	}

	@Override
	public String toString() {
		
		int qtdRoupas = roupas != null ? roupas.size() : 0;
		
//		if(qtdRoupas > 0) {
//			for (int i = 0; i < roupas.size() ; i++) {
//				System.out.println("Pedido "+ (i+1) + " : " + roupas.get(i));
//			}
//		}
		
		DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		return String.format("%s ; %s ; %s ; %d",
				this.data.format(formataData),
				this.numeroPedido,
				this.loja,
				qtdRoupas
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

	public List<Roupa> getRoupas() {
		return roupas;
	}

	public void setRoupas(List<Roupa> roupas) {
		this.roupas = roupas;
	}
	
}
