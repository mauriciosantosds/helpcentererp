/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author mauriciods
 */
public class Moto {
    private static Moto INSTANCE;
    
    /*private Moto() {
        
    }*/
    
    public static synchronized Moto getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Moto();
        }
        return INSTANCE;
    }
    
    private int ligar = 0;

    /*public static Moto getInstance() {
        return INSTANCE;
    }*/
    
    public int getLigar() {
        return ligar;
    }

    public void setLigar(int ligar) {
        this.ligar = ligar;
    }
    
    
    
    
}
