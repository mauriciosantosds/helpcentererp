/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mauriciods
 */

import java.util.Calendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestaCalendar {
    public static void main (String[] args) {
        
   /* Calendar c = Calendar.getInstance();
		c.set(2013, Calendar.FEBRUARY, 28);
		Date data = c.getTime();
		System.out.println("Data atual sem formatação: "+data);
		
		//Formata a data
		DateFormat formataData = DateFormat.getDateInstance();
		System.out.println("Data atual com formatação: "+ formataData.format(data));
		
		//Formata Hora
DateFormat hora = DateFormat.getTimeInstance();
		System.out.println("Hora formatada: "+hora.format(data));

		//Formata Data e Hora
		DateFormat dtHora = DateFormat.getDateTimeInstance();
		System.out.println(dtHora.format(data));*/
   Date dataAtual = new Date();

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        String DateToStr = "2017/08/31";
        System.out.println(DateToStr);

        format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        DateToStr = format.format(dataAtual);
        System.out.println(DateToStr);

        format = new SimpleDateFormat("dd MMMM yyyy zzzz", Locale.ENGLISH);
        DateToStr = format.format(dataAtual);
        System.out.println(DateToStr);

        format = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
        DateToStr = format.format(dataAtual);
        System.out.println(DateToStr);

        try {
            Date strToDate = format.parse(DateToStr);
            System.out.println(strToDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
