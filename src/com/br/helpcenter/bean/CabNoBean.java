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
public class CabNoBean {
    private int id;
    private int quantidade;
    private int idCliente;
    private String clienNome;
    private BigDecimal totalCabNota;
    private String eOSCabNota;
    private String dthcabno;
    private List<ProdutoBean> itens = new ArrayList<>();
    private List<OSBean> osS = new ArrayList<>();
    
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getClienNome() {
        return clienNome;
    }

    public void setClienNome(String clienNome) {
        this.clienNome = clienNome;
    }

    public BigDecimal getTotalCabNota() {
        return totalCabNota;
    }

    public void setTotalCabNota(BigDecimal totalCabNota) {
        this.totalCabNota = totalCabNota;
    }

    public String geteOSCabNota() {
        return eOSCabNota;
    }

    public void seteOSCabNota(String eOSCabNota) {
        this.eOSCabNota = eOSCabNota;
    }

    public String getDthcabno() {
        return dthcabno;
    }

    public void setDthcabno(String dthcabno) {
        this.dthcabno = dthcabno;
    }

    public List<ProdutoBean> getItens() {
        return itens;
    }

    public void setItens(List<ProdutoBean> itens) {
        this.itens = itens;
    }
    
    public List<OSBean> getOsS() {
        return osS;
    }
    
    public void setOsS(List<OSBean> osS) {
        this.osS = osS;
    }
    
}
