package com.br.helpcenter.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author mauriciods
 */
public class GeraLog {
    
    public void LogTxt(String nome,String classe) {
        ManipulaDataHora mdh = new ManipulaDataHora();
        
        File arquivoTxt = new File("logs/logs.txt");

        if(!arquivoTxt.exists()) {
            try {   
                //Cria o arquivo
                arquivoTxt.createNewFile();
                System.out.println("Arquivo criado");

                //salva o arquivo
                FileWriter  writer = new FileWriter(arquivoTxt);
                writer.write("Problema:" + nome+"\n");
                writer.write("Classe:"+classe+"\n");
                writer.write("Data:"+ mdh.getDataHoraBR()+"\n");
                writer.close();
                System.out.println("Arquivo salvado");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                FileReader reader = new FileReader(arquivoTxt);
                BufferedReader br = new BufferedReader(reader);
                String linha = br.readLine();
                FileWriter writer = new FileWriter(arquivoTxt);

                while(linha != null) {
                    writer.write(linha+"\n");
                    linha = br.readLine();
                }

                br.close();
                reader.close();

                writer.write("\nProblema:" + nome+"\n");
                writer.write("Classe:"+classe+"\n");
                writer.write("Data:"+ mdh.getDataHoraBR());
                writer.close();
                System.out.println("Arquivo salvado");
            }
            catch(IOException err) {
                err.printStackTrace();
            }
        }
    }
}
