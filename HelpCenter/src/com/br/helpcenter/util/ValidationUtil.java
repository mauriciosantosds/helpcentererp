/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpcenter.util;

import java.math.BigDecimal;

/**
 *
 * @author mauriciods
 */
public class ValidationUtil {
    
    public String validaPreco(String precoVirgula) {
        String precoSemVirgula; 
        precoSemVirgula = precoVirgula.replace(",", ".");
        return precoSemVirgula;
    }
    
    public String formata(String c, boolean mascara) {
        if (mascara) {
            return(c.substring(0, 3) + "." + c.substring(3, 6) + "." +
                    c.substring(6, 9) + "-" + c.substring(9, 11));
        }  else {
            return c;
        }
    }
    
    public String formatMoney(String c) {
            String cSemVirgula = c.replace(",", "");
        if (cSemVirgula.length() == 2) {
            String valor = cSemVirgula.substring(0, 0) + "," + cSemVirgula.substring(0, 2);
            return valor;
        } else if (cSemVirgula.length() > 2) {
            int i = cSemVirgula.length() -2;
            String valor = cSemVirgula.substring(0, i) + "," + cSemVirgula.substring(i,cSemVirgula.length());
            return valor;
        } 
        return null;
    }
    
    public String pontoPorVirgula(BigDecimal preco) {
        String precoVirgula = String.valueOf(preco);
        precoVirgula = precoVirgula.replace(".", ",");
        return precoVirgula;
    }
    
    public String removeMaskTel(String tel) {
        if (tel != null && tel != "") {
            tel = tel.replace("(", "");
            tel = tel.replace(")", "");
            tel = tel.replace("-", "");
            tel = tel.replace(" ", "");
            return tel;
        }
        return null;
    }
    
    public String removeMaskCPF(String cpf) {
        if (cpf != null && cpf != "") {
            cpf = cpf.replace(".", "");
            cpf = cpf.replace("-", "");
            cpf = cpf.replace("           ","");
            return cpf;
        }
        return null;
    }
    
    public String aplicaMaskCel(String cel) {
        if (cel != null && cel != "" && cel.length() == 11) {
        return cel.substring(0, 0) + "(" + cel.substring(0, 2) + ")" 
                + cel.substring(2, 2) + " " + cel.substring(2, 7) + "-"
                + cel.substring(7, 11);
        }
        return cel;
    }
    
    public String aplicaMaskTel(String tel) {
        if (tel != null && tel != "" && tel.length() == 10) {
        return tel.substring(0, 0) + "(" + tel.substring(0, 2) + ")" 
                + tel.substring(2, 2) + " " + tel.substring(2, 6) + "-"
                + tel.substring(6, 10);
        }
        return tel;
    }
}
