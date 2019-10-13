/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpcenter.model;

import com.br.helpcenter.bean.MovimentoBean;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mauriciods
 */
public class MovimentoTableModel extends AbstractTableModel {
    private List<MovimentoBean> linhas = new ArrayList<>();
    private String[] colunas = {"ID","ID Movim","Categoria","Descrição","Valor","Data","Tipo","Nota OS"};

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
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 :
                return rowIndex;
            case 1 :
                return linhas.get(rowIndex).getIdmovim();
            case 2 :
                return linhas.get(rowIndex).getCategoria();
            case 3 :
                return linhas.get(rowIndex).getDescricao();
            case 4 :
                return linhas.get(rowIndex).getValor();
            case 5 :
                return linhas.get(rowIndex).getDatah();
            case 6 :
                return linhas.get(rowIndex).getTipo();
            case 7 :
                return linhas.get(rowIndex).getNtosmovim();
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public void addRow(MovimentoBean mb) {
        this.linhas.add(mb);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    public void removeRow(int linha) {
        this.linhas.remove(linha);
        fireTableRowsDeleted(linha, linha);
    }
    
    public void addListaDeMovimentos(List<MovimentoBean> novosMovimentos) {  
        linhas.clear();
        int tamanhoAntigo = getRowCount();      
        linhas.addAll(novosMovimentos);    
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);  
      }  
    
    public void alterar(MovimentoBean mb, int linha) {
        this.linhas.add(linha, mb);
        this.fireTableRowsUpdated(linha, linha);
    }
    
    public List<MovimentoBean> getLinhas() {
        return this.linhas;
    }
  
}
