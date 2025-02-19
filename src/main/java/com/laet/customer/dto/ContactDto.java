package com.laet.customer.dto;

import com.laet.customer.validation.ValidTelephone;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;


public class ContactDto {

    private Long id;

    @Email(message = "Email inválido")
    @NotBlank(message = "O email não pode estar nulo")
    @Column(name = "email_principal")
    private String mainEmail;

    @Email(message = "Email inválido")
    private String secondaryEmail;

    @ValidTelephone(message = "Telefone Inválido")
    @NotBlank(message = "O telefone pricipal não pode estar nulo")
    private String mainTelephoneNumber;

    @ValidTelephone(message = "Telefone Inválido")
    private String secondaryTelephoneNumber;
    private Long costumerId;
    private LocalDateTime dh_incl;


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

    public Long getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(Long costumerId) {
        this.costumerId = costumerId;
    }

    public LocalDateTime getDh_incl() {
        return dh_incl;
    }

    public void setDh_incl(LocalDateTime dh_incl) {
        this.dh_incl = dh_incl;
    }
}
