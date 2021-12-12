package erp.controle.estoque.exceptions;

public class CnpjInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public CnpjInvalidoException(String mensagem) {
		super(mensagem);
	}
}
