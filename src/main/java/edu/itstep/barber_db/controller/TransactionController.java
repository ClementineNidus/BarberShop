package edu.itstep.barber_db.controller;

import edu.itstep.barber_db.entity.Barber;
import edu.itstep.barber_db.entity.Transaction;
import edu.itstep.barber_db.repository.AppointmentRepository;
import edu.itstep.barber_db.repository.BarberRepository;
import edu.itstep.barber_db.repository.ServiceRepository;
import edu.itstep.barber_db.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @RequestMapping("/showTransaction")
    public String showAll(Model model){
        List<Transaction> transactions = transactionRepository.getAll();
        model.addAttribute("transaction", transactions);
        return "Main-transaction";
    }

    @RequestMapping("/createTransaction")
    public String createTransaction(Model model) {
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("appointment", appointmentRepository.getAll());
        return "transaction-form";
    }

    @RequestMapping("/saveTransaction")
    public String saveTransaction(@ModelAttribute("transaction") Transaction transaction) {
        transactionRepository.saveOrUpdate(transaction);
        return "redirect:/";
    }

    @RequestMapping("/editTransaction")
    public String editTransaction(@RequestParam("id") int id, Model model) {
        Transaction transaction = transactionRepository.getById(id);
        model.addAttribute("transaction", transaction);
        model.addAttribute("appointment", appointmentRepository.getAll());
        return "transaction-form";
    }

    @RequestMapping("/deleteTransaction")
    public String deleteTransaction(@RequestParam("id") int id) {
        transactionRepository.deleteById(id);
        return "redirect:/";
    }


}
