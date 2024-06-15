package com.example.contacts.model.service.impl;

import com.example.contacts.model.Contact;
import com.example.contacts.model.repository.ContactRepository;
import com.example.contacts.model.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public void create(Contact contact) {
        if (contact == null) throw new IllegalArgumentException();

        contactRepository.save(contact);
    }

    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findById(Long id) {
        if (id == null) throw new IllegalArgumentException();

        return contactRepository.findById(id).orElseThrow();
    }

    @Override
    public void update(Long id, String phoneNumber) {
        if (id == null || phoneNumber == null) throw new IllegalArgumentException();

        Contact contactToUpdate = findById(id);
        contactToUpdate.setPhoneNumber(phoneNumber);
        contactRepository.save(contactToUpdate);
    }

    @Override
    public void delete(Long id) {
        if (id == null) throw new IllegalArgumentException();

        contactRepository.deleteById(id);
    }
}