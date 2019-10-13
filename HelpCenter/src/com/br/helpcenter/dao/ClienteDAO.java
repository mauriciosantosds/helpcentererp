package com.br.helpcenter.dao;

import com.br.helpcenter.jdbc.ConnectionFactory;
import com.br.helpcenter.bean.ClienteBean;
import com.br.helpcenter.util.GeraLog;
import com.br.helpcenter.util.ValidationUtil;
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
public class ClienteDAO {
    
    private GeraLog geraLog;

    public ClienteDAO() {//cria nova instancia de objeto GeraLog no construtor
        geraLog = new GeraLog();
    }
    
    //persiste objeto de ClienteBean na base de dados
    public int create(ClienteBean c) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        int inserido = 0;
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement("INSERT INTO helpclien(c_nomeclien,c_fpriclien,c_fsegclien,c_emaiclien,c_endeclien,c_cpfclien) VALUES (?,?,?,?,?,?)");
            pst.setString(1, c.getNome());
            pst.setString(2, c.getFoneUm());
            pst.setString(3, c.getFoneDois());
            pst.setString(4, c.getEmail());
            pst.setString(5, c.getEndereco());
            pst.setString(6, c.getCPF());
            inserido = pst.executeUpdate();
        } catch (SQLException ex) {
            //gera arquivo de log
            geraLog.LogTxt(ex.toString(), ClienteDAO.class.getName());
        } finally {
            pst.close();
            con.close();
        }
        return inserido;
    }
    
    //retorna list de objetos ClienteBean e ordena por nome do cliente
    public List<ClienteBean> read() throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<ClienteBean> clientes = new ArrayList<>();   
            ValidationUtil vu = new ValidationUtil();
            try {
                con = ConnectionFactory.getConnection();
                pst = con.prepareStatement("SELECT * FROM helpclien ORDER BY c_nomeclien");
                rs = pst.executeQuery();
                while(rs.next()) {
                    ClienteBean cliente = new ClienteBean();
                    cliente.setId(rs.getInt("n_idclien"));
                    cliente.setNome(rs.getString("c_nomeclien"));
                    cliente.setFoneUm(rs.getString("c_fpriclien"));
                    cliente.setFoneDois(rs.getString("c_fsegclien"));
                    cliente.setEmail(rs.getString("c_emaiclien"));
                    cliente.setEndereco(rs.getString("c_endeclien"));
                    cliente.setCPF(rs.getString("c_cpfclien"));
                    clientes.add(cliente);
                }
            } catch (SQLException ex) {
                //gera arquivo de log
                geraLog.LogTxt(ex.toString(), ClienteDAO.class.getName());
            } finally {
                pst.close();
                con.close();
            }
        return clientes;
    }
    
    //atualiza informacoes de cliente
    public int update(ClienteBean cb) throws SQLException{
        Connection con = null;
        PreparedStatement pst = null;
        int atualizado = 0;
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement("UPDATE helpclien SET c_nomeclien = ?,"
                                        + "c_fpriclien = ?,"
                                        + "c_fsegclien = ?,"
                                        + "c_emaiclien = ?,"
                                        + "c_endeclien = ?"
                                        + "WHERE n_idclien = ?");
            pst.setString(1, cb.getNome());
            pst.setString(2, cb.getFoneUm());
            pst.setString(3, cb.getFoneDois());
            pst.setString(4, cb.getEmail());
            pst.setString(5, cb.getEndereco());
            pst.setInt(6, cb.getId());
            atualizado = pst.executeUpdate();
        } catch (SQLException ex) {
            //gera arquivo de log
            geraLog.LogTxt(ex.toString(), ClienteDAO.class.getName());
        } finally {
            pst.close();
            con.close();
        }
        return atualizado;
    }
    
    //deleta cliente referente ao id passado por parametro
    public int delete(int id) throws SQLException{
        Connection con = null;
        PreparedStatement pst = null;
        int removido = 0;
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement("DELETE FROM helpclien WHERE n_idclien = ?");
            pst.setInt(1, id);
            removido = pst.executeUpdate();
        } catch (SQLException ex) {
            //gera arquivo de log
            if(ex.getErrorCode() == 1451) {
                JOptionPane.showMessageDialog(null, "Cliente possui registros em outros módulos!", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else {
                geraLog.LogTxt(ex.toString(), ClienteDAO.class.getName());
            }
        } finally {
            pst.close();
            con.close();
        }
        return removido;
    }
}
