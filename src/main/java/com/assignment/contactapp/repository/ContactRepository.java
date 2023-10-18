package com.assignment.contactapp.repository;

import com.assignment.contactapp.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository  extends JpaRepository<Contact, Long> {
}
