package com.HRMS.service.IMPL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HRMS.dao.ClientDAO;
import com.HRMS.model.ClientMaster;
import com.HRMS.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDAO clientDao;

    @Override
    public List<ClientMaster> getAllClients() {
        return (List<ClientMaster>) clientDao.findAll();
    }

    @Override
    public boolean saveClient(ClientMaster client) {
        try {
            clientDao.save(client);
            return true;
        } catch (Exception e) {
            // Log exception
            return false;
        }
    }

    @Override
    public ClientMaster findClientById(int id) {
        Optional<ClientMaster> optionalClient = clientDao.findById(id);
        return optionalClient.orElse(null);
    }

    @Override
    public boolean updateClient(ClientMaster client) {
        try {
            clientDao.save(client);
            return true;
        } catch (Exception e) {
            // Log exception
            return false;
        }
    }

    @Override
    public boolean deleteClient(int id) {
        try {
            clientDao.deleteById(id);
            return true;
        } catch (Exception e) {
            // Log exception
            return false;
        }
    }
}
