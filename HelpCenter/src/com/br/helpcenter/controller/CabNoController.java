package com.br.helpcenter.controller;

import com.br.helpcenter.bean.CabNoBean;
import com.br.helpcenter.dao.CabNoDao;
import com.br.helpcenter.util.GeraLog;
import java.sql.SQLException;

/**
 *
 * @author mauriciods
 */
public class CabNoController {
    
    private static GeraLog geralog;
    
    public CabNoController() { //contrutor responsavel por criar objeto de log
        CabNoController.geralog = new GeraLog();
    }
    
    public static int create(CabNoBean cnb) {
        int idcabno = 0; //inicializa variavel de verificacao
        CabNoDao cnd = new CabNoDao(); //criar objeto responsavel pela persistencia
        try {
            idcabno = cnd.create(cnb); //persisti objeto na base de dados
        } catch (SQLException ex) {
            //gera arquivo de log
            geralog.LogTxt(ex.toString(), CabNoController.class.getName());
        }
        return idcabno; //retorna 0 caso execucao do metodo acima falhar
    }
}
