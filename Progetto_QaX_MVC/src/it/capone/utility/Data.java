package it.capone.utility;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.GregorianCalendar;

public class Data {

	private int anno;
	private int mese;
	private int giorno;
	private int ore;
	private int minuti;
	private int secondi;

	public Data(){}  //Requisito necessario per usare i JavaBean(tag jsp:useBean )
	
	public Data(int anno, int mese, int giorno, int ore, int minuti, int secondi) {
		this.anno = GregorianCalendar.YEAR;
		this.mese = GregorianCalendar.MONTH + 1;
		this.giorno = GregorianCalendar.DATE;
		this.ore = GregorianCalendar.HOUR;
		this.minuti = GregorianCalendar.MINUTE;
		this.secondi = GregorianCalendar.SECOND;
	}

	/**
	 * 
	 * @param anno
	 * @param mese
	 * @param giorno
	 */
	public Data(int anno, int mese, int giorno){
            this.anno=anno;
            this.mese=mese;
            this.giorno=giorno;
        }

	public int getAnno(){
		return anno;
	}

	public int getMese(){
		return mese;
	}

	public int getGiorno(){
		return giorno;
	}
	
	public int getOre() {
		return ore;
	}


	public int getMinuti() {
		return minuti;
	}


	public int getSecondi() {
		return secondi;
	}
	
        
        
        @Override
        public String toString()
        {
            String data;
            data=this.getGiorno()+"/"+this.getMese()+"/"+this.getAnno();
            return data;
        }
}
