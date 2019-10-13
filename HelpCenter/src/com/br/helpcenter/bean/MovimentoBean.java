/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpcenter.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author mauriciods
 */
public class MovimentoBean {
    int idmovim;
    String categoria;
    String descricao;
    BigDecimal valor;
    Date datah;
    String tipo;
    int idcabno;
    int idnumeos;
    String ntosmovim;

    public int getIdmovim() {
        return idmovim;
    }

    public void setIdmovim(int idmovim) {
        this.idmovim = idmovim;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDatah() {
        return datah;
    }

    public void setDatah(Date datah) {
        this.datah = datah;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdcabno() {
        return idcabno;
    }

    public void setIdcabno(int idcabno) {
        this.idcabno = idcabno;
    }

    public int getIdnumeos() {
        return idnumeos;
    }

    public void setIdnumeos(int idnumeos) {
        this.idnumeos = idnumeos;
    }

    public String getNtosmovim() {
        return ntosmovim;
    }

    public void setNtosmovim(String ntosmovim) {
        this.ntosmovim = ntosmovim;
    }
    
    
}
