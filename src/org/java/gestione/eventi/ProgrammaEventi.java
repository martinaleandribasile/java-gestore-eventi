package org.java.gestione.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProgrammaEventi {
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private String titolo;
	List<Evento> listaEventi= null;
	public ProgrammaEventi(String titolo) {
		super();
		this.titolo = titolo;
		this.listaEventi = new ArrayList<>();
	}
	
	public void addEvent (Evento evento) {
		this.listaEventi.add(evento);
	}
	public List<Evento> getEventiInData(String data) {
		LocalDate dataLoc = LocalDate.parse(data,formatter);
		List<Evento> checkEventiData = new ArrayList<Evento>();
		for (Evento evento : this.listaEventi) {
			if (evento.getData().equals(dataLoc)) {
				checkEventiData.add(evento);
			}
		}
		return checkEventiData;
	}
	public int getEventiSize() {
		return this.listaEventi.size();
	}
	public void clearEventList() {
		this.listaEventi.clear();
	}

	
	public String eventsForData() {
		Collections.sort(this.listaEventi, new Comparator<Evento>() {
			public int compare(Evento e1, Evento e2) {
				return e1.getData().compareTo(e2.getData());
			}
		});
	    StringBuilder sb = new StringBuilder();
	    sb.append(titolo + "\n");
	    for (Evento evento : listaEventi) {
	      sb.append(evento.getData() + " - " + evento.getTitolo()+ "\n");
	    }
	    return sb.toString();
	  }

	@Override
	public String toString() {
		return "ProgrammaEventi [titolo=" + titolo + ", listaEventi=" + listaEventi + "]";
	}


}
