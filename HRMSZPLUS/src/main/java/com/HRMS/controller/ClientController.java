package com.HRMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.HRMS.model.ClientMaster;
import com.HRMS.service.ClientService;

@Controller
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public String getAllClients(Model model) {
        try {
            List<ClientMaster> clients = clientService.getAllClients();
            model.addAttribute("clients", clients);
        } catch (Exception e) {
            logger.error("Failed to retrieve clients.", e);
            // Handle exception appropriately, e.g., show an error page.
            return "errorPage";
        }
        return "Client/clientMaintenance";
    }

    @GetMapping("/client/new")
    public String newClientForm(Model model) {
        model.addAttribute("client", new ClientMaster());
        return "Client/newClient";
    }

    @PostMapping("/client/save")
    public String saveNewClient(@ModelAttribute("client") ClientMaster client) {
        try {
            clientService.saveClient(client);
        } catch (Exception e) {
            logger.error("Failed to save client.", e);
            // Handle exception appropriately, e.g., show an error message.
            return "errorPage";
        }
        return "redirect:/clients";
    }

    @GetMapping("/client/edit/{id}")
    public String editClientForm(@PathVariable("id") int id, Model model) {
        try {
            ClientMaster client = clientService.findClientById(id);
            if (client == null) {
                logger.error("Client with ID " + id + " not found.");
                // Handle the case where client is not found, e.g., show a not found page.
                return "notFoundPage";
            }
            model.addAttribute("client", client);
        } catch (Exception e) {
            logger.error("Failed to retrieve client for editing.", e);
            // Handle exception appropriately.
            return "errorPage";
        }
        return "Client/editClient";
    }

    @PostMapping("/client/update/{id}")
    public String updateClient(@PathVariable("id") int id, @ModelAttribute("client") ClientMaster client) {
        try {
            client.setClientID(id);
            clientService.updateClient(client);
        } catch (Exception e) {
            logger.error("Failed to update client.", e);
            // Handle exception appropriately.
            return "errorPage";
        }
        return "redirect:/clients";
    }

    @GetMapping("/client/delete/{id}")
    public String deleteClient(@PathVariable("id") int id) {
        try {
            ClientMaster existingClient = clientService.findClientById(id);
            if (existingClient == null) {
                logger.error("Client with ID " + id + " not found.");
                // Handle the case where client is not found, e.g., show a not found page.
                return "notFoundPage";
            }
            clientService.deleteClient(id);
        } catch (Exception e) {
            logger.error("Failed to delete client.", e);
            // Handle exception appropriately.
            return "errorPage";
        }
        return "redirect:/clients";
    }
}
