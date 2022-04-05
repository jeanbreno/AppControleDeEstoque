package erp.controle.estoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import erp.controle.estoque.model.domain.Endereco;
import erp.controle.estoque.model.domain.Usuario;
import erp.controle.estoque.model.service.UsuarioService;

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		String email = "jota@gmail.com";
		String senha = "123456";
		
		Usuario usuario = null;
		
		usuario = usuarioService.autenticacao(email, senha);

		if(usuario == null) {
			Endereco endereco = new Endereco();
			endereco.setBairro("Admin Bairro");
			endereco.setCep("99.999-999");
			endereco.setComplemento("Admin Complemento");
			endereco.setLocalidade("Admin Localidade");
			endereco.setLogradouro("Admin Logradouro");
			endereco.setUf("UF");
			
			usuario = new Usuario();
			usuario.setNome("Jota");
			usuario.setEmail("jota@gmail.com");
			usuario.setSenha("123456");
			usuario.setAdmin(true);
			
			usuario.setEndereco(endereco);
	
			usuarioService.incluir(usuario);
		}
	}
}