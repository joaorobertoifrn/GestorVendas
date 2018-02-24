package br.com.helpc.gestorvendas.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.helpc.gestorvendas.domain.Cliente;
import br.com.helpc.gestorvendas.repositories.ClienteRepository;
import br.com.helpc.gestorvendas.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private EmailService emailService;
	
	private Random random = new Random();
	
	public void sendNewPassword(String email) {
		Cliente cliente = clienteRepository.findByEmail(email);
		if (cliente == null) {
			throw new ObjectNotFoundException("Email não Encontrado");
		}
		
		String newPassword = newPassword();
		cliente.setSenha(bCryptPasswordEncoder.encode(newPassword));
		clienteRepository.save(cliente);
		emailService.sendNewPasswordEmail(cliente, newPassword);
		
		
	}

	private String newPassword() {
		char[] vet = new char[10];
		for (int i=0; i<10; i++) {
			vet[i] = randomChar(); 
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = random.nextInt(3);
		if (opt == 0) {// gera um digito
			return (char) (random.nextInt(10)+48);
		} else {
			if (opt == 1) { // gera letra maiuscula
				return (char) (random.nextInt(26)+65);
			} else { // gera letra minuscula
				return (char) (random.nextInt(10)+97);
			}
		}
	}

}
