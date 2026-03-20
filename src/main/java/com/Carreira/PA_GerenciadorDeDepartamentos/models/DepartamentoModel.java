package com.Carreira.PA_GerenciadorDeDepartamentos.models;


import jakarta.persistence.*;

@Entity
@Table(name = "TBL_Departamento")
public class DepartamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nome Departamento")
    private String nome;
    @Column(name = "Localizacao Departamento")
    private String localização;

    public DepartamentoModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalização() {
        return localização;
    }

    public void setLocalização(String localização) {
        this.localização = localização;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
