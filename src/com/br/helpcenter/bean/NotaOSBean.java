/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpcenter.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mauriciods
 */
public class NotaOSBean {
    private int id;
    private int quantidade;
    private String nomeCli;
    private BigDecimal total;
    private String dthcabno;
    private List<OSBean> oSs = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNomeCli() {
        return nomeCli;
    }

    public void setNomeCli(String nomeCli) {
        this.nomeCli = nomeCli;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getDthcabno() {
        return dthcabno;
    }

    public void setDthcabno(String dthcabno) {
        this.dthcabno = dthcabno;
    }

    public List<OSBean> getoSs() {
        return oSs;
    }

    public void setoSs(List<OSBean> oSs) {
        this.oSs = oSs;
    }
    
}
