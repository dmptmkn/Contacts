package com.example.contacts.service.impl;

import com.example.contacts.model.Contact;
import com.example.contacts.model.repository.ContactRepository;
import com.example.contacts.service.ContactService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor
@Component
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;


    @Override
    public void create(Contact contact) {

    }

    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findById(Long id) {
        return contactRepository.findById(id).orElseThrow();
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
