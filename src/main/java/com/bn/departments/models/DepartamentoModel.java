package com.bn.departments.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_departamento")
public class DepartamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "DepartamentoNome")
    String nome;
    @Column(name = "DepartamentoLocalizacao")
    String localizacao;

    public DepartamentoModel() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
