package com.devfreitag.orderservice.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devfreitag.orderservice.domain.model.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Alex");
		cliente1.setTelefone("47 99999-9999");
		cliente1.setEmail("alex@email.com");
		
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Freitag");
		cliente2.setTelefone("47 99999-9999");
		cliente2.setEmail("freitag@email.com");
		
		return Arrays.asList(cliente1, cliente2);
	}
}
