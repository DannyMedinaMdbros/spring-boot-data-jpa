package com.bolsadeideas.springboot.app.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerTest {
    
	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void watchTest() throws Exception {
		
		this.mockMvc.perform(get("/watch/1")).andDo(print()).andExpect(status().isOk())
			.andExpect(model().attributeExists("client"));
		
		this.mockMvc.perform(get("/watch/0")).andExpect(status().is3xxRedirection())
			.andExpect(flash().attribute("error", "The requested client dosen't exist"))
			.andExpect(view().name("redirect:/clientList"));
	}
	
	@Test
	public void clientListTest() throws Exception {
		this.mockMvc.perform(get("/clientList")).andDo(print()).andExpect(status().isOk())
    		.andExpect(view().name("clientList"));
	}
	
	@Test
	public void formTest() throws Exception {
		this.mockMvc.perform(get("/form")).andDo(print()).andExpect(status().isOk())
        	.andExpect(view().name("form"));
	}
	
	@Test
	public void editTest() throws Exception {
		this.mockMvc.perform(get("/form/1")).andDo(print()).andExpect(status().isOk())
        	.andExpect(model().attributeExists("client"));
		
		this.mockMvc.perform(get("/form/0")).andExpect(status().is3xxRedirection())
    		.andExpect(flash().attributeExists("error"))
    		.andExpect(view().name("redirect:/clientList"));
		
		this.mockMvc.perform(get("/form/30")).andExpect(status().is3xxRedirection())
    		.andExpect(flash().attribute("error", "The client Id doesn't exists"))
    		.andExpect(view().name("redirect:/clientList"));
	}
	
}
