package com.br.helpcenter.dao;

import com.br.helpcenter.bean.OSBean;
import com.br.helpcenter.jdbc.ConnectionFactory;
import com.br.helpcenter.util.GeraLog;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mauriciods
 */
public class OSDAO {
    
    private GeraLog geraLog;
    
    public OSDAO() { //cria nova instancia no construtor de objeto GeraLog
        geraLog = new GeraLog();
    }
    
    //persisti objeto de OSBean na base de dados
    public int create (OSBean ob) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int numos = 0;
        
        try {
            con = ConnectionFactory.getConnection();
            String sql = "INSERT INTO helpos(d_dathos,c_tipoos,"
            + "c_situos,c_equios,c_defeos,c_servos,n_valoros,n_idclien,"
            + "c_temntos) VALUES((select now()),?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //verificar o que isso faz
            pst.setInt(1, ob.getTipo());
            pst.setString(2, ob.getSituacao());
            pst.setString(3, ob.getEquipamento());
            pst.setString(4, ob.getDefeito());
            pst.setString(5, ob.getServico());
            pst.setBigDecimal(6, ob.getValor());
            pst.setInt(7, ob.getIdcliente());
            pst.setString(8, ob.getTemntos());
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            while (rs.next()) {
                numos = rs.getInt(1);
            }
        } catch (SQLException ex) {
            //gera arquivo de log
            geraLog.LogTxt(ex.toString(), OSDAO.class.getName());
        } finally {
            pst.close();
            con.close();
        }
        return numos; //retorna numero maior que 0 se inserido
    }
    
    //atualiza objeto de osbean na base de dados
    public int update(OSBean ob) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        int alterado = 0;
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement("UPDATE helpos SET" +
                " c_tipoos = ?," +
                "c_situos = ?," +
                "c_equios = ?," +
                "c_defeos = ?," +
                "c_servos = ?," +
                "n_valoros = ?," +
                "n_idclien = ?," +
                "c_temntos = 'N' " +
                " WHERE n_numeos = ?");
            pst.setInt(1, ob.getTipo());
            pst.setString(2, ob.getSituacao());
            pst.setString(3, ob.getEquipamento());
            pst.setString(4, ob.getDefeito());
            pst.setString(5, ob.getServico());
            pst.setBigDecimal(6, ob.getValor());
            pst.setInt(7, ob.getIdcliente());
            pst.setInt(8, ob.getNumero());
            alterado = pst.executeUpdate();
        } catch (SQLException ex) {
            //gera arquivo de log
            geraLog.LogTxt(ex.toString(), OSDAO.class.getName());
        } finally {
            pst.close();
            con.close();
        }
        return alterado; 
    }
}
