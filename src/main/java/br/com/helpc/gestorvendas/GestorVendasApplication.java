package br.com.helpc.gestorvendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.helpc.gestorvendas.services.S3Service;

@SpringBootApplication
public class GestorVendasApplication implements CommandLineRunner {

	@Autowired
	private S3Service s3Service;
	
	public static void main(String[] args) {
		SpringApplication.run(GestorVendasApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		s3Service.uploadFile("C:\\Temp\\imagens\\cp1.jpg");
		
	}
	
}
