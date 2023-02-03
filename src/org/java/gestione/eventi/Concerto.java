package org.java.gestione.eventi;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Concerto extends Evento {
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm").withLocale(Locale.ITALIAN);
	private LocalTime orario;
	private BigDecimal prezzo;
	public Concerto(String titolo, String data, int numeroPosti, String ora, String prezzo) throws Exception {
		super(titolo, data, numeroPosti);
		this.orario=formatTime(ora);
		this.prezzo= setPrezzo(prezzo);;
		
	}
	public LocalTime getOrario() {
		return orario;
	}
	public void setOrario(String ora) {
		this.orario = formatTime(ora);
	}
	public BigDecimal getPrezzo() {
		return prezzo;
	}
	public BigDecimal setPrezzo(String prezzoStr) throws Exception {
		BigDecimal prezzo= new BigDecimal(prezzoStr);
		BigDecimal prezzoBase= new BigDecimal("0.0");
		if(prezzo.compareTo(prezzoBase)<0 || prezzo.compareTo(prezzoBase)==0) {
			throw new Exception("Il prezzo inserito non e'valido");
		}
		return prezzo;
	}
	private LocalTime formatTime(String time) {
		 LocalTime timeLoc = LocalTime.parse(time,formatter);
	        return timeLoc;
	}
	public String getPrezzoFormattato() {
		return NumberFormat.getCurrencyInstance(Locale.ITALY).format(prezzo);
	}
	@Override
    public String toString() {
        return "Concerto: " + getData() + " - " + orario + " - "+ getTitolo() + " - " + getPrezzoFormattato() ;
    }
}
