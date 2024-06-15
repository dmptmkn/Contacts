package com.example.contacts.model.service.impl;

import com.example.contacts.model.Contact;
import com.example.contacts.model.repository.ContactRepository;
import com.example.contacts.model.service.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public void create(Contact contact) {
        if (contact == null) throw new IllegalArgumentException();

        try {
            contactRepository.save(contact);
            log.info("New contact created: " + contact);
        } catch (Exception e) {
            log.error("Error while creating new contact: " + e.getMessage());
        }
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

        try {
            Contact contactToUpdate = findById(id);
            contactToUpdate.setPhoneNumber(phoneNumber);
            contactRepository.save(contactToUpdate);
            log.info("Contact updated: " + contactToUpdate);
        } catch (Exception e) {
            log.error("Error while updating a contact: " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        if (id == null) throw new IllegalArgumentException();

        try {
            contactRepository.deleteById(id);
            log.info("Contact with id " + id + "have been deleted");
        } catch (Exception e) {
            log.error("Error while deleting a contact: " + e.getMessage());
        }
    }
}