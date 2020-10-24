package com.streaming.helpdesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.streaming.helpdesk.model.HelpDesk;
import com.streaming.helpdesk.repository.HelpDeskRepository;


@RestController
@RequestMapping(value = "api/v1")

public class HelpDeskController {
	
	@Autowired
	private HelpDeskRepository helpdeskrepository;
	
	
 	
//	@RequestMapping(value = "/helpdesk/{descricao}" , method = RequestMethod.GET)
//    public HelpDesk AddHelpDesk (@RequestBody HelpDesk helpdesk) {
//       return helpdeskrepository.save(helpdesk);
	
	
	@RequestMapping(value = "/helpdesk/{descricao}" , method = RequestMethod.GET)
		public HelpDesk AddHelpDesk (@PathVariable("descricao") String descricao) {
		HelpDesk helpdesk = new HelpDesk();
		helpdesk.setDescricao(descricao);
		return helpdeskrepository.save(helpdesk);
    }
}	
	


