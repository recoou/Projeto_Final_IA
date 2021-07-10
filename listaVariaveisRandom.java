package aima.core.search.csp.projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// Cria a lista de variaveis para cada caso
// de forma aleatoria quanto aos seus valores.
public class listaVariaveisRandom {
	
	// Lista das variaveis de cada Caso
	private List<Variavel> caso1;
	private List<Variavel> caso2;
	private List<Variavel> caso3;
	
	// Criação das Listas.
	public listaVariaveisRandom(){
		
		// Declaração dos valores possiveis para
		// Os blocos e o tempo total de horas estudadas.
		//double blocos[] = {0.5,1.0,1.5,2.0,2.5,3.0,3.5,4.0};
		int blocos[] = {1,2,3,4,5,6,7,8};
		double tempoTotal[] = {1.0,2.0,3.0,4.0};
		
		// Declaração das listas de variáveis.
		this.caso1 = new ArrayList<>();
		this.caso2 = new ArrayList<>();
		this.caso3 = new ArrayList<>();
		
		// Variaveis de cada caso de teste.
		String variavel1[] = {"COMP0455", "COMP0481", "COMP0408"};
		String variavel2[] = {"COMP0409", "COMP0438", "COMP0412", "COMP0408", "COMP0461"};
		String variavel3[] = {"COMP0417", "ELET0043", "MATE0096", "MATE0154", "ESTA0011", "COMP0409", "COMP0412", "COMP0415"};
		
		//Randomização da lista do caso 1.
		for (int i = 0; i < 3; i++) {
			Random generator = new Random();
			int randomIndex = generator.nextInt(tempoTotal.length);
			double tempo = tempoTotal[randomIndex];
			while(tempo > 0) {
				randomIndex = generator.nextInt((int)(tempo/0.5));
				tempo -= randomIndex;
				Variavel variavel = new Variavel(variavel1[i],blocos[randomIndex]) ;
				this.caso1.add(variavel);
			}
		}
		
		//Randomização da lista do caso 2.
		for (int i = 0; i < 5; i++) {
			Random generator = new Random();
			int randomIndex = generator.nextInt(tempoTotal.length);
			double tempo = tempoTotal[randomIndex]*2;
			//System.out.println(tempo + variavel2[i]);
			while(tempo > 0) {
				//System.out.println(tempo);
				randomIndex = generator.nextInt((int)(tempo/0.5));
				tempo -= randomIndex;
				Variavel variavel = new Variavel(variavel2[i],blocos[randomIndex]) ;
				this.caso2.add(variavel);
			}
		}
		
		//Randomização da lista do caso 3.
		for (int i = 0; i < 8; i++) {
			Random generator = new Random();
			int randomIndex = generator.nextInt(tempoTotal.length);
			double tempo = tempoTotal[randomIndex];
			while(tempo > 0) {
				randomIndex = generator.nextInt((int)(tempo/0.5));
				tempo -= randomIndex;
				Variavel variavel = new Variavel(variavel3[i],blocos[randomIndex]) ;
				this.caso3.add(variavel);
			}
		}


	}
	
	
	//Gets da lista de cada caso de teste.
	public List<Variavel> getCaso1() {
		return Collections.unmodifiableList(caso1);
	}
	public List<Variavel> getCaso2() {
		return Collections.unmodifiableList(caso2);
	}
	
	public List<Variavel> getCaso3() {
		return Collections.unmodifiableList(caso3);
	}

}
