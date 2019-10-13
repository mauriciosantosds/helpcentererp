package com.br.helpcenter.controller;

import com.br.helpcenter.bean.ProdutoBean;
import com.br.helpcenter.dao.ProdutoDAO;
import com.br.helpcenter.model.ProdutoTableModel;
import com.br.helpcenter.util.GeraLog;
import java.sql.SQLException;


/**
 *
 * @author mauriciods
 */
public class ProdutoController {
    
    private static GeraLog geralog;
    
    //cria nova instancia de geralog no construtor
    public ProdutoController() {
        geralog = new GeraLog();
    }
    
    //persiste objeto produtobean na base de dados
    public static int create(ProdutoBean pb) {
        ProdutoDAO pd1 = new ProdutoDAO(); //cria objeto responsavel pela persistencia
        int inserido = 0; //inicializa variavel
        try {
            inserido = pd1.create(pb); //se inserido retorna numero maior que 0
        } catch (SQLException ex) {
            //gera arquivo de log
            geralog.LogTxt(ex.toString(), ProdutoController.class.getName());
        }
        return inserido; //retorna zero caso a execucao do metodo acima falhar
    }
    
    //metodo responsavel pela leitura dos produtos cadastrados na base de dados
    public static ProdutoTableModel read() {
        ProdutoTableModel produtoTableModel = new ProdutoTableModel(); //cria table model de produtos
        ProdutoDAO pd1 = new ProdutoDAO(); //cria objeto responsavel pela consulta dos produtos na base de dados
        try {
            produtoTableModel.addListaDeProdutos(pd1.read()); //faz a leitura e adicona list de produtos no table model
        } catch (SQLException ex) {
            //gera arquivo de log
            geralog.LogTxt(ex.toString(), ProdutoController.class.getName());
        }
        
        return produtoTableModel; //retorna produto table model cheio caso execucao do metodo acima retornar produtos
    }
    
    //metodo responsavel por atualizar informacoes de um produto
    public static int update(ProdutoBean pb) {
        ProdutoDAO pd1 = new ProdutoDAO(); //cria objeto responsavel pela atualizacao das informacoes
        int alterado = 0; //inicializa variavel de retorno
        try {
            alterado = pd1.update(pb); //retorna numero maior que 0 se atualizado
        } catch (SQLException ex) {
            //gera arquivo de log
            geralog.LogTxt(ex.toString(), ProdutoController.class.getName());
        }
        return alterado; //retorna 0 caso execucao do metodo acima falhar
    }
    
    //metodo responsavel por deletar produto referente ao id passado
    public static int delete(int id) {
        int removido = 0; //inicializa variavel de retorno
        ProdutoDAO pd1 = new ProdutoDAO(); //cria objeto responsavel por deletar produto
        try {
            removido = pd1.delete(id); //retorna valor maior que 0 se deletado
        } catch (SQLException ex) {
            //gera arquivo de log
            geralog.LogTxt(ex.toString(), ProdutoController.class.getName());
        }
        return removido; //retorna 0 caso execucao do metodo acima falhar
    }
    
    //metodo responsavel por pesquisar produto de acordo com seu EAN
    public static ProdutoBean searchProduEAN(String param) {
        ProdutoDAO pd1 = new ProdutoDAO(); //cria objeto responsavel pelo acesso aos produtos
        ProdutoBean pb = new ProdutoBean(); //cria objeto bean de produto
        try {
            pb = pd1.searchProduEAN(param); //efetua pesquisa e retorna bean de produto preenchido caso encontrar
        } catch (SQLException ex) {
            //gera arquivo de log
            geralog.LogTxt(ex.toString(), ProdutoController.class.getName());
        }
        
        return pb; //retorna produto bean vazio se execucao do metodo acima falhar
    }
}
