package com.backendagenda.AgendaApplication.dto;

import com.backendagenda.AgendaApplication.entities.User;

public class UserToScheduleDTO {

    private Long id;
    private String name;
    private String email;

    public UserToScheduleDTO() {
    }

    public UserToScheduleDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserToScheduleDTO(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
