package com.br.helpcenter.dao;

import com.br.helpcenter.bean.ProdutoBean;
import com.br.helpcenter.jdbc.ConnectionFactory;
import com.br.helpcenter.util.GeraLog;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mauriciods
 */
public class ProdutoDAO {
    
    private GeraLog geraLog;
    
    public ProdutoDAO() {//cria novo instancia no construtor de objeto GeraLog
        geraLog = new GeraLog();
    }
    
    //persiste objeto de ProdutoBean na base de dados
    public int create(ProdutoBean pb) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement("INSERT INTO helpprodu(c_eanprodu,c_descprodu,n_precprodu,n_quanprodu) VALUES (?,?,?,?)");
            pst.setString(1, pb.getEan());
            pst.setString(2, pb.getDesc());
            pst.setBigDecimal(3, pb.getPreco());
            pst.setInt(4, pb.getQtd());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            //gera arquivo de log
            geraLog.LogTxt(ex.toString(), ProdutoDAO.class.getName());
        } finally {
            pst.close();
            con.close();
        }
           return 0; //retorna 0 caso execucao do metodo falhar
    }
    
    //retorna list de objetos de ProdutoBean
    public List<ProdutoBean> read() throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<ProdutoBean> produtos = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement("SELECT * FROM helpprodu");
            rs = pst.executeQuery();
            while(rs.next()) {
                ProdutoBean produto = new ProdutoBean();
                produto.setId(rs.getInt("n_idprodu"));
                produto.setEan(rs.getString("c_eanprodu"));
                produto.setDesc(rs.getString("c_descprodu"));
                produto.setPreco(new BigDecimal(rs.getString("n_precprodu")));
                produto.setQtd(rs.getInt("n_quanprodu"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            //gera arquivo de log
            geraLog.LogTxt(ex.toString(), ProdutoDAO.class.getName());
        } finally {
            pst.close();
            con.close();
        }
        return produtos;
    }
    
    //atualiza informacoes de produto
    public int update(ProdutoBean pb) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        int alterado = 0;
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement("UPDATE helpprodu SET c_eanprodu = ?,"
                                        + "c_descprodu = ?,"
                                        + "n_precprodu = ?,"
                                        + "n_quanprodu = ? "
                                        + "WHERE n_idprodu = ?");
            pst.setString(1, pb.getEan());
            pst.setString(2, pb.getDesc());
            pst.setBigDecimal(3, pb.getPreco());
            pst.setInt(4, pb.getQtd());
            pst.setInt(5, pb.getId());
            alterado = pst.executeUpdate();
        } catch (SQLException ex) {
            //gera arquivo de log
            geraLog.LogTxt(ex.toString(), ProdutoDAO.class.getName());
        } finally {
            pst.close();
            con.close();
        }
        return alterado;
    }
    
    //deleta produto referente ao id passado
    public int delete(int id) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        int removido = 0;
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement("DELETE FROM helpprodu WHERE n_idprodu = ?");
            pst.setInt(1, id);
            removido = pst.executeUpdate();
        } catch (SQLException ex) {
            //gera arquivo de log
            geraLog.LogTxt(ex.toString(), ProdutoDAO.class.getName());
        } finally {
            pst.close();
            con.close();
        }
        return removido;
    }
    
    //retorna objeto ProdutoBean referente ao EAN passado
    public ProdutoBean searchProduEAN(String param) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ProdutoBean produto = new ProdutoBean();
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement("SELECT * FROM helpprodu WHERE c_eanprodu = ?");
            pst.setString(1, param);
            rs = pst.executeQuery();
            if (!rs.isBeforeFirst()){//verificar o que isso faz
                produto.setDesc("vazio");
            }
            while (rs.next()) {
                    produto.setId(rs.getInt("n_idprodu"));
                    produto.setEan(rs.getString("c_eanprodu"));
                    produto.setDesc(rs.getString("c_descprodu"));
                    produto.setPreco(new BigDecimal(rs.getString("n_precprodu")));
                    produto.setQtd(rs.getInt("n_quanprodu"));
                }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            //gera arquivo de log
            geraLog.LogTxt(ex.toString(), ProdutoDAO.class.getName());
        } finally {
            pst.close();
            con.close();
        }
        return produto;
    }
}
