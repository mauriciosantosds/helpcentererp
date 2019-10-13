package newpackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mauriciods
 */
public class AVG {
    private static int id;
    private static String nome;
    private static String sobrename;
    private String teste;

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }
    
    
    
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        AVG.id = id;
    }

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        AVG.nome = nome;
    }

    public static String getSobrename() {
        return sobrename;
    }

    public void setSobrename(String sobrename) {
        this.sobrename = sobrename;
    }
    
    
}
