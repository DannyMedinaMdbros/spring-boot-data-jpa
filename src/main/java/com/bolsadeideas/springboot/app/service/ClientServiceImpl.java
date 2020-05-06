package com.bolsadeideas.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IClientDao;
import com.bolsadeideas.springboot.app.models.dao.IProductDao;
import com.bolsadeideas.springboot.app.models.entity.Client;
import com.bolsadeideas.springboot.app.models.entity.Product;
@Service
public class ClientServiceImpl implements IClientService {
	@Autowired
	IClientDao clientDao;
	@Autowired
	IProductDao productDao;
	
	@Transactional(readOnly=true)
	public List<Client> findAll() {
		return (List<Client>) clientDao.findAll();
	}
	
	@Transactional(readOnly=true)
	public Page<Client> findAll(Pageable pageable) {
		return clientDao.findAll(pageable);
	}
	
	@Transactional(readOnly=true)
	public Client findOne(Long id) {
		return clientDao.findById(id).orElse(null);
	}
	
	@Transactional
	public void save(Client client) {
		clientDao.save(client);
	}

	@Transactional
	public void delete(Long id) {
		clientDao.deleteById(id);
	}

	@Transactional(readOnly=true)
	public List<Product> findByName(String term) {
		return productDao.findByName(term);
	}

	
}
