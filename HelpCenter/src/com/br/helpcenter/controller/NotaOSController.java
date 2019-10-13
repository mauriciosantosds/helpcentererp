package com.br.helpcenter.controller;

import com.br.helpcenter.bean.CabNoBean;
import com.br.helpcenter.bean.NotaOSBean;
import com.br.helpcenter.dao.NotaOSDAO;
import com.br.helpcenter.util.GeraLog;
import java.sql.SQLException;

/**
 *
 * @author mauriciods
 */
public class NotaOSController {
    
    private static GeraLog geralog;
    
    public NotaOSController() {//cria objeto no construtor da classe
        NotaOSController.geralog = new GeraLog();
    }
      
    //metodo responsavel por persistir OSs e cabecalho da nota
    public static int create(CabNoBean cnb) {
        NotaOSDAO nod = new NotaOSDAO(); //cria objeto responsavel por persistir dados
        int inserido = 0;
       
            try {
                inserido = nod.create(cnb); //persisti objeto bean Cabecalho Nota na base de dados
            } catch (SQLException ex) {
                //gera log
                geralog.LogTxt(ex.toString(), NotaOSController.class.getName());
            }
        
        return inserido; //retorna numero maior que 0 se inserido
    }
    
    public static NotaOSBean read(int id) { //retorna nota de acordo com id de cabecalho
        NotaOSDAO notaOSDAO = new NotaOSDAO(); //cria objeto responsavel por fazer a leitura dos dados
        try {
            return notaOSDAO.readCabNo(id); //retorna nota se id existir no banco
        } catch (SQLException ex) {
            //gera log
            geralog.LogTxt(ex.toString(), NotaOSController.class.getName());
        }
        return null; //retorna nulo case execucao do metodo falhar
    }
}
