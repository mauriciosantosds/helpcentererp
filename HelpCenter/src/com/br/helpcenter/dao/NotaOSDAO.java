package com.br.helpcenter.dao;

import com.br.helpcenter.bean.CabNoBean;
import com.br.helpcenter.bean.NotaOSBean;
import com.br.helpcenter.bean.OSBean;
import com.br.helpcenter.jdbc.ConnectionFactory;
import com.br.helpcenter.util.GeraLog;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mauriciods
 */
public class NotaOSDAO {
    
    private GeraLog geraLog;
    
    public NotaOSDAO() { //cria nova instancia no construtor de objeto GeraLog
        geraLog = new GeraLog();
    }
    
    //persiste objeto de CabNoBean
    public int create(CabNoBean cnb) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int inserido = 0;
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement("INSERT INTO helpcabno (d_dathcabno,n_quancabno,n_idclien,n_totacabno,c_eoscabno)" +
                                       "VALUES" +
                                       "((SELECT now()),?,?,?,'S');", Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, cnb.getQuantidade());
            pst.setInt(2, cnb.getIdCliente());
            pst.setBigDecimal(3, cnb.getTotalCabNota());
            if (pst.executeUpdate() > 0) {
                int idcabno = 0;
                rs = pst.getGeneratedKeys();
                while (rs.next()) {
                    idcabno = rs.getInt(1);
                }
                for (OSBean os : cnb.getOsS()) {

                    pst = con.prepareStatement("INSERT INTO helpmovi (c_catemovim,c_descmovim,d_dathmovim,n_valomovim,c_tipomovim,n_idcabno,n_numeos,c_ntosmovim) " +
                                            "VALUES" +
                                            "('OS',?," +
                                            "(SELECT d_dathcabno FROM helpcabno WHERE n_idcabno = ?),?," +
                                            "'E',?,?,'S');");
                    pst.setString(1, os.getEquipamento());
                    pst.setInt(2, idcabno);
                    pst.setBigDecimal(3, os.getValor());
                    pst.setInt(4, idcabno);
                    pst.setInt(5, os.getNumero());
                    pst.executeUpdate();

                    pst = con.prepareStatement("UPDATE helpos SET" +
                                                " n_idcabno = ?," +
                                                "c_temntos = 'S'" +
                                                " WHERE n_numeos = ?;");
                    pst.setInt(1, idcabno);
                    pst.setInt(2, os.getNumero());
                    inserido = pst.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            //gera arquivo de log
            geraLog.LogTxt(ex.toString(), NotaOSDAO.class.getName());
        } finally {
            pst.close();
            con.close();
        }
        return inserido; //retorna numero maior que 0 se inserido
    }
    
    //retorna objeto bean de nota os
    public NotaOSBean readCabNo(int idcabno) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        NotaOSBean notaOSBean = new NotaOSBean();
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement("SELECT d_dathcabno, n_quancabno, n_totacabno, cl.c_nomeclien" +
                                        " FROM helpcabno cn" +
                                        " JOIN helpclien AS cl" +
                                        " ON cl.n_idclien = cn.n_idclien" +
                                        " WHERE cn.c_eoscabno = 'S' AND cn.n_idcabno = ?");
            pst.setInt(1, idcabno);
            rs = pst.executeQuery();
            while (rs.next()) {
                notaOSBean.setDthcabno(rs.getString("d_dathcabno"));
                notaOSBean.setNomeCli(rs.getString("cl.c_nomeclien"));
                notaOSBean.setQuantidade(rs.getInt("n_quancabno"));
                notaOSBean.setTotal(rs.getBigDecimal("n_totacabno"));
            }
            
            pst = con.prepareStatement("SELECT ho.n_numeos, ho.c_equios, ho.d_dathos, ho.n_valoros," 
                    + "hc.n_idclien, hc.c_nomeclien" +
                      " FROM helpcabno AS hcn" +
                      " JOIN helpos AS ho JOIN helpclien AS hc ON ho.n_idclien = hc.n_idclien" +
                      " AND hcn.n_idcabno = ho.n_idcabno" +
                      " WHERE hcn.c_eoscabno = 'S' AND ho.c_temntos = 'S' AND hcn.n_idcabno = ?;");
            pst.setInt(1, idcabno);
            rs = pst.executeQuery();
            while (rs.next()) {
                OSBean osBean = new OSBean();
                osBean.setNumero(rs.getInt("ho.n_numeos"));
                osBean.setEquipamento(rs.getString("ho.c_equios"));
                osBean.setValor(new BigDecimal(rs.getString("ho.n_valoros")));
                osBean.setClienome(rs.getString("hc.c_nomeclien"));
                osBean.setDataOS(rs.getString("ho.d_dathos"));
                notaOSBean.getoSs().add(osBean);
            }
            } catch (SQLException ex) {
                    //gera arquivo de log
                    geraLog.LogTxt(ex.toString(), NotaOSDAO.class.getName());
                } finally {
                    pst.close();
                    con.close();
                    }
            return notaOSBean;    
        }
}
