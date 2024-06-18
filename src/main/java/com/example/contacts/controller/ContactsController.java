package com.example.contacts.controller;

import com.example.contacts.model.Contact;
import com.example.contacts.model.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/contacts")
public class ContactsController {

    private final ContactService contactService;

    @PostMapping("/create")
    public void create(@RequestBody Contact contact) {
        contactService.create(contact);
    }

    @GetMapping
    public ResponseEntity<List<Contact>> findAll() {
        try {
            List<Contact> contacts = contactService.getAll();
            return ResponseEntity.ok(contacts);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> findById(@PathVariable Long id) {
        try {
            Contact contact = contactService.findById(id);
            return ResponseEntity.ok(contact);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PatchMapping("/{id}?{phone}")
    public void update(@PathVariable("id") Long id, @PathVariable("phone") String phoneNumber) {
        contactService.update(id, phoneNumber);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contactService.delete(id);
    }
}
