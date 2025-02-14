package com.laet.customer.service;

import com.laet.customer.dto.ContactDto;
import com.laet.customer.entity.Contact;
import com.laet.customer.entity.Customer;
import com.laet.customer.exception.ContactNotFoundException;
import com.laet.customer.repository.ContactRepository;
import com.laet.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Contact> getAllContact(){
        return contactRepository.findAll();
    }

    public Contact getContactById(Long id){
        return contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contato nao encontrado com ID: " + id));
    }

    public Contact createdContact(ContactDto contactDto) {

        Optional<Customer> customer = customerRepository.findById(contactDto.getCostumerId());
        if (customer.isPresent()) {
            Contact contact = new Contact();

            contact.setMainEmail(contactDto.getMainEmail());
            contact.setSecondaryEmail(contactDto.getSecondaryEmail());
            contact.setMainTelephoneNumber(contactDto.getMainTelephoneNumber());
            contact.setSecondaryTelephoneNumber(contactDto.getSecondaryTelephoneNumber());
            contact.setCustomer(customer.get());
            contact.setDh_incl(LocalDateTime.now());

            return contactRepository.save(contact);
        }else {
            throw new ContactNotFoundException(contactDto.getCostumerId());
        }
    }

    public Contact updateContact(Long id, ContactDto contactDto) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Não foi possivel fazer a atualização do contato com o ID: " + id));

        contact.setMainEmail(contactDto.getMainEmail());
        contact.setSecondaryEmail(contactDto.getSecondaryEmail());
        contact.setMainEmail(contactDto.getMainEmail());
        contact.setSecondaryEmail(contactDto.getSecondaryEmail());
        contact.setDh_incl(LocalDateTime.now());

        if (contactDto.getCostumerId()!= null) {
            Optional<Customer> customer = customerRepository.findById(contactDto.getCostumerId());
            if (customer.isPresent()) {
                contact.setCustomer(customer.get());
            } else {
                throw new ContactNotFoundException("Cliente não encontrado com ID: " + contactDto.getCostumerId());
            }
        }
        return contactRepository.save(contact);
    }

    public boolean deleteContact(Long id) {
        if(!contactRepository.existsById(id)) {
            throw new ContactNotFoundException("Não foi possivel deletar o contato com o ID: " + id);
        }
        contactRepository.deleteById(id);
        return true;
    }
}
