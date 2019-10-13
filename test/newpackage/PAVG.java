package newpackage;


import newpackage.AVG;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mauriciods
 */

public class PAVG {
    
    public static void main (String[] args) {
        AVG.setNome("Pedro Alvarez Cabral");
        AVG.setId(1);
        System.out.println(nome());
        
    }
    
     static String nome() {
        return AVG.getNome();
    }
    
     static int id() {
        return AVG.getId();
    }    
}
