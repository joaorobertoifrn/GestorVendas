package br.com.helpc.gestorvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.helpc.gestorvendas.domain.Pedido;
import br.com.helpc.gestorvendas.repositories.PedidoRepository;
import br.com.helpc.gestorvendas.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Pedido pedido = repo.findOne(id);
		if (pedido == null) {
			throw new ObjectNotFoundException("Pedido não encontrado! Id: "+id+ " , Tipo: "+ Pedido.class.getName());
		}
		return pedido;
	}
}
