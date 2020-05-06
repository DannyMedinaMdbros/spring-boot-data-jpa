package com.bolsadeideas.springboot.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.models.entity.Bill;
import com.bolsadeideas.springboot.app.models.entity.Client;
import com.bolsadeideas.springboot.app.models.entity.Product;
import com.bolsadeideas.springboot.app.service.IClientService;

@Controller
@RequestMapping("/bill")
@SessionAttributes("bill")
public class BillController {
	@Autowired
	private IClientService clientService;
	
	@GetMapping("/form/{clientId}")
	public String create(@PathVariable Long clientId, Model model, RedirectAttributes flash) {
		Client client = clientService.findOne(clientId);
		if (null == client) {
			flash.addFlashAttribute("error", "The client Id doesn't exists");
			return "redirect:/clientList";
		}
		Bill bill = new Bill();
		bill.setClient(client);
		model.addAttribute("title", "Create Bill");
		model.addAttribute("bill", bill);
		return "bill/form";
	}
	
	@GetMapping(value="/load-products/{term}", produces="application/json")
	public @ResponseBody List<Product> loadProducts(@PathVariable String term) {
		return clientService.findByName(term);
	}
	
}
