/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mauriciods
 */
public class TestadoraEnum {
    public static void escolheOpcao(Tipo tipo){
        if(tipo == Tipo.OS){
            System.out.println("Ordem de Serviço");
        }
        else if(tipo == Tipo.Orçamento){
            System.out.println("Orçamento");
        }
    }

    public static void main(String[] args) {
        escolheOpcao(Tipo.Orçamento); 
    }
}
