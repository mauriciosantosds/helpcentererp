/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpcenter.model;

import com.br.helpcenter.bean.CabNoBean;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mauriciods
 */
public class VendaRelTableModel extends AbstractTableModel {
    private List<CabNoBean> linhas = new ArrayList<>();
    private String[] colunas = {"ID","Data","Quantidade","Total","Cliente"};

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
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 :
               return rowIndex;
            case 1 :
                return linhas.get(rowIndex).getDthcabno();
            case 2 :
                return linhas.get(rowIndex).getQuantidade();
            case 3 :
                return linhas.get(rowIndex).getTotalCabNota();
            case 4 :
                return linhas.get(rowIndex).getClienNome();
        }
        return null;
    }
    
    public void addListaDeVendas(List<CabNoBean> vendas) {
        linhas.clear();
        int tamanhoAntigo = getRowCount();
        linhas.addAll(vendas);
        fireTableRowsInserted(tamanhoAntigo, tamanhoAntigo -1);
    }
    
    public List<CabNoBean> getLinhas() {
        return this.linhas;
    }
    
}
