/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpcenter.model;

import com.br.helpcenter.bean.ItemNotaBean;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mauriciods
 */
public class ItemNotaTableModel extends AbstractTableModel {
    private List<ItemNotaBean> linhas = new ArrayList<>();
    private String[] colunas = {"ID","Quantidade","Preço"};
            
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna) {
            case 0:
                return linhas.get(linha).getIdItNo();
            case 1:
                return linhas.get(linha).getQtd();
            case 2:
                return linhas.get(linha).getPreco();
            case 3:
                return linhas.get(linha).getIdCabNo();
            case 4:
                return linhas.get(linha).getIdprodu();
        }
        return null;
    }
   
    
}
