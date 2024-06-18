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
        if (contact == null) {
            log.debug("Contact cannot be NULL");
            throw new NullPointerException();
        }

        contactRepository.save(contact);
        log.info("New contact created: {}", contact);
    }

    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findById(Long id) {
        if (id == null) {
            log.debug("Id cannot be NULL");
            throw new NullPointerException();
        }

        return contactRepository.findById(id).orElseThrow();
    }

    @Override
    public void update(Long id, String phoneNumber) {
        if (id == null || phoneNumber == null) {
            log.debug("Id or phone number cannot be NULL");
            throw new NullPointerException();
        }

        Contact contactToUpdate = findById(id);
        contactToUpdate.setPhoneNumber(phoneNumber);
        contactRepository.save(contactToUpdate);
        log.info("Contact updated: {}", contactToUpdate);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.debug("Id cannot be NULL");
            throw new NullPointerException();
        }

        contactRepository.deleteById(id);
        log.info("Contact with id {} have been deleted", id);
    }
}