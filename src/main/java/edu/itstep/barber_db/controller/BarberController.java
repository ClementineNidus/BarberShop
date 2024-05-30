package edu.itstep.barber_db.controller;

import edu.itstep.barber_db.entity.Barber;
import edu.itstep.barber_db.repository.BarberRepository;
import edu.itstep.barber_db.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class BarberController {

    @Autowired
    private BarberRepository barberRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @RequestMapping("/")
    public String showAll(Model model){
        List<Barber> barbers = barberRepository.getAll();
        model.addAttribute("barber", barbers);
        return "Main";
    }

    @RequestMapping("/createBarber")
    public String createBarber(Model model) {
        model.addAttribute("barber", new Barber());
        return "barber-form";
    }

    @RequestMapping("/saveBarber")
    public String saveBarber(@ModelAttribute("barber") Barber barber, Model model) {
        try {
        barberRepository.saveOrUpdate(barber);
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("errorMessage", "Barber with this phone number already exists.");
            return "barber-form";
        }
        return "redirect:/";
    }

    @RequestMapping("/editBarber")
    public String editBarber(@RequestParam("id") int id, Model model) {
        Barber barber = barberRepository.getById(id);
        model.addAttribute("barber", barber);
        return "barber-form";
    }

    @RequestMapping("/deleteBarber")
    public String deleteBarber(@RequestParam("id") int id) {
        barberRepository.deleteById(id);
        return "redirect:/";
    }



    @RequestMapping("/sortBarbers")
    public String sortBarbers(@RequestParam("sortBy") String sortBy, Model model) {
        List<Barber> barbers;
        if (sortBy.equals("firstName")) {
            barbers = barberRepository.getAllSortedByName();
        } else {
            barbers = barberRepository.getAll();
        }
        model.addAttribute("barber", barbers);
        return "Main";
    }




}
