package com.ranyell.couseSpring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranyell.couseSpring.domain.Cliente;
import com.ranyell.couseSpring.repositories.ClienteRepository;
import com.ranyell.couseSpring.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", tipo: " + Cliente.class.getName()));
		
	}

}
