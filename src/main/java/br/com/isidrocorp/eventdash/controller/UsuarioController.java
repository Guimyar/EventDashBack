package br.com.isidrocorp.eventdash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.eventdash.dao.UsuarioDAO;
import br.com.isidrocorp.eventdash.model.Usuario;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO dao;
	
	//quero fazer um metodo de LOGIN - para isso preciso enviar alguma informaçao pro Back End
	@PostMapping("/login")
	public ResponseEntity<Usuario> fazerLogin(@RequestBody Usuario dadoLogin) {
		
		Usuario res = dao.findByEmailOrRacf(dadoLogin.getEmail(), dadoLogin.getRacf());
		if(res != null) {
			if (res.getSenha().equals(dadoLogin.getSenha())) {
				return ResponseEntity.ok(res);
			}
		}
		return ResponseEntity.status(403).build();
	} 
	
	
}
