/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpcenter.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauriciods
 */
public class ManipulaDataHora {
    public String getDataHoraBR() {
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sd.format(data);
    }
    
    public String getDataHoraUS(String dataBR) {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date stringParaDate = null;
        try {
            stringParaDate = sd.parse(dataBR);
        }
        catch (Exception ex) {
                System.err.println(ex);
                }
        sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataUS = sd.format(stringParaDate);
            return dataUS;
    }
    
    public String getDataUS(String dataBR) {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        Date stringParaDate = null;
        try {
            stringParaDate = sd.parse(dataBR);
        }
        catch (Exception ex) {
                System.err.println(ex);
                }
        sd = new SimpleDateFormat("yyyy-MM-dd");
        String dataUS = sd.format(stringParaDate);
            return dataUS;
    }
    
    public String getDataHoraBR(String dataUS) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date stringParaDate = null;
        try {
            stringParaDate = sd.parse(dataUS);
        }
        catch (Exception ex) {
                System.err.println(ex);
                }
        sd = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataBR = sd.format(stringParaDate);
            return dataBR;
    }
    
    public String getMesAtual() {
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        SimpleDateFormat sd = new SimpleDateFormat("MMMM");
        return sd.format(data);
    }
}
