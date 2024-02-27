package com.backendagenda.AgendaApplication.repositories;

import com.backendagenda.AgendaApplication.entities.Contact;
import com.backendagenda.AgendaApplication.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact,Long> {
    List<Contact> findByScheduleId(Long scheduleId);
}
