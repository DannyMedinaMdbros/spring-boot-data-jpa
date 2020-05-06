package com.bolsadeideas.springboot.app.controllers;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.models.entity.Client;
import com.bolsadeideas.springboot.app.service.IClientService;
import com.bolsadeideas.springboot.app.service.IUploadFileService;
import com.bolsadeideas.springboot.app.util.PageRender;

@Controller
@SessionAttributes("client")
public class ClientController {
	@Autowired
	private IClientService clientService;

	@Autowired
	private IUploadFileService uploadFileService;

	@GetMapping("/watch/{id}")
	public String watch(@PathVariable Long id, Model model, RedirectAttributes flash) {
		Client client = clientService.findOne(id);
		if (null == client) {
			flash.addFlashAttribute("error", "The client Id doesn't exists");
			return "redirect:/clientList";
		}
		model.addAttribute("client", client);
		model.addAttribute("title", "Client details: ".concat(client.getFirstName()));
		return "watch";
	}

	@RequestMapping(value = "/clientList", method = RequestMethod.GET)
	public String clientList(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		Pageable pageable = PageRequest.of(page, 4);
		Page<Client> clients = clientService.findAll(pageable);
		PageRender<Client> pageRender = new PageRender<>("/clientList", clients);

		model.addAttribute("title", "Client List");
		model.addAttribute("clients", clients);
		model.addAttribute("page", pageRender);
		return "clientList";
	}

	@RequestMapping("/form")
	public String create(Model model) {
		Client client = new Client();
		model.addAttribute("title", "Create");
		model.addAttribute("client", client);
		return "form";
	}

	@GetMapping("/form/{id}")
	public String edit(@PathVariable("id") Long id, Model model, RedirectAttributes flash) {
		Client client = null;
		if (id > 0) {
			client = clientService.findOne(id);
			if (null == client) {
				flash.addFlashAttribute("error", "The client Id doesn't exists");
				return "redirect:/clientList";
			}
		} else {
			flash.addFlashAttribute("error", "The client Id cannot be zero");
			return "redirect:/clientList";
		}
		model.addAttribute("client", client);
		model.addAttribute("title", "Edit");
		return "form";
	}

	@PostMapping("/form")
	public String save(@Valid Client client, BindingResult result, @RequestParam("file") MultipartFile photo,
			RedirectAttributes flash, Model model, SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("title", "Create");
			return "form";
		}
		if (!photo.isEmpty()) {

			if (client.getId() != null && client.getId() > 0 && client.getPhoto() != null
					&& client.getPhoto().length() > 0) {
				uploadFileService.delete(client.getPhoto());
			}
			String fileName = null;
			try {
				fileName = uploadFileService.copy(photo);
				flash.addFlashAttribute("info", fileName.concat(" file has been upladed succesfully"));
				client.setPhoto(fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String flashMessage = (client.getId() != null) ? "edited" : "created";
		clientService.save(client);
		status.setComplete();
		flash.addFlashAttribute("success", "Client " + flashMessage + " successfully");
		return "redirect:clientList";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		if (id > 0) {
			Client client = clientService.findOne(id);
			clientService.delete(id);
			flash.addFlashAttribute("success", "Client deleted successfully");
			
			if (uploadFileService.delete(client.getPhoto())) {
				flash.addFlashAttribute("info", client.getPhoto() + " photo was deleted succesfully");
			}
		}
		return "redirect:/clientList";

	}
}
