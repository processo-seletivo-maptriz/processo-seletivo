package com.backendagenda.AgendaApplication.dto;

import com.backendagenda.AgendaApplication.entities.Contact;
import com.backendagenda.AgendaApplication.entities.Schedule;
import com.backendagenda.AgendaApplication.entities.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleMinDTO {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime expirationDate;
    private LocalDateTime updatedAt;

    private List<UserToScheduleDTO> users = new ArrayList<UserToScheduleDTO>();
    private List<ContactDTO> contacts = new ArrayList<ContactDTO>();
    // Construtor

    public ScheduleMinDTO(Schedule entity) {
        this.id = entity.getId();
        this.createdAt = entity.getCreatedAt();
        this.expirationDate = entity.getExpirationDate().atStartOfDay();
        this.updatedAt = entity.getUpdatedAt();
        for (User user: entity.getUsers()){
            users.add(new UserToScheduleDTO(user));
        }
        for (Contact contact: entity.getContacts()){
            contacts .add(new ContactDTO(contact));
        }
    }

    public ScheduleMinDTO(Long id, LocalDateTime createdAt, LocalDateTime expirationDate, LocalDateTime updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.expirationDate = expirationDate;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<UserToScheduleDTO> getUsers() {
        return users;
    }

    public List<ContactDTO> getContacts() {
        return contacts;
    }
}
