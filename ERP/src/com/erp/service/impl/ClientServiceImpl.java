package com.erp.service.impl;

import java.util.List;

import com.erp.dao.ClientDAO;
import com.erp.pojo.Client;
import com.erp.service.ClientService;

public class ClientServiceImpl implements ClientService {

	private ClientDAO dao;
	
	public ClientDAO getDao() {
		return dao;
	}

	public void setDao(ClientDAO dao) {
		this.dao = dao;
	}

	@Override
	public boolean doIns(Client pojo) {
		return this.dao.doIns(pojo);
	}

	@Override
	public boolean doDel(Long clientId) {
		return this.dao.doDel(clientId);
	}

	@Override
	public boolean doUpd(Client pojo) {
		return this.dao.doUpd(pojo);
	}

	@Override
	public List<Client> findByNameGrade(String clientName, int clientGrade, int clientDel, int pageCurrent) {
		return this.dao.findByNameGrade(clientName, clientGrade, clientDel, pageCurrent);
	}

	@Override
	public int findCountByNameGrade(String clientName, int clientGrade ,int clientDel) {
		return this.dao.findCountByNameGrade(clientName, clientGrade ,clientDel);
	}

	@Override
	public Client findByClientId(Long clientId) {
		return this.dao.findByClientId(clientId);
	}

	@Override
	public List<Client> findAll() {
		return this.dao.findAll();
	}

	@Override
	public boolean doBack(Long clientId) {
		return this.dao.doBack(clientId);
	}

}
