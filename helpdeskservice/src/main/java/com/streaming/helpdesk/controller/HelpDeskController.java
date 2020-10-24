package com.streaming.helpdesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.streaming.helpdesk.model.HelpDesk;
import com.streaming.helpdesk.repository.HelpDeskRepository;


@RestController
@RequestMapping(value = "helpdesk/")

public class HelpDeskController {
	
	@Autowired
	private HelpDeskRepository helpdeskrepository;
	
	@PostMapping
	@RequestMapping(value = "Novo", method= RequestMethod.POST)
	public ResponseEntity<HelpDesk> save (@RequestBody HelpDesk helpdesk){
		helpdeskrepository.save(helpdesk);
		return new ResponseEntity<>(helpdesk,HttpStatus.OK);
		
	}
	
//	@GetMapping
//	@RequestMapping(value = "/helpdesk/{descricao}" , method = RequestMethod.GET)
//		public HelpDesk AddHelpDesk (@PathVariable("descricao") String descricao) {
//		HelpDesk helpdesk = new HelpDesk();
//		helpdesk.setDescricao(descricao);
//		return helpdeskrepository.save(helpdesk);
//    }
	
	
	
	
	
}	
	


