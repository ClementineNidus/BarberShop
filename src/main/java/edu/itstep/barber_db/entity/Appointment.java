package edu.itstep.barber_db.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_time;
    @Column(name = "time")
    @DateTimeFormat(pattern = "HH-mm-ss")
    private Time time;

    @Column(name = "note")
    private String note;


    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "barber_id")
    private Barber barber;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "client_id")
    private Client client;


    @OneToMany(
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
            mappedBy = "appointment",
            fetch = FetchType.LAZY
    )
    private List<Transaction> transactions  = new ArrayList<>();

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Appointment(Date date_time, Time time, String note) {
        this.date_time = date_time;
        this.time = time;
        this.note = note;
    }

    public Appointment(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Barber getBarber() {
        return barber;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", date_time='" + date_time + '\'' +
                ", time='" + time + '\'' +
                ", note='" + note  +
                '}';
    }



    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
        transaction.setAppointment(this);
    }



}
