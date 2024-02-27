package com.backendagenda.AgendaApplication.services;

import com.backendagenda.AgendaApplication.dto.ContactDTO;
import com.backendagenda.AgendaApplication.dto.UserDTO;
import com.backendagenda.AgendaApplication.entities.Contact;
import com.backendagenda.AgendaApplication.entities.User;
import com.backendagenda.AgendaApplication.repositories.ContactRepository;
import com.backendagenda.AgendaApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Page<ContactDTO> getAllUsers(Pageable pageable) {
        Page<Contact> contact = contactRepository.findAll(pageable);
        return  contact.map(ContactDTO::new);
    }
}
