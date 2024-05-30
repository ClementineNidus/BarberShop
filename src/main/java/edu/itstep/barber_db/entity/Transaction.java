package edu.itstep.barber_db.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction {

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

    @Column(name = "amount")
    private int amount;

    @Column(name = "type")
    private String type;


    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Transaction(Date date_time, Time time, int amount, String type) {
        this.date_time = date_time;
        this.time = time;
        this.amount = amount;
        this.type = type;
    }

    public Transaction() {}


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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", date_time='" + date_time + '\'' +
                ", time='" + time + '\'' +
                ", amount='" + amount + '\'' +
                ", type='" + type  +
                '}';
    }


}
