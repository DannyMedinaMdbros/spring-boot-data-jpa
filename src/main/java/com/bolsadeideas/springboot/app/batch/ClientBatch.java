package com.bolsadeideas.springboot.app.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bolsadeideas.springboot.app.models.entity.Client;
import com.bolsadeideas.springboot.app.service.IClientService;

@Component
public class ClientBatch {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	IClientService clientService;
	
	//@Scheduled(cron="0,30 * * * * *")
	public void cronJob() {
		log.info("> CronJob");
		
		List<Client> clients = clientService.findAll();
		log.info("There are {} clients registered",clients.size());
		
		log.info("< CronJob");

	}
}
