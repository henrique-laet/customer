package com.laet.customer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.laet.customer.enums.MaritalStatus;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;


@Entity
@Table(name = "clientes")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    private String rg;

    private String cpf;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "data_nascimento")
    private Date dateBirth;

    @Enumerated(EnumType.STRING)
    @Column(name =  "estado_civil")
    private MaritalStatus maritalStatus;

    private Timestamp dh_incl;

    public Customer(Long id, String name, String rg, String cpf, Date dateBirth, MaritalStatus maritalStatus, Timestamp dh_incl) {
        this.id = id;
        this.name = name;
        this.rg = rg;
        this.cpf = cpf;
        this.dateBirth = dateBirth;
        this.maritalStatus = maritalStatus;
        this.dh_incl = dh_incl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Timestamp getDh_incl() {
        return dh_incl;
    }

    public void setDh_incl(Timestamp dh_incl) {
        this.dh_incl = dh_incl;
    }
}

