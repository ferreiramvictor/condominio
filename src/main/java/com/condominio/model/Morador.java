package com.condominio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Morador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String login; // Ex: "103A" (apartamento + bloco)
    private String senha; // Ex: "Tex@s2025"
    private String apartamento; // Ex: "103"
    private String bloco; // Ex: "A"
    private String contato; // Note o nome do campo (contato)

    // Construtor vazio (obrigatório para JPA)
    public Morador() {
    }

    // Construtor completo
    public Morador(String nome, String login, String senha, String apartamento, String bloco, String contato) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.apartamento = apartamento;
        this.bloco = bloco;
        this.contato = contato;
    }

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getApartamento() {
        return apartamento;
    }

    public String getBloco() {
        return bloco;
    }

    public String getContato() { // Getter correto (nome do método)
        return contato; // Retorna o campo 'contato'
    }

    // ===== SETTERS ===== (todos corrigidos)
    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}