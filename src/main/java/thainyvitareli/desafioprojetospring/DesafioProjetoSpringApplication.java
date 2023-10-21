package thainyvitareli.desafioprojetospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesafioProjetoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioProjetoSpringApplication.class, args);
	}

}
