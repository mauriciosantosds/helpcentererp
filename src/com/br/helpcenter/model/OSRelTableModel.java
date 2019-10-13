/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpcenter.model;

import com.br.helpcenter.bean.OSBean;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mauriciods
 */
public class OSRelTableModel extends AbstractTableModel{

    private List<OSBean> linhas = new ArrayList<>();
    private String[] colunas = {"ID","Número OS","Data","Tipo","Situação","Equipamento","Defeito","Serviço","Valor","Cliente","temntos"};
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna) {
            case 0 :
                return linha;
            case 1 :
                return linhas.get(linha).getNumero();
            case 2 :
                return linhas.get(linha).getDataOS();
            case 3 :
                return linhas.get(linha).getTipoOSRet();
            case 4 :
                return linhas.get(linha).getSituacao();
            case 5 :
                return linhas.get(linha).getEquipamento();
            case 6 :
                return linhas.get(linha).getDefeito();
            case 7 :
                return linhas.get(linha).getServico();
            case 8 :
                return linhas.get(linha).getValor();
            case 9 :
                return linhas.get(linha).getClienome();
            case 10 :
                return linhas.get(linha).getIdcabnota();
            case 11 :
                return linhas.get(linha).getTemntos();
        }
        return null;
    }
    
    public void addListaOS(List<OSBean> oss) {
        linhas.clear();
        int tamanhoAntigo = getRowCount();
        linhas.addAll(oss);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() -1);
    }
    
    public List<OSBean> getLinhas() {
        return this.linhas;
    }
    
    
}
