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
public class ItemNotaBean {
    
    private int idItNo;
    private int qtd;
    private BigDecimal preco;
    private int idCabNo;
    private int idprodu;

    public int getIdItNo() {
        return idItNo;
    }

    public void setIdItNo(int idItNo) {
        this.idItNo = idItNo;
    }
    
    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getIdCabNo() {
        return idCabNo;
    }

    public void setIdCabNo(int idCabNo) {
        this.idCabNo = idCabNo;
    }

    public int getIdprodu() {
        return idprodu;
    }

    public void setIdprodu(int idprodu) {
        this.idprodu = idprodu;
    }
    
    
}
