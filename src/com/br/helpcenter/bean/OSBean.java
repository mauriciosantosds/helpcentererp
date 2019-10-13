/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpcenter.bean;

import java.math.BigDecimal;

/**
 *
 * @author mauriciods
 */
public class OSBean {
    
    private int numero;
    private int tipo;
    private String situacao;
    private String equipamento;
    private String defeito;
    private String servico;
    private BigDecimal valor;
    private int idcliente;
    private int idcabnota;
    private String temntos;
    private String dataOS;
    private String clienome;
    private String tipoOSRet;
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdcabnota() {
        return idcabnota;
    }

    public void setIdcabnota(int idcabnota) {
        this.idcabnota = idcabnota;
    }

    public String getTemntos() {
        return temntos;
    }

    public void setTemntos(String temntos) {
        this.temntos = temntos;
    }

    public String getDataOS() {
        return dataOS;
    }

    public void setDataOS(String dataOS) {
        this.dataOS = dataOS;
    }

    public String getClienome() {
        return clienome;
    }

    public void setClienome(String clienome) {
        this.clienome = clienome;
    }

    public String getTipoOSRet() {
        return tipoOSRet;
    }

    public void setTipoOSRet(String tipoOSRet) {
        this.tipoOSRet = tipoOSRet;
    }
    
    
    
}
