package com.example.contacts.controller;

import com.example.contacts.model.Contact;
import com.example.contacts.model.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/v1/contacts")
public class ContactsController {

    private final ContactService contactService;

    @PostMapping("/create")
    public void create(@ModelAttribute("person") Contact contact) {
        contactService.create(contact);
    }

    @GetMapping
    public List<Contact> findAll() {
        return contactService.getAll();
    }

    @GetMapping("/{id}")
    public Contact findById(@PathVariable Long id) {
        return contactService.findById(id);
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
