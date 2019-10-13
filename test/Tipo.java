/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mauriciods
 */
public enum Tipo {
    Orçamento(1), OS(2);
    
    private final int valor;
    Tipo(int valorOpcao){
        valor = valorOpcao;
    }
    public int getValor(){
        return valor;
    }
}


