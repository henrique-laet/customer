package com.laet.customer.entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "contato")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email_principal")
    private String mainEmail;

    @Column(name = "email_secundario")
    private String secondaryEmail;

    @Column(name = "telefone_principal")
    private Long mainTelephoneNumber;

    @Column(name = "telefone_secundario")
    private Long secondaryTelephoneNumber;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Customer customer;

    private LocalDateTime dh_incl;

    public Contact() {
    }

    public Contact(Long id, String mainEmail, String secondaryEmail, Long mainTelephoneNumber, Long secondaryTelephoneNumber, Customer customer,LocalDateTime dh_incl) {
        this.id = id;
        this.mainEmail = mainEmail;
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
        return mainEmail;
    }

    public void setMainEmail(String mainEmail) {
        this.mainEmail = mainEmail;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public Long getMainTelephoneNumber() {
        return mainTelephoneNumber;
    }

    public void setMainTelephoneNumber(Long mainTelephoneNumber) {
        this.mainTelephoneNumber = mainTelephoneNumber;
    }

    public Long getSecondaryTelephoneNumber() {
        return secondaryTelephoneNumber;
    }

    public void setSecondaryTelephoneNumber(Long secondaryTelephoneNumber) {
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
