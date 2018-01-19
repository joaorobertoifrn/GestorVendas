package br.com.helpc.gestorvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.helpc.gestorvendas.domain.Cliente;
import br.com.helpc.gestorvendas.repositories.ClienteRepository;
import br.com.helpc.gestorvendas.services.exceptions.ObjectNotFoundException;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Cliente cliente = repo.findOne(id);
		if (cliente == null) {
			throw new ObjectNotFoundException("Cliente não encontrado! Id: "+id+ " , Tipo: "+ Cliente.class.getName());
		}
		return cliente;
	}
	
	
	

}
