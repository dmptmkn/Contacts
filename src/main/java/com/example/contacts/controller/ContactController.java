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
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public List<Contact> findAll() {
        return contactService.getAll();
    }

    @GetMapping("/{id}")
    public Contact findById(@PathVariable Long id) {
        return contactService.findById(id);
    }

    @PostMapping("/create")
    public void create(@ModelAttribute Contact contact) {
        contactService.create(contact);
    }
}

// дз: написать контроллер для всех остальных методов сервиса