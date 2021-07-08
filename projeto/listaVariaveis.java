package aima.core.search.csp.projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Cria a lista de variaveis para cada caso
//com valores fixos.
public class listaVariaveis {
	
	// Lista das variaveis de cada Caso
	private List<Variavel> caso1;
	private List<Variavel> caso2;
	private List<Variavel> caso3;
	
	// Criação das Listas.
	public listaVariaveis(){
		
		// Declaração dos valores possiveis para
		// Os blocos e o tempo total de horas estudadas.
		//double blocos[] = {0.5,1.0,1.5,2.0,2.5,3.0,3.5,4.0};
		int blocos[] = {1,2,3,4,5,6,7,8};
		
		// Declaração das listas de variáveis.
		this.caso1 = new ArrayList<>();
		this.caso2 = new ArrayList<>();
		this.caso3 = new ArrayList<>();
		
		// Variaveis de cada caso de teste.
		String variavel1[] = {"COMP0455", "COMP0481", "COMP0408"};
		String variavel2[] = {"COMP0409", "COMP0438", "COMP0412", "COMP0408", "COMP0461"};
		String variavel3[] = {"COMP0417", "ELET0043", "MATE0096", "MATE0154", "ESTA0011", "COMP0409", "COMP0412", "COMP0415"};
		
		//Lista das variaveis 1
		Variavel variavel = new Variavel(variavel1[0],blocos[2]);
		this.caso1.add(variavel);
		variavel = new Variavel(variavel1[0],blocos[0]);
		this.caso1.add(variavel);
		variavel = new Variavel(variavel1[1],blocos[2]);
		this.caso1.add(variavel);
		variavel = new Variavel(variavel1[1],blocos[5]);
		this.caso1.add(variavel);
		variavel = new Variavel(variavel1[2],blocos[1]);
		this.caso1.add(variavel);
		variavel = new Variavel(variavel1[2],blocos[3]);
		this.caso1.add(variavel);
		
		
		//Lista das variaveis 2
		
		variavel = new Variavel(variavel2[0],blocos[0]);
		this.caso2.add(variavel);
		variavel = new Variavel(variavel2[0],blocos[2]);
		this.caso2.add(variavel);
		variavel = new Variavel(variavel2[1],blocos[1]);
		this.caso2.add(variavel);
		variavel = new Variavel(variavel2[1],blocos[0]);
		this.caso2.add(variavel);
		variavel = new Variavel(variavel2[2],blocos[2]);
		this.caso2.add(variavel);
		variavel = new Variavel(variavel2[3],blocos[0]);
		this.caso2.add(variavel);
		variavel = new Variavel(variavel2[4],blocos[1]);
		this.caso2.add(variavel);
		
		//Lista das variaveis 3
		variavel = new Variavel(variavel3[0],blocos[4]);
		this.caso3.add(variavel);
		variavel = new Variavel(variavel3[0],blocos[2]);
		this.caso3.add(variavel);
		variavel = new Variavel(variavel3[1],blocos[3]);
		this.caso3.add(variavel);
		variavel = new Variavel(variavel3[1],blocos[0]);
		this.caso3.add(variavel);
		variavel = new Variavel(variavel3[2],blocos[1]);
		this.caso3.add(variavel);
		variavel = new Variavel(variavel3[3],blocos[0]);
		this.caso3.add(variavel);
		variavel = new Variavel(variavel3[4],blocos[4]);
		this.caso3.add(variavel);
		variavel = new Variavel(variavel3[4],blocos[1]);
		this.caso3.add(variavel);
		variavel = new Variavel(variavel3[5],blocos[2]);
		this.caso3.add(variavel);
		variavel = new Variavel(variavel3[6],blocos[0]);
		this.caso3.add(variavel);
		variavel = new Variavel(variavel3[6],blocos[1]);
		this.caso3.add(variavel);
		variavel = new Variavel(variavel3[7],blocos[2]);
		this.caso3.add(variavel);
		variavel = new Variavel(variavel3[7],blocos[1]);
		this.caso3.add(variavel);
		


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
