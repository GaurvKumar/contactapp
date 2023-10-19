package com.assignment.contactapp.service;

import com.assignment.contactapp.entity.Contact;
import com.assignment.contactapp.exception.ContactNotFoundException;
import com.assignment.contactapp.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getAllContacts() {
        return (List<Contact>) contactRepository.findAll();
    }

    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact updateContact(Long id, Contact updatedContact) {
        Optional<Contact> existingContact = contactRepository.findById(id);
        if (existingContact.isPresent()) {
            updatedContact.setId(existingContact.get().getId());
            return contactRepository.save(updatedContact);
        } else {
            throw new ContactNotFoundException("Contact not found with id: " + id);
        }
    }

    public void deleteContact(Long id) {
        Optional<Contact> existingContact = contactRepository.findById(id);
        if (existingContact.isPresent()) {
            contactRepository.delete(existingContact.get());
        } else {
            throw new ContactNotFoundException("Contact not found with id: " + id);
        }
    }
}
