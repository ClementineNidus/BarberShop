package edu.itstep.barber_db.controller;

import edu.itstep.barber_db.entity.Appointment;
import edu.itstep.barber_db.entity.Barber;
import edu.itstep.barber_db.entity.Client;
import edu.itstep.barber_db.entity.Service;
import edu.itstep.barber_db.repository.AppointmentRepository;
import edu.itstep.barber_db.repository.BarberRepository;
import edu.itstep.barber_db.repository.ClientRepository;
import edu.itstep.barber_db.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private BarberRepository barberRepository;

    @Autowired
    private ClientRepository clientRepository;



    @RequestMapping("/showAppointment")
    public String showAll(Model model){
        List<Appointment> appointments = appointmentRepository.getAll();
        model.addAttribute("appointment", appointments);
        return "Main-appointment";
    }

    @RequestMapping("/createAppointment")
    public String createAppointment(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("clients", clientRepository.getAll());
        model.addAttribute("barbers", barberRepository.getAll());
        return "appointment-form";
    }

    @RequestMapping("/saveAppointment")
    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment) {
        appointmentRepository.saveOrUpdate(appointment);
        return "redirect:/";
    }

    @RequestMapping("/editAppointment")
    public String editAppointment(@RequestParam("id") int id, Model model) {
        Appointment appointment = appointmentRepository.getById(id);
        model.addAttribute("appointment", appointment);
        model.addAttribute("clients", clientRepository.getAll());
        model.addAttribute("barbers", barberRepository.getAll());
        return "appointment-form";
    }

    @RequestMapping("/deleteAppointment")
    public String deleteAppointment(@RequestParam("id") int id) {
        appointmentRepository.deleteById(id);
        return "redirect:/";
    }



    @PostMapping("/saveAppointmentBarber")
    public String saveAppointmentBarber(@RequestParam("barberId") int barberId,
                                        @RequestParam("firstName") String firstName,
                                        @RequestParam("lastName") String lastName,
                                     @RequestParam(value = "appointmentIds", required = false) String[] appointmentIdsStr) {
        Barber barber = barberRepository.getById(barberId);
        if (appointmentIdsStr != null && appointmentIdsStr.length > 0) {
            List<Integer> appointmentIds = Arrays.stream(appointmentIdsStr)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            barber.getAppointments().clear();
            barberRepository.saveOrUpdate(barber);
            for (Integer appId : appointmentIds) {
                Appointment appointment = appointmentRepository.getById(appId);
                barber.addAppointment(appointment);
            }
            barberRepository.saveOrUpdate(barber);
        } else {
            barber.getAppointments().clear();
            barberRepository.saveOrUpdate(barber);
        }
        return "redirect:/";
    }


    @PostMapping("/saveAppointmentClient")
    public String saveAppointmentClient(@RequestParam("clientId") int clientId,
                                        @RequestParam("firstName") String firstName,
                                        @RequestParam("lastName") String lastName,
                                        @RequestParam(value = "appointmentIds", required = false) String[] appointmentIdsStr) {
        Client client = clientRepository.getById(clientId);
        if (appointmentIdsStr != null && appointmentIdsStr.length > 0) {
            List<Integer> appointmentIds = Arrays.stream(appointmentIdsStr)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            client.getAppointments().clear();
            clientRepository.saveOrUpdate(client);
            for (Integer appId : appointmentIds) {
                Appointment appointment = appointmentRepository.getById(appId);
                client.addAppointment(appointment);
            }
            clientRepository.saveOrUpdate(client);
        } else {
            client.getAppointments().clear();
            clientRepository.saveOrUpdate(client);
        }
        return "redirect:/";
    }


    @RequestMapping("/editAppointmentBarber")
    public String editAppointmentBarber(@RequestParam(value = "barberId", required = false) Integer barberId,
                                        @RequestParam(value = "firstName", required = false) String firstName,
                                        @RequestParam(value = "lastName", required = false) String lastName,
                                        @RequestParam(value = "appointmentId", required = false) Integer appointmentId,
                                        Model model) {


        if (barberId == null) {

            barberId = 0;
        }
        if (appointmentId == null) {

            appointmentId = 0;
        }


        Barber barber = barberRepository.getById(barberId);
        List<Appointment> allAppointments = appointmentRepository.getAll();
        List<Barber> allBarbers = barberRepository.getAll();
        model.addAttribute("barberId", barberId);
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("barberAppointments", barber.getAppointments());
        model.addAttribute("allAppointments", allAppointments);
        model.addAttribute("allBarbers", allBarbers);
        model.addAttribute("appointmentId", appointmentId);
        return "edit-appointment-barber-form";
    }

    @RequestMapping("/editAppointmentClient")
    public String editAppointmentClient(@RequestParam(value = "clientId", required = false) Integer clientId,
                                        @RequestParam(value = "firstName", required = false) String firstName,
                                        @RequestParam(value = "lastName", required = false) String lastName,
                                        @RequestParam(value = "appointmentId", required = false) Integer appointmentId,
                                        Model model) {

        if (clientId == null) {

            clientId = 0;
        }
        if (appointmentId == null) {

            appointmentId = 0;
        }


        Client client = clientRepository.getById(clientId);
        List<Appointment> allAppointments = appointmentRepository.getAll();
        List<Client> allClients = clientRepository.getAll();
        model.addAttribute("clientId", clientId);
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("appointmentId", appointmentId);
        model.addAttribute("clientAppointments", client.getAppointments());
        model.addAttribute("allAppointments", allAppointments);
        model.addAttribute("allClients", allClients);
        return "edit-appointment-client-form";
    }




    @RequestMapping("/getAllAppointment")
    @ResponseBody
    public List<Appointment> getAllAppointment() {
        return appointmentRepository.getAll();
    }


}
