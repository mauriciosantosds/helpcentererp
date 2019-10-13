/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpcenter.bean;

/**
 *
 * @author mauriciods
 */
public class ClienteBean {
            
    private int id;
    private String nome;
    private String foneUm;
    private String foneDois;
    private String email;
    private String endereco;
    private String cpf;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoneUm() {
        return foneUm;
    }

    public void setFoneUm(String foneum) {
        this.foneUm = foneum;
    }

    public String getFoneDois() {
        return foneDois;
    }

    public void setFoneDois(String fonedois) {
        this.foneDois = fonedois;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public void setCPF(String cpf) {
        this.cpf = cpf;
    }
    
    public String getCPF() {
        return cpf;
    }
}
