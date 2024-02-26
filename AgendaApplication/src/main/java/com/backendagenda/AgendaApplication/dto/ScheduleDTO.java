package com.backendagenda.AgendaApplication.dto;

import com.backendagenda.AgendaApplication.entities.Contact;
import com.backendagenda.AgendaApplication.entities.Schedule;
import com.backendagenda.AgendaApplication.entities.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDTO {

    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime expirationDate;
    private LocalDateTime updatedAt;

    private List<UserToScheduleDTO> users = new ArrayList<UserToScheduleDTO>();
    private List<ContactDTO> contacts = new ArrayList<ContactDTO>();
    // Construtor

    public ScheduleDTO(Schedule entity) {
        this.id = entity.getId();
        this.name = entity.getName();
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

    public ScheduleDTO(Long id, String name, LocalDateTime createdAt, LocalDateTime expirationDate, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
