package com.devfreitag.orderservice.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devfreitag.orderservice.domain.exception.RuleException;
import com.devfreitag.orderservice.domain.model.Cliente;
import com.devfreitag.orderservice.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente save(Cliente cliente) {
		Cliente existClient = clienteRepository.findByEmail(cliente.getEmail());
		
		if (existClient != null && !existClient.equals(cliente)) {
			throw new RuleException("Já existe um cliente cadastrado com este e-mail.");
		}
		return clienteRepository.save(cliente);
	}
	
	public void delete(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
}
