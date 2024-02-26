package com.backendagenda.AgendaApplication.dto;

import com.backendagenda.AgendaApplication.entities.Contact;
import com.backendagenda.AgendaApplication.entities.Schedule;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ContactDTO {
    private Long id;
    private String name;
    private String cep;
    private String email;
    private String phone;
    @Column(unique = true)
    private String cnpj;
    @Column(unique = true)
    private String cpf;
    private Long scheduleId;

//    private Schedule schedule;

    public ContactDTO() {
    }

    public ContactDTO(Contact entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.cep = entity.getCep();
        this.email = entity.getEmail();
        this.phone = entity.getPhone();

        this.cnpj = entity.getCnpj();
        this.cpf = entity.getCpf();
        this.scheduleId = entity.getSchedule() != null ? entity.getSchedule().getId() : null;
    }
    public ContactDTO(String name, String cep, String email, String phone, String cnpj, String cpf) {
        this.name = name;
        this.cep = cep;
        this.email = email;
        this.phone = phone;
        this.cnpj = cnpj;
        this.cpf = cpf;
    }
    public ContactDTO(Long id, String name, String cep, String email, String phone, String cnpj, String cpf) {
        this.id = id;
        this.name = name;
        this.cep = cep;
        this.email = email;
        this.phone = phone;
        this.cnpj = cnpj;
        this.cpf = cpf;
        validateContact();
    }



    private void validateContact() {
        if (cpf != null && cnpj != null) {
            throw new IllegalArgumentException("Um contato não pode ter tanto CPF quanto CNPJ.");
        }
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public Schedule getSchedule() {
//        return schedule;
//    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }
}
