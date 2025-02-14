package com.laet.customer.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;


public class ContactDto {

    private Long id;
    private String mainEmail;
    private String secondaryEmail;
    private Long mainTelephoneNumber;
    private Long secondaryTelephoneNumber;
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
