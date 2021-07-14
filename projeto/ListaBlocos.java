package aima.core.search.csp.projeto;

import java.util.ArrayList;


/*
 * Classe de Suporte que cria 
 * a lista de variaveis para cada caso
 * com valores fixos.
 */
public class ListaBlocos {
	
	// Lista das variaveis de cada Caso
	private ArrayList<Tupla> caso1;
	private ArrayList<Tupla> caso2;
	private ArrayList<Tupla> caso3;
	
	// Criação das Listas.
	public ListaBlocos(){
		/*
		 * Declaração dos valores possiveis para
		 * Os blocos e o tempo total de horas estudadas.
		 * double blocos[] = {0.5,1.0,1.5,2.0,2.5,3.0,3.5,4.0}; 
		 */		
		int blocos[] = {1,2,3,4,5,6,7,8};
		
		// Declaração das listas de variáveis.
		this.caso1 = new ArrayList<>();
		this.caso2 = new ArrayList<>();
		this.caso3 = new ArrayList<>();
		
		// Variaveis de cada caso de teste.
		String Tupla1[] = {"COMP0455", "COMP0481", "COMP0408"};
		String Tupla2[] = {"COMP0409", "COMP0438", "COMP0412", "COMP0408", "COMP0461"};
		String Tupla3[] = {"COMP0417", "ELET0043", "MATE0096", "MATE0154", "ESTA0011", "COMP0409", "COMP0412", "COMP0415"};
		
		//Lista das variaveis 1
		Tupla Tupla = new Tupla(Tupla1[0],blocos[2]);
		this.caso1.add(Tupla);
		Tupla = new Tupla(Tupla1[0],blocos[0]);
		this.caso1.add(Tupla);
		Tupla = new Tupla(Tupla1[1],blocos[2]);
		this.caso1.add(Tupla);
		Tupla = new Tupla(Tupla1[1],blocos[5]);
		this.caso1.add(Tupla);
		Tupla = new Tupla(Tupla1[2],blocos[1]);
		this.caso1.add(Tupla);
		Tupla = new Tupla(Tupla1[2],blocos[3]);
		this.caso1.add(Tupla);
		
		
		//Lista das variaveis 2
		
		Tupla = new Tupla(Tupla2[0],blocos[0]);
		this.caso2.add(Tupla);
		Tupla = new Tupla(Tupla2[0],blocos[2]);
		this.caso2.add(Tupla);
		Tupla = new Tupla(Tupla2[1],blocos[1]);
		this.caso2.add(Tupla);
		Tupla = new Tupla(Tupla2[1],blocos[0]);
		this.caso2.add(Tupla);
		Tupla = new Tupla(Tupla2[2],blocos[2]);
		this.caso2.add(Tupla);
		Tupla = new Tupla(Tupla2[3],blocos[0]);
		this.caso2.add(Tupla);
		Tupla = new Tupla(Tupla2[4],blocos[1]);
		this.caso2.add(Tupla);
		
		//Lista das variaveis 3
		Tupla = new Tupla(Tupla3[0],blocos[4]);
		this.caso3.add(Tupla);
		Tupla = new Tupla(Tupla3[0],blocos[2]);
		this.caso3.add(Tupla);
		Tupla = new Tupla(Tupla3[1],blocos[3]);
		this.caso3.add(Tupla);
		Tupla = new Tupla(Tupla3[1],blocos[0]);
		this.caso3.add(Tupla);
		Tupla = new Tupla(Tupla3[2],blocos[1]);
		this.caso3.add(Tupla);
		Tupla = new Tupla(Tupla3[3],blocos[0]);
		this.caso3.add(Tupla);
		Tupla = new Tupla(Tupla3[4],blocos[4]);
		this.caso3.add(Tupla);
		Tupla = new Tupla(Tupla3[4],blocos[1]);
		this.caso3.add(Tupla);
		Tupla = new Tupla(Tupla3[5],blocos[2]);
		this.caso3.add(Tupla);
		Tupla = new Tupla(Tupla3[6],blocos[0]);
		this.caso3.add(Tupla);
		Tupla = new Tupla(Tupla3[6],blocos[1]);
		this.caso3.add(Tupla);
		Tupla = new Tupla(Tupla3[7],blocos[2]);
		this.caso3.add(Tupla);
		Tupla = new Tupla(Tupla3[7],blocos[5]);
		this.caso3.add(Tupla);
		


	}
	
	
	//Gets da lista de cada caso de teste.
	public ArrayList<Tupla> getCaso1() {
		return caso1;
	}
	public ArrayList<Tupla> getCaso2() {
		return caso2;
	}
	
	public ArrayList<Tupla> getCaso3() {
		return caso3;
	}

}
