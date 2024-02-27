package com.backendagenda.AgendaApplication.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cnpj;
    private String cpf;
    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public Company() {
        super();
    }

    public Company(Long id, String name, String cnpj, Contact contact) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.contact = contact;
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

    public String getCnpj() {
        return cnpj;
    }

    public Contact getContact() {
        return contact;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
