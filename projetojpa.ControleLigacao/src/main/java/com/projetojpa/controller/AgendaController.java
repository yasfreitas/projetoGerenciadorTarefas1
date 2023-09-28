package com.projetojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entities.Agenda;
import com.projetojpa.service.AgendaService;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
	private final AgendaService agendaService;

	@Autowired
	public AgendaController(AgendaService agendaService) {
		this.agendaService = agendaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Agenda> buscaAgendaControlId (@PathVariable Long id){
		Agenda agenda = agendaService.buscaAgendaId(id);
		if(agenda != null) {
			return ResponseEntity.ok(agenda);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Agenda>> buscaTodosAgendaControl(){
		List<Agenda> agenda = agendaService.buscaTodosProdutos();
		return ResponseEntity.ok(agenda);
	}

	@PostMapping("/")
	public ResponseEntity<Agenda> salvaAgendaControl(@RequestBody Agenda agenda){
		Agenda salvaAgenda = agendaService.saveAgenda(agenda);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaAgenda);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Agenda> alteraAgendaControl(@PathVariable Long codigo, @RequestBody Agenda agenda){
		Agenda alteraAgenda = agendaService.alterarAgenda(codigo, agenda);
		if (alteraAgenda != null) {
		return ResponseEntity.ok(agenda);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaAgendaControl(@PathVariable Long codigo){
		boolean apagar = agendaService.apagarAgenda(codigo);
		if(apagar) {
			return ResponseEntity.ok().body("A agenda foi excluida com sucesso!");
		}
		else {
			return ResponseEntity.notFound().build();    
		}
	}

}