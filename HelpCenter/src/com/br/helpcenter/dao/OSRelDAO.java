package com.br.helpcenter.dao;

import com.br.helpcenter.bean.OSBean;
import com.br.helpcenter.jdbc.ConnectionFactory;
import com.br.helpcenter.util.GeraLog;
import com.br.helpcenter.util.ManipulaDataHora;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mauriciods
 */
public class OSRelDAO {
    
    private GeraLog geraLog;
    
    public OSRelDAO() { //cria nova instancia no construtor de objeto GeraLog
        geraLog = new GeraLog();
    }
    
    //retorna list de objetos OSBean
    public List<OSBean> read() throws SQLException {
        ManipulaDataHora mdh = new ManipulaDataHora();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<OSBean> OSs = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement("SELECT ho.n_numeos, ho.d_dathos, ho.c_tipoos, ho.c_situos, ho.c_equios, ho.c_defeos, ho.c_servos, ho.n_valoros," +
            "ho.n_idclien, ho.n_idcabno, ho.c_temntos, hc.c_nomeclien" +
            " FROM helpos as ho JOIN helpclien as hc ON ho.n_idclien = hc.n_idclien WHERE ho.c_temNtos = 'N';");
            rs = pst.executeQuery();
            while (rs.next()) {
                OSBean ob = new OSBean();
                ob.setNumero(rs.getInt("n_numeos"));
                ob.setDataOS(mdh.getDataHoraBR(rs.getString("d_dathos")));
                ob.setTipoOSRet(rs.getString("c_tipoos"));
                ob.setSituacao(rs.getString("c_situos"));
                ob.setEquipamento(rs.getString("c_equios"));
                ob.setDefeito(rs.getString("c_defeos"));
                ob.setServico(rs.getString("c_servos"));
                ob.setValor(new BigDecimal(rs.getString("n_valoros")));
                ob.setIdcliente(rs.getInt("n_idclien"));
                ob.setIdcabnota(rs.getInt("n_idcabno"));
                ob.setClienome(rs.getString("c_nomeclien"));
                ob.setTemntos(rs.getString("c_temntos"));
                OSs.add(ob);
            }
        } catch (SQLException ex) {
            //gera arquivo de log
            geraLog.LogTxt(ex.toString(), OSRelDAO.class.getName());
        }
        return OSs;
    }
    
    //retorna list de objetos OSBean de acordo com periodo selecionado e se tem ou nao nota de os
    public List<OSBean> read(String dtIni, String dtFin, String notaOS) throws SQLException {
        ManipulaDataHora mdh = new ManipulaDataHora();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<OSBean> OSs = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement("SELECT ho.n_numeos, ho.d_dathos, ho.c_tipoos, ho.c_situos, ho.c_equios, ho.c_defeos, ho.c_servos, ho.n_valoros," +
                                        " ho.n_idclien, ho.n_idcabno, ho.c_temntos, hc.c_nomeclien" +
                                        " FROM helpos as ho JOIN helpclien as hc ON ho.n_idclien = hc.n_idclien" +
                                        " WHERE c_temntos = ? AND ho.d_dathos BETWEEN ? AND ?;");
            pst.setString(1, notaOS);
            pst.setString(2, dtIni+" 00:00:00");
            pst.setString(3, dtFin+" 23:59:59");
            rs = pst.executeQuery();
            while (rs.next()) {
                OSBean ob = new OSBean();
                ob.setNumero(rs.getInt("n_numeos"));
                ob.setDataOS(mdh.getDataHoraBR(rs.getString("d_dathos")));
                ob.setTipoOSRet(rs.getString("c_tipoos"));
                ob.setSituacao(rs.getString("c_situos"));
                ob.setEquipamento(rs.getString("c_equios"));
                ob.setDefeito(rs.getString("c_defeos"));
                ob.setServico(rs.getString("c_servos"));
                ob.setValor(new BigDecimal(rs.getString("n_valoros")));
                ob.setIdcliente(rs.getInt("n_idclien"));
                ob.setIdcabnota(rs.getInt("n_idcabno"));
                ob.setClienome(rs.getString("c_nomeclien"));
                ob.setTemntos(rs.getString("c_temntos"));
                OSs.add(ob);
            }
        } catch (SQLException ex) {
            //gera arquivo de log
            geraLog.LogTxt(ex.toString(), OSRelDAO.class.getName());
        }
        return OSs;
    }
}
