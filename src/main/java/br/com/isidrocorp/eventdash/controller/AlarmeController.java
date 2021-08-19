package br.com.isidrocorp.eventdash.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.eventdash.dao.AlarmeDAO;
import br.com.isidrocorp.eventdash.model.Alarme;

@RestController
public class AlarmeController {

	//aqui o Autowired é reponsavel por, alem de buscar um objeto que faz a 
	//implementacao da interface, ele tambem cria a instaciação do objeto
	//ou seja, não preciso dar NEW
	@Autowired
	private AlarmeDAO dao;
	
	//quero criar um método que me retorne TDOS os alarmes gravados no banco e fazer um select
	@GetMapping("/alarmes")
	public ArrayList<Alarme> recuperarTodos(){
		
		//basicamnete ele deve entrar em contato com o BD 
		ArrayList<Alarme> lista;
		lista = (ArrayList<Alarme>)dao.findAll();
		return lista;
		
	}
	
}
