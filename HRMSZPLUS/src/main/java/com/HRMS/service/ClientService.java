package com.HRMS.service;

import java.util.List;

import com.HRMS.model.ClientMaster;

public interface ClientService {
	
	public List<ClientMaster> getAllClients();
	public boolean saveClient(ClientMaster client);
	public ClientMaster findClientById(int id);
	public boolean updateClient(ClientMaster client);
	public boolean deleteClient(int id);
}
