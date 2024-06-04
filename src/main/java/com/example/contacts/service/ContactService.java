package com.example.contacts.service;

import com.example.contacts.model.Contact;

import java.util.List;

public interface ContactService {

    void create(Contact contact);
    List<Contact> getAll();
    Contact findById(Long id);
    void update(Long id);
    void delete(Long id);

}
