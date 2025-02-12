package com.laet.customer.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "contato")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email_principal")
    private String MainEmail;

    @Column(name = "email_secundario")
    private String secondaryEmail;

    @Column(name = "telefone_principal")
    private String mainTelephoneNumber;

    @Column(name = "telefone_secundario")
    private String secondaryTelephoneNumber;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Customer customer;

    private LocalDateTime dh_incl;

    public Contact() {
    }

    public Contact(Long id, String mainEmail, String secondaryEmail, String mainTelephoneNumber, String secondaryTelephoneNumber, Customer customer,LocalDateTime dh_incl) {
        this.id = id;
        MainEmail = mainEmail;
        this.secondaryEmail = secondaryEmail;
        this.mainTelephoneNumber = mainTelephoneNumber;
        this.secondaryTelephoneNumber = secondaryTelephoneNumber;
        this.customer = customer;
        this.dh_incl = dh_incl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMainEmail() {
        return MainEmail;
    }

    public void setMainEmail(String mainEmail) {
        MainEmail = mainEmail;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public String getMainTelephoneNumber() {
        return mainTelephoneNumber;
    }

    public void setMainTelephoneNumber(String mainTelephoneNumber) {
        this.mainTelephoneNumber = mainTelephoneNumber;
    }

    public String getSecondaryTelephoneNumber() {
        return secondaryTelephoneNumber;
    }

    public void setSecondaryTelephoneNumber(String secondaryTelephoneNumber) {
        this.secondaryTelephoneNumber = secondaryTelephoneNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getDh_incl() {
        return dh_incl;
    }

    public void setDh_incl(LocalDateTime dh_incl) {
        this.dh_incl = dh_incl;
    }
}
