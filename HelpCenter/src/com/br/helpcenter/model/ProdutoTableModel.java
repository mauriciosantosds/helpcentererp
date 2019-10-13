/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpcenter.model;


import javax.swing.table.AbstractTableModel;
import com.br.helpcenter.bean.ProdutoBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mauriciods
 */
public class ProdutoTableModel extends AbstractTableModel {
    
    private List<ProdutoBean> linhas = new ArrayList<>();
    private String[] colunas = {"ID","EAN","Produto","Preço","Quantidade"};

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
                return linhas.get(linha).getId();
            case 1:
                return linhas.get(linha).getEan();
            case 2:
                return linhas.get(linha).getDesc();
            case 3:
                return linhas.get(linha).getPreco();
            case 4:
                return linhas.get(linha).getQtd();
        }
        return null;
    }
    
    public void addListaDeProdutos(List<ProdutoBean> novosProdutos) {
        linhas.clear();
        int tamanhoAntigo = getRowCount();
        linhas.addAll(novosProdutos);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() -1);
    }
    
    public void addRow(ProdutoBean pb) {
        this.linhas.add(pb);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha) {
        this.linhas.remove(linha);
        this.fireTableDataChanged();
    }

    public List<ProdutoBean> getLinhas() {
        return linhas;
    }
    
    
    
}
