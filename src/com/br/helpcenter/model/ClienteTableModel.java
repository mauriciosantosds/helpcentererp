/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpcenter.model;
import com.br.helpcenter.bean.ClienteBean;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author mauriciods
 */
public class ClienteTableModel extends AbstractTableModel {
    private List<ClienteBean> linhas = new ArrayList<>();
    private String[] colunas = {"ID","Nome","Celular","Telefone 2","E-Mail","Endereço","CPF"};
    
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
        switch (coluna) {
            case 0:
                return linhas.get(linha).getId();
            case 1:
                return linhas.get(linha).getNome();
            case 2:
                return linhas.get(linha).getFoneUm();
            case 3:
                return linhas.get(linha).getFoneDois();
            case 4:
                return linhas.get(linha).getEmail();
            case 5:
                return linhas.get(linha).getEndereco();
            case 6:
                return linhas.get(linha).getCPF();
        }
        return null;
    }
    
    public void addRow(ClienteBean c) {
        this.linhas.add(c);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    public void removeRow(int linha) {
        this.linhas.remove(linha);
        fireTableRowsDeleted(linha, linha);
    }
    
    public void addListaDeClientes(List<ClienteBean> novosClientes) {  
        linhas.clear();
        int tamanhoAntigo = getRowCount();      
        linhas.addAll(novosClientes);    
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);  
      }  
    
    public void alterar(ClienteBean c, int linha) {
        this.linhas.add(linha, c);
        this.fireTableRowsUpdated(linha, linha);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    } 
    
}
