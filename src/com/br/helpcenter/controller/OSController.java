package com.br.helpcenter.controller;

import com.br.helpcenter.bean.OSBean;
import com.br.helpcenter.dao.OSDAO;
import com.br.helpcenter.util.GeraLog;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauriciods
 */
public class OSController {
    
    private static GeraLog geralog;
    
    public OSController() {//cria objeto no construtor responsavel por gerar log
        OSController.geralog = new GeraLog();
    }
    
    public static int create(OSBean ob) { //metodo responsavel por persistir Bean de OS
        OSDAO osd = new OSDAO(); //cria objeto responsavel pela persistencia
        int numos = 0; //inicializa variavel de retorno
        try {
            numos = osd.create(ob); // retorna numero maior que 0 se inserido
        } catch (SQLException ex) {
            //gera log
            geralog.LogTxt(ex.toString(), OSController.class.getName());
        }
        return numos; //retorna 0 caso execucao do metodo acima falhar
    }
    
    public static int update(OSBean ob) {//atualiza dados de uma OS
        OSDAO osd = new OSDAO(); //cria objeto responsavel por atualizar informacoes na base de dados
        int alterado = 0; //inicializa variavel de retorno
        try {
            alterado = osd.update(ob); //se alterado retorna valor maior que 0
        } catch (SQLException ex) {
            //gera log
            geralog.LogTxt(ex.toString(), OSController.class.getName());
        }
        return alterado; //retorna 0 se execucao do metodo acima falhar
    }
}
