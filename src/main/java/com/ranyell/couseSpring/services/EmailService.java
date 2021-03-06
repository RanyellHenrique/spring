package com.ranyell.couseSpring.services;

import org.springframework.mail.SimpleMailMessage;

import com.ranyell.couseSpring.domain.Cliente;
import com.ranyell.couseSpring.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
