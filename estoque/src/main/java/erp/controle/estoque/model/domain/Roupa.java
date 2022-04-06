package erp.controle.estoque.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import erp.controle.estoque.exceptions.QuantidadeInvalidaException;
import erp.controle.estoque.exceptions.TamanhoInvalidoException;
import erp.controle.estoque.exceptions.ValorInvalidoException;

@Entity
@Table(name = "TRoupa", 
uniqueConstraints = { 
		@UniqueConstraint(columnNames = { "nome", "descricao", "valor", "disponibilidade", "tamanho", "quantidade" }) 
	}
)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Roupa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	private float valor;
	private String disponibilidade;
	private String tamanho;
	private int quantidade;
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	@ManyToMany(mappedBy = "roupas")
	private List<Pedido> pedidos;
	
	String delimitador = ";";
	
	public Roupa() {
		
	}
	
	public Roupa(String nome, String descricao, float valor, String disponibilidade, String tamanho, int quantidade) throws ValorInvalidoException, TamanhoInvalidoException, QuantidadeInvalidaException {
		
		if(valor == 0) {
			throw new ValorInvalidoException("Não é possível cadastrar item com o campo Valor igual a zero.");
		}
		if(valor < 0) {
			throw new ValorInvalidoException("Não é possível cadastrar item com o campo Valor menor que zero.");
		}
		if(tamanho == null) {
			throw new TamanhoInvalidoException("Não é possível cadastrar item com o campo Tamanho nulo.");
		}
		if(quantidade == 0) {
			throw new QuantidadeInvalidaException("Não é possível cadastrar item com o campo Quantidade igual a zero");
		}
		if(quantidade < 0) {
			throw new QuantidadeInvalidaException("Não é possível cadastrar item com o campo Quantidade menor que zero");
		}
		
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.disponibilidade = disponibilidade;
		this.tamanho = tamanho;
		this.quantidade = quantidade;
	}
	
	public abstract float calcularValorTotalDoItem();
	//public abstract float calcularQuantidadeDoItem();
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append(descricao);
		sb.append(delimitador);
		sb.append(valor);
		sb.append(delimitador);
		sb.append(tamanho);
		sb.append(delimitador);
		sb.append(quantidade);
		sb.append(delimitador);
		sb.append(disponibilidade);
		sb.append(delimitador);
		sb.append(this.calcularValorTotalDoItem());
		//sb.append(delimitador);
		//sb.append(this.calcularQuantidadeDoItem());
		
		return sb.toString();
	}
	
	public Integer getId() {
		return id;
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
	
	public Usuario getUsuario() {
		return usuario;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
