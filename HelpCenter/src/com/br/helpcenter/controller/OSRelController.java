package com.br.helpcenter.controller;

import com.br.helpcenter.bean.OSBean;
import com.br.helpcenter.dao.OSRelDAO;
import com.br.helpcenter.model.OSRelTableModel;
import com.br.helpcenter.util.GeraLog;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author mauriciods
 */
public class OSRelController {
    
    private static List<OSBean> listaOSs;
    
    private static GeraLog geralog;
    
    public OSRelController() { //cria objeto no construtor responsavel por gerar log
        geralog = new GeraLog();
    }
    
    public static List<OSBean> read() {//metodo responsavel por retornar list de OSBean
        OSRelDAO ord = new OSRelDAO(); //criar objeto responsavel por retornar valores na base de dados
        try {
            listaOSs = ord.read(); //adiciona lista de objetos OSBean
            return ord.read(); //retorna lista de objetos OSBean
        } catch (SQLException ex) {
            //gera log
            geralog.LogTxt(ex.toString(), OSRelController.class.getName());
        }
        return null; //retorna null caso execucao do metodo falhar
    }
    //retorna os de acordo com periodo selecionado e se tem ou nao nota
    public static List<OSBean> read(String dtIni, String dtFin, String notaOS) { 
        OSRelDAO ord = new OSRelDAO();
        try {
            listaOSs = ord.read(dtIni, dtFin, notaOS);
            return ord.read(dtIni, dtFin, notaOS);
        } catch (SQLException ex) {
            //gera log
            geralog.LogTxt(ex.toString(), OSRelController.class.getName());
        }
        return null; //retorna null caso execucao do metodo falhar
    }
    
    public static List<OSBean> getListaOSs() { //retorna lista de OSs
        return listaOSs;
    }
}
