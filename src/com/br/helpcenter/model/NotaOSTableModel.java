/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpcenter.model;

import com.br.helpcenter.bean.OSBean;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mauriciods
 */
public class NotaOSTableModel extends AbstractTableModel {

    private List<OSBean> linhas = new ArrayList<>();
    private String[] colunas = {"Número OS","Data","Equipamento","Valor","Cliente"};
    
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
                return linhas.get(linha).getNumero();
            case 1 :
                return linhas.get(linha).getDataOS();
            case 2 :
                return linhas.get(linha).getEquipamento();
            case 3 :
                return linhas.get(linha).getValor();
            case 4 :
                return linhas.get(linha).getClienome();
        }
        return null;
    }
    
    public void addRow(OSBean ob) {
        this.linhas.add(ob);
        this.fireTableDataChanged();
    }

    public void removeRow(int linha) {
        this.linhas.remove(linha);
        fireTableRowsDeleted(linha, linha);
    }
    
    public void addListaDeOSS(List<OSBean> osS) {
        this.linhas.clear();
        this.linhas = osS;
        this.fireTableDataChanged();
    }
    
    public List<OSBean> getLinhas() {
        return linhas;
    }
    
}
