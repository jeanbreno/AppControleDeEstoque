package erp.controle.estoque.exceptions;

public class NaoExisteRoupasException extends Exception {

	private static final long serialVersionUID = 1L;

	public NaoExisteRoupasException(String mensagem) {
		super(mensagem);
	}
}
