package com.bolsadeideas.springboot.app.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.bolsadeideas.springboot.app.models.dao.IClientDao;
import com.bolsadeideas.springboot.app.models.entity.Client;
import com.bolsadeideas.springboot.app.service.ClientServiceImpl;

public class ClientServiceTest {
	@InjectMocks
	private ClientServiceImpl clientService;

	@Mock
	private IClientDao clientDao;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void findAllTest() {
		List<Client> clients = new ArrayList<Client>();
		clients.add(new Client("Danny", "Medina", "danny.medina@gmail.com"));
		clients.add(new Client("Juan", "Perez", "juan.perez@gmail.com"));
		clients.add(new Client("Maril", "Doe", "maril.doe@gmail.com"));

		when(clientDao.findAll()).thenReturn(clients);

		List<Client> clientsTest = clientService.findAll();

		assertEquals(3, clientsTest.size());
		verify(clientDao, times(1)).findAll();
	}

	@Test
	public void findOneTest() {
		Mockito.<Optional<Client>>when(clientDao.findById(1L))
				.thenReturn(Optional.of(new Client("Danny", "Medina", "danny.medina@gmail.com")));

		Client client = clientService.findOne(1L);
		assertEquals("Danny", client.getFirstName());
		assertEquals("Medina", client.getLastName());
		assertEquals("danny.medina@gmail.com", client.getEmail());
		verify(clientDao, times(1)).findById(1L);
	}

	@Test
	public void saveTest() {
		Client client = new Client("Danny", "Medina", "danny.medina@gmail.com");
		clientService.save(client);
		verify(clientDao, times(1)).save(client);
	}

	@Test
	public void deleteTest() {
		clientService.delete(1L);
		verify(clientDao, times(1)).deleteById(1L);
	}
}
