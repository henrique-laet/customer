package com.laet.customer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.laet.customer.enums.MaritalStatus;
import com.laet.customer.validation.ValidAge;
import com.laet.customer.validation.ValidRg;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "clientes")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Pattern(regexp = "^[A-Z]+(.)*", message = "Primeira letra do nome deve ser maiúscula")
    @Column(name = "nome")
    private String name;

    @ValidRg
    private String rg;

    @CPF(message = "Número CPF inválido")
    @NotBlank(message = "CPF não informado")
    private String cpf;


    @NotNull(message = "A data de nascimento nao pode ser nula")
    @Past(message = "A data de nascimento deve ser no passado")
    @ValidAge(min = 18, max = 120, message = "A idade deve estar entre 18 e 100 anos")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "data_nascimento")
    private LocalDate dateBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_civil")
    private MaritalStatus maritalStatus;

    private LocalDateTime dh_incl;

    public Customer() {
    }

    public Customer(Long id, String name, String rg, String cpf, LocalDate dateBirth, MaritalStatus maritalStatus, LocalDateTime dh_incl) {
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

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public LocalDateTime getDh_incl() {
        return dh_incl;
    }

    public void setDh_incl(LocalDateTime dh_incl) {
        this.dh_incl = dh_incl;
    }
}

