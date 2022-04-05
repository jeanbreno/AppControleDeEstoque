package erp.controle.estoque.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import erp.controle.estoque.exceptions.CnpjInvalidoException;
import erp.controle.estoque.exceptions.EmailInvalidoException;
import erp.controle.estoque.exceptions.NomeInvalidoException;

@Entity
@Table(name = "TLoja", 
	uniqueConstraints = { 
			@UniqueConstraint(columnNames = { "nome", "email" }) 
		}
)
public class Loja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String cnpj;
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	
	public Loja() {

	}
	
	String delimitador = ";";
	
	public Loja(String nome, String email, String cnpj) throws NomeInvalidoException, EmailInvalidoException, CnpjInvalidoException {
		
		if(nome == null) {
			throw new NomeInvalidoException("Não é possível seguir com o campo Nome nulo.");
		}
		if(email == null) {
			throw new EmailInvalidoException("Não é possível seguir com o campo email nulo.");
		}
		if(cnpj == null) {
			throw new CnpjInvalidoException("Não é possível seguir com o campo CNPJ nulo.");
		}
		
		this.nome = nome;
		this.email = email;
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(nome);
		sb.append(delimitador);
		sb.append(email);
		sb.append(delimitador);
		sb.append(cnpj);
		
		return sb.toString();
	}
	
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getCnpj() {
		return cnpj;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}


