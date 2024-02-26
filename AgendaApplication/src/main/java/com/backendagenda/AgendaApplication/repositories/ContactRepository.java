package com.backendagenda.AgendaApplication.repositories;

import com.backendagenda.AgendaApplication.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
