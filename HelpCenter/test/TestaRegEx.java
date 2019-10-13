
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mauriciods
 */
public class TestaRegEx {
    
    public static void main(String[] args) {
    //Scanner ent = new Scanner(System.in);
    //String var = ent.next();
    
         Pattern pattern = Pattern.compile("[a-zA-Z]{3,3}-\\d{4,4}");
        Matcher matcher = pattern.matcher("ETE-1234");
 
        if( matcher.find() ){
            System.out.println("Encontrou");
        }else{
            System.out.println("Não encontrou");
        }
    }
}
