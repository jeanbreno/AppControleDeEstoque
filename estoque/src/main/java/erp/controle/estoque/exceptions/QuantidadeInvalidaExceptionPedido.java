package erp.controle.estoque.exceptions;

public class QuantidadeInvalidaExceptionPedido extends Exception {

	private static final long serialVersionUID = 1L;

	public QuantidadeInvalidaExceptionPedido(String mensagem) {
		super(mensagem);
	}
}
