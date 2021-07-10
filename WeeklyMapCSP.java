package aima.core.search.csp.projeto;

import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;
import aima.core.search.csp.examples.NotEqualConstraint;
import aima.core.util.datastructure.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeeklyMapCSP extends CSP<Variable, TuplaIntInt>{
	
	
	public WeeklyMapCSP(ArrayList<Tupla> blocos, Horario[][] MatrixHorario, Pair<ArrayList<Double>, ArrayList<ArrayList<Double>>> horasLivres) throws OutOfTimeException{
		//For para inclus�o de vari�veis na lista de Var
		int contador = 0;
		for(int i = 0; i < blocos.size(); i++) {
			for(int j=0; j < blocos.get(i).getSecond(); j++)
				addVariable(new Variable(blocos.get(i).getFirst() + (i+1) + j));
			
			//Adicionando Restri��es TableSpace e SameColumn
			for(int c=contador; c<getVariables().size()-1; c++) {
				Variable var1 = getVariables().get(c);
				Variable var2 = getVariables().get(c+1);
				addConstraint(new TableSpaceConstraint(var1, var2));
				addConstraint(new SameColumnConstraint(var1, var2));
				contador++;
			}
			
			contador++;
		}
		
		//Restri�ao do S�bado
		ArrayList<Double> horasVagas = new ArrayList<Double>();
		for (int i = 0; i <horasLivres.getSecond().size(); i ++) {
			horasVagas.addAll(horasLivres.getSecond().get(i));
		}
		
		Collections.sort(horasVagas);
			
		boolean sabado = false;
		for(int i = 0; i < blocos.size();i++) {
			for (int j = 0; j < horasVagas.size(); j++) {
				if (j == horasVagas.size()-1) {
					sabado = true;
					break;
				}
				double hNecessaria = blocos.get(i).getSecond()/2;
				if (hNecessaria	 <= horasVagas.get(j)) {
					horasVagas.set(j, horasVagas.get(j) - hNecessaria);
					Collections.sort(horasVagas);
					break;
				}
			}
			if (sabado) break;
			
		}		
		
		//Cria��o do dominio
		ArrayList<TuplaIntInt> dominio = new ArrayList<TuplaIntInt>();
		int dias;
		if (sabado)  dias = 6;
			
		else  dias = 5;
		
		for(int i=0; i<dias; i++) {
			for(int j=0; j<10; j++) {
				if(MatrixHorario[j][i].getHoras() != 0) {//Verifica se tem horas vagas
					dominio.add(new TuplaIntInt((2*j),i));
					dominio.add(new TuplaIntInt((2*j) + 1,i));
				}
			}
			
			//Restri��o do S�bado
			/*
			if(sabado) {
				if(getVariables().size() > (dominio.size() +20)){//Se o tempo pedido � grande demais..
					System.out.println("O PSR n�o possui solu��o alcan��vel");//D� erro com essa mensagem
					System.exit(1);
				}
			}
			 */
			if(i == 5) {
				if(getVariables().size() > (dominio.size() +20)){//Se o tempo pedido � grande demais..
					throw new OutOfTimeException("O tempo pedido � maior do que o dispon�vel");//D� erro com essa mensagem
				}
			}
		}
		
		Domain<TuplaIntInt> horarios = new Domain<>(dominio);
		
		//Setar o dom�nio das vari�veis para ser igual ao definido
		for(Variable var : getVariables())
			setDomain(var, horarios);
		
		//Setar as Restri��es
		
		//Restri��o de N�o deve ser igual
		for (int i = 0; i < getVariables().size(); i++) {
			Variable var1 = getVariables().get(i);
			for (int j = i+1; j < getVariables().size(); j++) {
				Variable var2 = getVariables().get(j);
				addConstraint(new NotEqualConstraint(var1, var2));
			}
		}
	}
}
	
