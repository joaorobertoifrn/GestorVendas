package br.com.helpc.gestorvendas.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.helpc.gestorvendas.domain.Cliente;
import br.com.helpc.gestorvendas.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
