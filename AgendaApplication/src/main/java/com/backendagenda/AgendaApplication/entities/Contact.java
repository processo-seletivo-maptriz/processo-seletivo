package com.backendagenda.AgendaApplication.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cep;
    private String email;
    private String phone;
    private String cnpj;
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public Contact() {
    }


    public Contact(Long id, String name, String cep, String email, String phone, String cnpj, String cpf) {
        this.id = id;
        this.name = name;
        this.cep = cep;
        this.email = email;
        this.phone = phone;
        this.cnpj = cnpj;
        this.cpf = cpf;
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

    public Schedule getSchedule() {
        return schedule;
    }

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

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}

