package com.laet.customer.controller;

import com.laet.customer.dto.ContactDto;
import com.laet.customer.entity.Contact;
import com.laet.customer.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<Contact> createdContact(@RequestBody ContactDto contactDto) {
        Contact createdContact = contactService.createdContact(contactDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdContact);
    }

    @GetMapping
    public List<Contact> getAllContact(){
        return contactService.getAllContact();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id){
        Contact contact = contactService.getContactById(id);
        return ResponseEntity.ok(contact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody ContactDto contactDto) {
        Contact updateContact = contactService.updateContact(id, contactDto);
        return ResponseEntity.ok(updateContact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Contact> deleteContact(@PathVariable Long id){
        return contactService.deleteContact(id) ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }
}
