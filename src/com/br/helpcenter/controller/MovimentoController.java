package com.br.helpcenter.controller;

import com.br.helpcenter.bean.MovimentoBean;
import com.br.helpcenter.dao.MovimentoDao;
import com.br.helpcenter.util.GeraLog;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauriciods
 */
public class MovimentoController {
    
    public static GeraLog geralog;
    
    public MovimentoController() { //contrutor responsavel por criar objeto de log
        this.geralog = new GeraLog();
    }
    
    //persiste objeto bean de Movimento na base de dados
    public static int create(MovimentoBean mb) {
        MovimentoDao md = new MovimentoDao(); //cria objeto responsavel pela persistencia
        try {
            return md.create(mb); //retorna numero maior que 0 se inserido
        } catch (SQLException ex) {
            //gera arquivo de log
            geralog.LogTxt(ex.toString(), MovimentoController.class.getName());
        }
            return 0; //retorna 0 caso nao inserido
    }
    
    //metodo responsavel por retornar list com movimentacoes
    public static List<MovimentoBean> read() {
        MovimentoDao md = new MovimentoDao(); //cria objeto responsavel por consultar movimentacoes na base de dados
        try {
            return md.read(); //chama metodo responsavel por retornar movimentacoes
        } catch (SQLException ex) {
            //gera arquivo de log
            geralog.LogTxt(ex.toString(), MovimentoController.class.getName());
        }
        return null; //retorna nulo caso a execucao do metodo acima falhar
    }
    
    //retorna movimentos de acordo com data inicial final e tipo
    public static List<MovimentoBean> read(String dtIni, String dtFin, String tipo) {
        MovimentoDao md = new MovimentoDao(); //cria objeto responsavel por fazer a consulta
        try {
            return md.read(dtIni, dtFin, tipo); //chama metodo responsavel por fazer a consulta
        } catch (SQLException ex) {
            //gera arquivo de log
            geralog.LogTxt(ex.toString(), MovimentoController.class.getName());
        }
        return null; //retorna null caso a execucao do metodo falhar
    }
    
    //exibe futuramento ate data atual
    public static String faturamento() throws SQLException {
        BigDecimal entradas = new BigDecimal("0"); //zera variavel de entradas
        BigDecimal saidas = new BigDecimal("0"); //zera variavel de saidas
        BigDecimal total = new BigDecimal("0"); //zera variavel de total
        
        Calendar c = Calendar.getInstance(); //cria objeto calendar
        Date date; //cria objeto date
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM"); //cria objeto para conversao
        SimpleDateFormat sd2 = new SimpleDateFormat("yyyy-MM-dd"); //cria objeto para conversao
        date = c.getTime(); //recebe data atual
        String anoMes = sd.format(date); //recebe ano e mes atual no padrao americano
        String anoMesDia = sd2.format(date); //recebe ano mes e dia no padrao americano
        MovimentoDao md = new MovimentoDao(); //cria objeto responsavel por consultar faturamento
        for (MovimentoBean mb : md.read(anoMes, anoMesDia)) {//percorre list de objetos MovimentoBean
            if (mb.getTipo().equals("E")) { //se for movimento de entrada coloca objeto na variavel entradas
                entradas = entradas.add(mb.getValor());
            } else if (mb.getTipo().equals("S")) { //se for movimento de saida coloca objeto na variavel saidas
                saidas = saidas.add(mb.getValor());
            }
        }
                total = entradas.subtract(saidas); //subtrai entradas menos saidas
        return String.valueOf(total); //retorna faturamento
    }
    
    //retorna movimento de acordo com periodo e tipo selecionado
    public static String movimento(String dtIni, String dtFin, String tipo) throws SQLException {
        BigDecimal entradas = new BigDecimal("0"); //zera variaveis
        BigDecimal saidas = new BigDecimal("0");
        BigDecimal total = new BigDecimal("0");
        
        MovimentoDao md = new MovimentoDao(); //cria objeto responsavel por consultar movimentacao
        for (MovimentoBean mb : md.read(dtIni, dtFin, tipo)) { //percorre list de objetos MovimentoBean
            if (mb.getTipo().equals("E")) { //se for movimento de entrada coloca objeto na variavel entradas
                entradas = entradas.add(mb.getValor());
            } else if (mb.getTipo().equals("S")) { //se for movimento de saida coloca objeto na variavel saidas
                saidas = saidas.add(mb.getValor());
            }
        }
                total = entradas.subtract(saidas); //subtrai entradas menos saidas
        return String.valueOf(total); //retorna total positivo ou negativo
    }
            
}
