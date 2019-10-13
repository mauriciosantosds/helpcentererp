package com.br.helpcenter.dao;

import com.br.helpcenter.bean.CabNoBean;
import com.br.helpcenter.bean.OSBean;
import com.br.helpcenter.bean.ProdutoBean;
import com.br.helpcenter.jdbc.ConnectionFactory;
import com.br.helpcenter.util.GeraLog;
import com.br.helpcenter.util.ManipulaDataHora;
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
public class VendaRelDAO {
    
    private GeraLog geraLog;
    
    public VendaRelDAO() {//cria novo isntancia no construtor de objeto GeraLog
        geraLog = new GeraLog();
    }
    
    //retorna list de objetos CabNoBean de vendas
    public List<CabNoBean> readVenda() throws SQLException {
        List<CabNoBean> vendas = new ArrayList<>();
        ManipulaDataHora mdh = new ManipulaDataHora();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement("SELECT c.n_idcabno, c.d_dathcabno, c.n_quancabno, c.n_idclien, c.n_totacabno," +
                                        "cl.c_nomeclien " +
                                        "FROM helpcabno AS c " +
                                        "JOIN helpclien AS cl ON c.n_idclien = cl.n_idclien " +
                                        "WHERE c.c_eoscabno = 'N'");
            rs = pst.executeQuery();
            while(rs.next()) {
                CabNoBean cnb = new CabNoBean();
                cnb.setId(rs.getInt("n_idcabno"));
                cnb.setDthcabno(mdh.getDataHoraBR(rs.getString("d_dathcabno")));
                cnb.setQuantidade(rs.getInt("n_quancabno"));
                cnb.setIdCliente(rs.getInt("n_idclien"));
                cnb.setTotalCabNota(rs.getBigDecimal("n_totacabno"));
                cnb.setClienNome(rs.getString("c_nomeclien"));
                vendas.add(cnb);
            }
            for (CabNoBean cnb : vendas) {
                pst = con.prepareStatement("SELECT p.n_idprodu, p.c_eanprodu, p.c_descprodu, itn.n_preciteno, itn.n_quaniteno " +
                                            "FROM helpcabno AS c " +
                                            "JOIN helpclien AS cl ON c.n_idclien = cl.n_idclien " +
                                            "JOIN helpiteno AS itn ON c.n_idcabno = itn.n_idcabno " +
                                            "JOIN helpprodu AS p on itn.n_idprodu = p.n_idprodu " +
                                            "WHERE c.c_eoscabno = 'N' AND c.n_idcabno = ?");
                pst.setInt(1, cnb.getId());
                rs = pst.executeQuery();
                while(rs.next()) {
                    ProdutoBean pb = new ProdutoBean();
                    pb.setId(rs.getInt("p.n_idprodu"));
                    pb.setDesc(rs.getString("p.c_descprodu"));
                    pb.setEan(rs.getString("p.c_eanprodu"));
                    pb.setPreco(rs.getBigDecimal("itn.n_preciteno"));
                    pb.setQtd(rs.getInt("itn.n_quaniteno"));
                    cnb.getItens().add(pb);
                }
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            //gera arquivo de log
            geraLog.LogTxt(ex.toString(), VendaRelDAO.class.getName());
        } finally {
            pst.close();
            con.close();
        }
        return vendas;
    }
    
    //retorna list de objetos CabNoBean de os
    public List<CabNoBean> readOS() throws SQLException {
        List<CabNoBean> vendas = new ArrayList<>();
        ManipulaDataHora mdh = new ManipulaDataHora();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement("SELECT c.n_idcabno, c.d_dathcabno, c.n_quancabno, c.n_idclien, c.n_totacabno," +
                                        "cl.c_nomeclien " +
                                        "FROM helpcabno AS c " +
                                        "JOIN helpclien AS cl ON c.n_idclien = cl.n_idclien " +
                                        "WHERE c.c_eoscabno = 'S'");
            rs = pst.executeQuery();
            while(rs.next()) {
                CabNoBean cnb = new CabNoBean();
                cnb.setId(rs.getInt("n_idcabno"));
                cnb.setDthcabno(mdh.getDataHoraBR(rs.getString("d_dathcabno")));
                cnb.setQuantidade(rs.getInt("n_quancabno"));
                cnb.setIdCliente(rs.getInt("n_idclien"));
                cnb.setTotalCabNota(rs.getBigDecimal("n_totacabno"));
                cnb.setClienNome(rs.getString("c_nomeclien"));
                vendas.add(cnb);
            }
            for (CabNoBean cnb : vendas) {
                pst = con.prepareStatement("SELECT os.n_numeos, os.c_defeos, os.c_equios, os.c_servos, "
                                            + "os.c_situos, os.c_tipoos, os.d_dathos, os.n_valoros, "
                                            + "cl.n_idclien, cl.c_nomeclien FROM helpcabno AS c "
                                            + "JOIN helpclien AS cl ON c.n_idclien = cl.n_idclien "
                                            + "JOIN helpos AS os ON c.n_idcabno = os.n_idcabno "
                                            + "WHERE c.c_eoscabno = 'S' AND os.c_temntos = 'S' AND c.n_idcabno = ?");
                pst.setInt(1, cnb.getId());
                rs = pst.executeQuery();
                while(rs.next()) {
                    OSBean ob = new OSBean();
                    ob.setClienome(rs.getString("cl.c_nomeclien"));
                    ob.setIdcliente(rs.getInt("cl.n_idclien"));
                    ob.setDataOS(mdh.getDataHoraBR(rs.getString("os.d_dathos")));
                    ob.setDefeito(rs.getString("os.c_defeos"));
                    ob.setEquipamento(rs.getString("os.c_equios"));
                    ob.setServico(rs.getString("os.c_servos"));
                    ob.setSituacao(rs.getString("os.c_situos"));
                    ob.setTipoOSRet(rs.getString("os.c_tipoos"));
                    ob.setNumero(rs.getInt("os.n_numeos"));
                    ob.setValor(rs.getBigDecimal("os.n_valoros"));
                    cnb.getOsS().add(ob);
                }
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            //gera arquivo de log
            geraLog.LogTxt(ex.toString(), VendaRelDAO.class.getName());
        } finally {
            pst.close();
            con.close();
        }
        return vendas;
    }
    
    //retorna list de objetos CabNoBean de venda de acordo com periodo selecionado
    public List<CabNoBean> readVenda(String dtIni, String dtFin) throws SQLException {
        List<CabNoBean> vendas = new ArrayList<>();
        ManipulaDataHora mdh = new ManipulaDataHora();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement("SELECT c.n_idcabno, c.d_dathcabno, c.n_quancabno, c.n_idclien, c.n_totacabno," +
                                        "cl.c_nomeclien " +
                                        "FROM helpcabno AS c " +
                                        "JOIN helpclien AS cl ON c.n_idclien = cl.n_idclien " +
                                        "WHERE c.c_eoscabno = 'N' AND c.d_dathcabno BETWEEN ? AND ?");
            pst.setString(1, dtIni+" 00:00:00");
            pst.setString(2, dtFin+" 23:59:59");
            rs = pst.executeQuery();
            while(rs.next()) {
                CabNoBean cnb = new CabNoBean();
                cnb.setId(rs.getInt("n_idcabno"));
                cnb.setDthcabno(mdh.getDataHoraBR(rs.getString("d_dathcabno")));
                cnb.setQuantidade(rs.getInt("n_quancabno"));
                cnb.setIdCliente(rs.getInt("n_idclien"));
                cnb.setTotalCabNota(rs.getBigDecimal("n_totacabno"));
                cnb.setClienNome(rs.getString("c_nomeclien"));
                vendas.add(cnb);
            }
            for (CabNoBean cnb : vendas) {
                pst = con.prepareStatement("SELECT p.n_idprodu, p.c_eanprodu, p.c_descprodu, itn.n_preciteno, itn.n_quaniteno " +
                                            "FROM helpcabno AS c " +
                                            "JOIN helpclien AS cl ON c.n_idclien = cl.n_idclien " +
                                            "JOIN helpiteno AS itn ON c.n_idcabno = itn.n_idcabno " +
                                            "JOIN helpprodu AS p on itn.n_idprodu = p.n_idprodu " +
                                            "WHERE c.c_eoscabno = 'N' AND c.n_idcabno = ?");
                pst.setInt(1, cnb.getId());
                rs = pst.executeQuery();
                while(rs.next()) {
                    ProdutoBean pb = new ProdutoBean();
                    pb.setId(rs.getInt("p.n_idprodu"));
                    pb.setDesc(rs.getString("p.c_descprodu"));
                    pb.setEan(rs.getString("p.c_eanprodu"));
                    pb.setPreco(rs.getBigDecimal("itn.n_preciteno"));
                    pb.setQtd(rs.getInt("itn.n_quaniteno"));
                    cnb.getItens().add(pb);
                }
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            //gera arquivo de log
            geraLog.LogTxt(ex.toString(), VendaRelDAO.class.getName());
        } finally {
            pst.close();
            con.close();
        }
        return vendas;
    }
    
    //retorna list de objetos CabNoBean de os de acordo com periodo selecionado
    public List<CabNoBean> readOS(String dtIni, String dtFin) throws SQLException {
        List<CabNoBean> vendas = new ArrayList<>();
        ManipulaDataHora mdh = new ManipulaDataHora();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement("SELECT c.n_idcabno, c.d_dathcabno, c.n_quancabno, c.n_idclien, c.n_totacabno," +
                                        "cl.c_nomeclien " +
                                        "FROM helpcabno AS c " +
                                        "JOIN helpclien AS cl ON c.n_idclien = cl.n_idclien " +
                                        "WHERE c.c_eoscabno = 'S' AND c.d_dathcabno BETWEEN ? AND ?");
            pst.setString(1, dtIni+" 00:00:00");
            pst.setString(2, dtFin+" 23:59:59");
            rs = pst.executeQuery();
            while(rs.next()) {
                CabNoBean cnb = new CabNoBean();
                cnb.setId(rs.getInt("n_idcabno"));
                cnb.setDthcabno(mdh.getDataHoraBR(rs.getString("d_dathcabno")));
                cnb.setQuantidade(rs.getInt("n_quancabno"));
                cnb.setIdCliente(rs.getInt("n_idclien"));
                cnb.setTotalCabNota(rs.getBigDecimal("n_totacabno"));
                cnb.setClienNome(rs.getString("c_nomeclien"));
                vendas.add(cnb);
            }
            for (CabNoBean cnb : vendas) {
                pst = con.prepareStatement("SELECT os.n_numeos, os.c_defeos, os.c_equios, os.c_servos, "
                                            + "os.c_situos, os.c_tipoos, os.d_dathos, os.n_valoros, "
                                            + "cl.n_idclien, cl.c_nomeclien FROM helpcabno AS c "
                                            + "JOIN helpclien AS cl ON c.n_idclien = cl.n_idclien "
                                            + "JOIN helpos AS os ON c.n_idcabno = os.n_idcabno "
                                            + "WHERE c.c_eoscabno = 'S' AND os.c_temntos = 'S' AND c.n_idcabno = ?");
                pst.setInt(1, cnb.getId());
                rs = pst.executeQuery();
                while(rs.next()) {
                    OSBean ob = new OSBean();
                    ob.setClienome(rs.getString("cl.c_nomeclien"));
                    ob.setIdcliente(rs.getInt("cl.n_idclien"));
                    ob.setDataOS(mdh.getDataHoraBR(rs.getString("os.d_dathos")));
                    ob.setDefeito(rs.getString("os.c_defeos"));
                    ob.setEquipamento(rs.getString("os.c_equios"));
                    ob.setServico(rs.getString("os.c_servos"));
                    ob.setSituacao(rs.getString("os.c_situos"));
                    ob.setTipoOSRet(rs.getString("os.c_tipoos"));
                    ob.setNumero(rs.getInt("os.n_numeos"));
                    ob.setValor(rs.getBigDecimal("os.n_valoros"));
                    cnb.getOsS().add(ob);
                }
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            //gera arquivo de log
            geraLog.LogTxt(ex.toString(), VendaRelDAO.class.getName());
        } finally {
            pst.close();
            con.close();
        }
        return vendas;
    }
}
