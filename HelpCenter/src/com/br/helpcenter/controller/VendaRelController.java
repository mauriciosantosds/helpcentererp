package com.br.helpcenter.controller;

import com.br.helpcenter.bean.CabNoBean;
import com.br.helpcenter.dao.VendaRelDAO;
import com.br.helpcenter.util.GeraLog;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author mauriciods
 */
public class VendaRelController {
    
    private static GeraLog geralog;
    
    //cria nova isntancia de gera log no construtor
    public VendaRelController() {
        geralog = new GeraLog();
    }
    
    //retorna lista de notas de acordo com parametro passado
    public static List<CabNoBean> read(int modoTela) {
            VendaRelDAO vrd = new VendaRelDAO(); //cria objeto responsavel pela consulta
            //se receber parametro valor 1 retorna lista de vendas
            //se receber parametro valor 2 retorna lista de os
        if (modoTela == 1) {
            try {
                return vrd.readVenda(); //retorna notas de vendas
            } catch (SQLException ex) {
                //gera arquivo de log
                geralog.LogTxt(ex.toString(), VendaRelController.class.getName());
            }
        } else {
                try {
                    return vrd.readOS();
                } catch (SQLException ex) {
                    //gera arquivo de log
                    geralog.LogTxt(ex.toString(), VendaRelController.class.getName());
                }
        }
        return null; //retorna null caso execucao do metodo acima falhar
    }
    
    //retorna lista de notas de acordo com periodo selecionado e parametro passado
    public static List<CabNoBean> read(String dtIni, String dtFin, int modoTela) {
            VendaRelDAO vrd = new VendaRelDAO(); //cria objeto responsavel pela consulta
        if (modoTela == 1) {//se receber 1 retorna lista de vendas
            try {
                return vrd.readVenda(dtIni, dtFin); //retorna lista de vendas
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        } else { //se receber 2 retorna lista de os
                try {
                    return vrd.readOS(dtIni, dtFin); //retorna lista de os
                } catch (SQLException ex) {
                    //gera arquivo de log
                    geralog.LogTxt(ex.toString(), VendaRelController.class.getName());
                }
        }    
        return null; //retorna null caso execucao do metodo acima falhar
    }
}
