package erp.controle.estoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import erp.controle.estoque.model.domain.Calca;
import erp.controle.estoque.model.domain.Camisa;
import erp.controle.estoque.model.domain.Casaco;
import erp.controle.estoque.model.domain.Usuario;
import erp.controle.estoque.model.service.RoupaService;

@Order(3)
@Component
public class RoupaLoader implements ApplicationRunner {

	@Autowired
	private RoupaService roupaService;

	@Override
	public void run(ApplicationArguments args) {
		try {		
			Usuario usuario = new Usuario();
			usuario.setId(1);
	
			Calca skinny = new Calca("Calca Skinny", "Calca Skinny Festival RPM", 110, "2 dias", "53", 6);
			skinny.setEspecial(true);
			skinny.setComCinto(false);
			skinny.setMarca("Marca Calça");
			roupaService.incluir(skinny);
			
			Camisa esporte = new Camisa("Camisa Esporte","Blusa esporte azul com brasão", 19, "Imediata", "G", 5);
			esporte.setEspecial(false);
			esporte.setUsuario(usuario);
			roupaService.incluir(esporte);
			
			Casaco canguru = new Casaco("Casaco Canguru","Casaco Canguru TT.T", 50, "10 dias", "M", 3);
			canguru.setEspecial(false);
			canguru.setTemCapuz(true);
			canguru.setUsuario(usuario);
			roupaService.incluir(canguru);
			
		} catch (Exception e) {
			System.out.println("Impossível realizar a inclusão: " + e.getMessage());
		}
	}
}