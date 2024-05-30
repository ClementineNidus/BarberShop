package edu.itstep.barber_db.controller;

import edu.itstep.barber_db.entity.Barber;
import edu.itstep.barber_db.entity.Service;
import edu.itstep.barber_db.repository.BarberRepository;
import edu.itstep.barber_db.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private BarberRepository barberRepository;


    @RequestMapping("/showService")
    public String showAll(Model model){
        List<Service> services = serviceRepository.getAll();
        model.addAttribute("service", services);
        return "Main-service";
    }


    @RequestMapping("/createService")
    public String createService(Model model) {
        model.addAttribute("service", new Service());
        return "service-form";
    }


    @RequestMapping("/viewServices")
    public String viewServices(Model model) {
        List<Service> services = serviceRepository.getAll();
        model.addAttribute("services", services);
        return "service-form";
    }







    @RequestMapping("/saveService")
    public String saveService(@ModelAttribute("service") Service service) {
        if (service.getId() != 0) {
            Service existingService = serviceRepository.getById(service.getId());
            existingService.setTitle(service.getTitle());
            existingService.setDescription(service.getDescription());
            existingService.setPrice(service.getPrice());
            serviceRepository.saveOrUpdate(existingService);
        } else {
            serviceRepository.saveOrUpdate(service);
        }
        return "redirect:/";
    }


    @RequestMapping("/editServiceBarber")
    public String editServiceBarber(@RequestParam("barberId") int barberId, Model model) {
        Barber barber = barberRepository.getById(barberId);
        List<Service> allServices = serviceRepository.getAll();
        model.addAttribute("barberId", barberId);
        model.addAttribute("barberServices", barber.getServices());
        model.addAttribute("allServices", allServices);
        return "edit-service-form";
    }

    @RequestMapping("/editService")
    public String editService(@RequestParam("id") int id, Model model) {
        Service service = serviceRepository.getById(id);
        model.addAttribute("service", service);
        return "service-form";
    }


    @PostMapping("/saveBarberServices")
    public String saveBarberServices(@RequestParam("barberId") int barberId,
                                          @RequestParam(value = "serviceIds", required = false) List<Integer> serviceIds) {
        Barber barber = barberRepository.getById(barberId);
        if (serviceIds != null) {
            barber.getServices().clear();
            barberRepository.saveOrUpdate(barber);
            for (Integer servId : serviceIds) {
                Service service = serviceRepository.getById(servId);
                barber.addService(service);
            }
            barberRepository.saveOrUpdate(barber);
        } else {
            barber.getServices().clear();
            barberRepository.saveOrUpdate(barber);
        }
        return "redirect:/";
    }



    @RequestMapping("/getAllServices")
    @ResponseBody
    public List<Service> getAllServices() {
        return serviceRepository.getAll();
    }




}
