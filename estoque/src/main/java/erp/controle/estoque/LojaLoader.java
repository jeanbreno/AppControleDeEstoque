package erp.controle.estoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import erp.controle.estoque.model.domain.Loja;
import erp.controle.estoque.model.domain.Usuario;
import erp.controle.estoque.model.service.LojaService;

@Order(2)
@Component
public class LojaLoader implements ApplicationRunner {
	
	@Autowired
	private LojaService lojaService;

	@Override
	public void run(ApplicationArguments args) {
		
		try {
			Usuario usuario = new Usuario();
			usuario.setId(1);
	
			Loja loja = new Loja("Loja dos Mares", "lojadosmares@praia.com", "69414832000150");
			loja.setUsuario(usuario);
			
			lojaService.incluir(loja);
		} catch (Exception e) {
			System.out.println("Impossível realizar a inclusão: " + e.getMessage());
		}
	}
}