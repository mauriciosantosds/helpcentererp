package com.br.helpcenter.dao;

import com.br.helpcenter.bean.CabNoBean;
import com.br.helpcenter.bean.ProdutoBean;
import com.br.helpcenter.jdbc.ConnectionFactory;
import com.br.helpcenter.util.GeraLog;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mauriciods
 */
public class CabNoDao {
    
    private GeraLog geraLog;

    public CabNoDao() { //cria nova instancia do objeto GeraLog no construtor
        geraLog = new GeraLog();
    }
    
    public int create(CabNoBean cnb) throws SQLException { //metodo responsavel por persistir uma nova venda
        int idcabno = 0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int inserido = 0;
        try {
            String sql = "INSERT INTO helpcabno(d_dathcabno,n_quancabno,n_idclien,n_totacabno,c_eoscabno) "
                    + "VALUES ((select now()),?,?,?,?)";
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, cnb.getQuantidade());
            pst.setInt(2, cnb.getIdCliente());
            pst.setBigDecimal(3, cnb.getTotalCabNota());
            pst.setString(4, cnb.geteOSCabNota());
            if (pst.executeUpdate() > 0) {
                pst = con.prepareStatement("SELECT last_insert_id()");
                rs = pst.executeQuery();
                while (rs.next()) {
                    idcabno = rs.getInt(1);
                }
                if (idcabno > 0) {
                    for (ProdutoBean pb : cnb.getItens()) {
                        pst = con.prepareStatement("INSERT INTO helpiteno(n_quaniteno,n_preciteno,n_idcabno,n_idprodu)" 
                            + "VALUES (?,?,?,?)");
                        pst.setInt(1, pb.getQtd());
                        pst.setBigDecimal(2, pb.getPreco());
                        pst.setInt(3, idcabno);
                        pst.setInt(4, pb.getId());
                        pst.executeUpdate();
                    }
                    pst = con.prepareStatement("INSERT INTO helpmovi(c_catemovim,c_descmovim,d_dathmovim,n_valomovim,c_tipomovim,"
                                    + "n_idcabno,c_ntosmovim)" +
                                        "VALUES ('VENDA DE MERCADORIA','VENDA DE MERCADORIA',"
                                    + "(SELECT d_dathcabno FROM helpcabno WHERE n_idcabno = ?),?,'E',?,?)");
                    pst.setInt(1, idcabno);
                    pst.setBigDecimal(2, cnb.getTotalCabNota());
                    pst.setInt(3, idcabno);
                    pst.setString(4, cnb.geteOSCabNota());
                    inserido = pst.executeUpdate();
                    pst.close();
                }
            }
        } catch (SQLException ex) {
            //gera arquivo de log
            geraLog.LogTxt(ex.toString(), CabNoDao.class.getName());
        } finally {
            pst.close();
            con.close();
        }
        return inserido;
    }
}
