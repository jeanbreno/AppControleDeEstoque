package erp.controle.estoque.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import erp.controle.estoque.exceptions.LojaNulaException;
import erp.controle.estoque.exceptions.NaoExisteRoupasException;

@Entity
@Table(name = "TPedido", 
uniqueConstraints = { 
		@UniqueConstraint(columnNames = { "descricao", "idLoja" }) 
	}
)
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private String numeroPedido;
	private LocalDateTime data;
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idLoja")
	private Loja loja;
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<Roupa> roupas;
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	
	public Pedido() {
		this.descricao = "Pedido padrão da empresa";
		this.data = LocalDateTime.now();
	}
	
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
		
		return String.format("%s ; %s ; %s ; %s ; %d",
				this.numeroPedido,
				this.descricao,
				this.data.format(formataData),
				this.loja,
				qtdRoupas
				);
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
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
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
