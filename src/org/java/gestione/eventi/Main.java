package org.java.gestione.eventi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Concerto newConcerto= new Concerto("BritneyBitch", "05/09/2025", 135, "20:00","345.67");
		Concerto newConcerto1= new Concerto("LadyGaga Fuck Off", "10/04/2023", 345, "22:00","434.70");
		System.out.println(newConcerto);
		System.out.println(newConcerto1);
		Evento newEvento = null;
		String titolo, data;
		int postiEvento=0;
		Scanner s = new Scanner(System.in);
		System.out.println("Benvenuto");
	    System.out.println("Inserisci i dati del tuo evento:");
	    
	    System.out.println("Inserisci il titolo dell'evento");
        titolo= s.nextLine();
        System.out.println("Inserisci la data del tuo evento in formato dd/mm/yyyy : ");
        data = s.nextLine();
       do {
    	   try {  
               System.out.println("Inserisci i posti a disposizione per questo evento:");
               postiEvento = Integer.parseInt(s.nextLine());
           } catch (IllegalArgumentException e) {
               System.out.println("Inserito valore non valido per il campo \"posti\"");
           }
       }while(postiEvento==0);
        
        newEvento= new Evento(titolo, data, postiEvento);
        
        String scelta = "";
		do {
        	System.out.println("Digita: 1 -> prenota posto, 2-> disdici posto, 3-> uscire");
        	scelta=s.nextLine();
        	switch (scelta) {
			case "1":
				String sceltaPosti="";
				do {
					try {
						System.out.println("Posti ancora disponibili " + (newEvento.getNumeroPosti()- newEvento.getNumeroPostiPrenotati()));
						System.out.println("quanti posti vuoi prenotare?");
						sceltaPosti=s.nextLine();
						if(Integer.parseInt(sceltaPosti)>1) {
							
								try {
									for( int i =1; i<= Integer.parseInt(sceltaPosti); i++) {
									newEvento.prenota();
								}} catch (Exception e) {
									System.out.println(e.getMessage());
								}
								
							}
						else if(Integer.parseInt(sceltaPosti)==1)newEvento.prenota();
						else if(Integer.parseInt(sceltaPosti)<1) {
							System.out.println("Input non valido!");
						}
					} catch (Exception e) {
						sceltaPosti="0";
						System.out.println("Inserimento non valido");
						
					}
				}while(Integer.parseInt(sceltaPosti)<1);
				System.out.println("Posti prenotati " + newEvento.getNumeroPostiPrenotati());
				break;
			case "2":
				String sceltaPostidisdetta="";
				do {
					try {
						System.out.println("quanti posti vuoi disdire?");
						sceltaPostidisdetta=s.nextLine();
						if(Integer.parseInt(sceltaPostidisdetta)>1) {
							try {
								for( int i =1; i<= Integer.parseInt(sceltaPostidisdetta); i++) {
								newEvento.disdici();									
							}}catch (Exception e) {									
								System.out.println(e.getMessage());
								}
							System.out.println("Posti ancora disponibili " + (newEvento.getNumeroPosti()- newEvento.getNumeroPostiPrenotati()));
							}
						else if(Integer.parseInt(sceltaPostidisdetta)==1)newEvento.disdici();
						else if(Integer.parseInt(sceltaPostidisdetta)<1) {
							System.out.println("Input non valido!");
						}
					} catch (Exception e) {
						scelta="0";
						System.out.println("Inserimento non valido");
						
					}
				}while(Integer.parseInt(sceltaPostidisdetta)<1);
				break;
			case "3":
				System.out.println("Grazie e Arrivederci");
				break;

			default:
				System.out.println("Input non valido , ritentare");
				break;
			}
        }while(!scelta.equals("3"));
	s.close();
	
	}

}
