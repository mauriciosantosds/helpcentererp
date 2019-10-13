package com.br.helpcenter.controller;

import com.br.helpcenter.bean.ClienteBean;
import com.br.helpcenter.dao.ClienteDAO;
import com.br.helpcenter.model.ClienteTableModel;
import com.br.helpcenter.util.GeraLog;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author mauriciods
 */
public class ClienteController {
    
    private static GeraLog geralog;
    
    public ClienteController() { //metodo responsavel por gerar log
        this.geralog = new GeraLog();
    }
    
    private static ClienteTableModel clienTableModel = new ClienteTableModel();
    
    // persiste objeto bean de cliente na base de dados
    // e retorna numero maior que 0 se inserido
    public static int create(ClienteBean cb) {
        ClienteDAO cd1 = new ClienteDAO(); //cria objeto responsavel pela persistencia
        int inserido = 0;
        try {
            inserido = cd1.create(cb); //persiste objeto na base de dados
        } catch (SQLException ex) {
            //gera arquivo de log
            geralog.LogTxt(ex.toString(), ClienteController.class.getName());
        }
        return inserido;
    }
    //retorna table model com clientes inseridos na base de dados
    public static ClienteTableModel read() {
            ClienteDAO cd1 = new ClienteDAO(); //cria objeto responsavel pela leitura
            try {
                clienTableModel.addListaDeClientes(cd1.read()); //adiciona List de clientes no table model
            } catch (SQLException ex) {
                //gera arquivo de log
                geralog.LogTxt(ex.toString(), ClienteController.class.getName());
            }
        return clienTableModel;
    }
    
    //retorna List com todos os clientes ao receber o parametro Todos
    public static List<ClienteBean> read(String nome) {
        ClienteDAO cd1 = new ClienteDAO(); //cria objeto responsavel pela leitura
        try {
             return cd1.read();
        } catch (SQLException ex) {
            //gera log
            geralog.LogTxt(ex.toString(), ClienteController.class.getName());
        }
        return null;
    }
    
    //atualiza informacoes de cliente
    public static int update(ClienteBean cb) {
        ClienteDAO cd1 = new ClienteDAO(); //cria objeto responsavel por atualizar
        int atualizado = 0;
        try {
            atualizado = cd1.update(cb); // atualiza cliente e retorna valor maior que 0 se atualizado
        } catch (SQLException ex) {
            //gera log
            geralog.LogTxt(ex.toString(), ClienteController.class.getName());
        }
        return atualizado;
    }
    
    //deleta cliente correspondente ao id recebido
    //e retorna numero maior que 0 se removido
    public static int delete(int id) {
        ClienteDAO cd1 = new ClienteDAO(); //cria objeto responsvel por deletar cliente
        int removido = 0;
        try {
            removido = cd1.delete(id); //deleta e retorna valor maior que 0 se deletado
        } catch (SQLException ex) {
            //gera log
            geralog.LogTxt(ex.toString(), ClienteController.class.getName());
        }
        return removido;
    }
}
