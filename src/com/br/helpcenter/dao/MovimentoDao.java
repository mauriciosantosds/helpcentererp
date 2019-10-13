package com.br.helpcenter.dao;

import com.br.helpcenter.bean.MovimentoBean;
import com.br.helpcenter.jdbc.ConnectionFactory;
import com.br.helpcenter.util.GeraLog;
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
public class MovimentoDao {
    
    private GeraLog geraLog;

    public MovimentoDao() { //cria nova instancia do objeto GeraLog no construtor
        geraLog = new GeraLog();
    }
    
    //persisti objeto de MovimentoBean
    public int create(MovimentoBean mb) throws SQLException {
        int inserido = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement("INSERT INTO helpmovi(c_catemovim,c_descmovim,n_valomovim,d_dathmovim,c_tipomovim,c_ntosmovim)\n" +
                                        "VALUES" +
                                        "(?,?,?,(SELECT now()),?,'N')");
            pst.setString(1, mb.getCategoria());
            pst.setString(2, mb.getDescricao());
            pst.setBigDecimal(3, mb.getValor());
            pst.setString(4, mb.getTipo());
            inserido = pst.executeUpdate();
            pst.close();
            con.close();
        } catch (SQLException ex) {
            geraLog.LogTxt(ex.toString(), this.getClass().getName());
        } finally {
            pst.close();
            con.close();
        }
        return inserido;
    }
    
    //le movimentacoes e retorna list de MovimentoBean
    public List<MovimentoBean> read() throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<MovimentoBean> movimentos = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement("SELECT * FROM helpmovi");
            rs = pst.executeQuery();
            while(rs.next()) {
                MovimentoBean mb = new MovimentoBean();
                mb.setIdmovim(rs.getInt("n_idmovim"));
                mb.setCategoria(rs.getString("c_catemovim"));
                mb.setDescricao(rs.getString("c_descmovim"));
                mb.setValor(rs.getBigDecimal("n_valomovim"));
                mb.setDatah(rs.getDate("d_dathmovim"));
                mb.setTipo(rs.getString("c_tipomovim"));
                mb.setIdcabno(rs.getInt("n_idcabno"));
                mb.setIdnumeos(rs.getInt("n_numeos"));
                mb.setNtosmovim(rs.getString("c_ntosmovim"));
                movimentos.add(mb);
            }
        } catch(SQLException ex) {
            //gera arquivo de log
            geraLog.LogTxt(ex.toString(), this.getClass().getName());
        } finally {
            pst.close();
            con.close();
        }
        return movimentos;
    }
    
    //retorna list de objetos MovimentoBean de acordo com periodo selecionado
    public List<MovimentoBean> read(String anoMes, String anoMesDia) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<MovimentoBean> movimentos = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement("SELECT * FROM helpmovi WHERE d_dathmovim between ? AND ?");
            pst.setString(1, anoMes+"-01 00:00:00");
            pst.setString(2, anoMesDia+" 23:59:59");
            rs = pst.executeQuery();
            while(rs.next()) {
                MovimentoBean mb = new MovimentoBean();
                mb.setIdmovim(rs.getInt("n_idmovim"));
                mb.setCategoria(rs.getString("c_catemovim"));
                mb.setDescricao(rs.getString("c_descmovim"));
                mb.setValor(rs.getBigDecimal("n_valomovim"));
                mb.setDatah(rs.getDate("d_dathmovim"));
                mb.setTipo(rs.getString("c_tipomovim"));
                mb.setIdcabno(rs.getInt("n_idcabno"));
                mb.setIdnumeos(rs.getInt("n_numeos"));
                mb.setNtosmovim(rs.getString("c_ntosmovim"));
                movimentos.add(mb);
            }
        } catch(SQLException ex) {
            //gera arquivo de log
            geraLog.LogTxt(ex.toString(), this.getClass().getName());
        } finally {
            pst.close();
            con.close();
        }
        return movimentos;
    }
    
    //retorna list de MovimentoBean de acordo com periodo selecionado e tipo se entrada ou saida
    public List<MovimentoBean> read(String dtIni, String dtFin, String tipo) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<MovimentoBean> movimentos = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
                String sql;
            if(tipo.equals("E/S")) {
               sql = "SELECT * FROM helpmovi WHERE d_dathmovim between ? AND ?";
               pst = con.prepareStatement(sql);
               pst.setString(1, dtIni+" 00:00:00");
               pst.setString(2, dtFin+" 23:59:59");
            } else {
                sql = "SELECT * FROM helpmovi WHERE d_dathmovim between ? AND ? AND c_tipomovim = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, dtIni+" 00:00:00");
                pst.setString(2, dtFin+" 23:59:59");
                pst.setString(3, tipo);
            }
            
            rs = pst.executeQuery();
            while(rs.next()) {
                MovimentoBean mb = new MovimentoBean();
                mb.setIdmovim(rs.getInt("n_idmovim"));
                mb.setCategoria(rs.getString("c_catemovim"));
                mb.setDescricao(rs.getString("c_descmovim"));
                mb.setValor(rs.getBigDecimal("n_valomovim"));
                mb.setDatah(rs.getDate("d_dathmovim"));
                mb.setTipo(rs.getString("c_tipomovim"));
                mb.setIdcabno(rs.getInt("n_idcabno"));
                mb.setIdnumeos(rs.getInt("n_numeos"));
                mb.setNtosmovim(rs.getString("c_ntosmovim"));
                movimentos.add(mb);
            }
        } catch(SQLException ex) {
            //gera arquivo de log
            geraLog.LogTxt(ex.toString(), this.getClass().getName());
        } finally {
            pst.close();
            con.close();
        }
        return movimentos;
    }
    
}
