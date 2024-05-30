package edu.itstep.barber_db.controller;

import edu.itstep.barber_db.entity.Barber;
import edu.itstep.barber_db.entity.Client;
import edu.itstep.barber_db.repository.BarberRepository;
import edu.itstep.barber_db.repository.ClientRepository;
import edu.itstep.barber_db.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @RequestMapping("/showClient")
    public String showAll(Model model){
        List<Client> clients = clientRepository.getAll();
        model.addAttribute("client", clients);
        return "Main-client";
    }

    @RequestMapping("/createClient")
    public String createClient(Model model) {
        model.addAttribute("client", new Client());
        return "client-form";
    }

    @RequestMapping("/saveClient")
    public String saveClient(@ModelAttribute("client") Client client) {
        clientRepository.saveOrUpdate(client);
        return "redirect:/";
    }

    @RequestMapping("/editClient")
    public String editClient(@RequestParam("id") int id, Model model) {
        Client client = clientRepository.getById(id);
        model.addAttribute("client", client);
        return "client-form";
    }

    @RequestMapping("/deleteClient")
    public String deleteClient(@RequestParam("id") int id) {
        clientRepository.deleteById(id);
        return "redirect:/";
    }




}
