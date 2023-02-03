package org.java.gestione.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Evento {
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private String titolo;
	private LocalDate data;
	private int numeroPosti;
	private int numeroPostiPrenotati=0;
	LocalDate oggi = LocalDate.now();
	public Evento(String titolo, String data, int numeroPosti) throws Exception {
		super();
		this.titolo = titolo;
		this.data = validData(data);  
	    this.numeroPosti = checkPosti(numeroPosti);
	}
	public String getTitolo() {
		return titolo;
	}
	public LocalDate getData() {
		return data;
	}
	public int getNumeroPosti() {
		return numeroPosti;
	}
	public int getNumeroPostiPrenotati() {
		return numeroPostiPrenotati;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public void setData(String data) throws Exception {
		
		this.data = validData(data);
	}
    public void prenota() throws Exception {
    	  if (data.isBefore(LocalDate.now())) {
              throw new IllegalArgumentException("L' evento e' passato");
          }
        if (numeroPostiPrenotati >= numeroPosti) {
            throw new Exception("Non ci sono posti disponibili");
        }
        numeroPostiPrenotati++;
    }

    public void disdici() throws Exception {
    	  if (data.isBefore(LocalDate.now())) {
              throw new IllegalArgumentException("L' evento e' passato");
          }
        if (numeroPostiPrenotati <= 0) {
            throw new Exception("Non ci sono prenotazioni");
        }
        numeroPostiPrenotati--;
    }
    private LocalDate validData(String data) throws IllegalArgumentException {
        LocalDate dataLoc = LocalDate.parse(data,formatter);
        if (dataLoc.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data non può essere nel passato");
        }
        return dataLoc;
    }
    public int checkPosti(int posti) throws Exception {
    	 if (posti <= 0) {
	            throw new Exception("Il numero di posti totali deve essere positivo");
	        }
    	 return posti;
    }
   
    @Override
    public String toString() {
        return formatter.format(data) + " - " + titolo;
    }
}
