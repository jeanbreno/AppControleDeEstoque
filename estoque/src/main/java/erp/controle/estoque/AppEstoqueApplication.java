package erp.controle.estoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppEstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppEstoqueApplication.class, args);
	}

}
