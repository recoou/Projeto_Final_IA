package aima.core.search.csp.projeto;

import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;
import aima.core.search.csp.examples.NotEqualConstraint;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Classe principal, nela é criada o PSR, ou seja,
 * são definidas as variáveis, o domínio e as restrições para
 * cada variável.
 */

public class WeeklyMapCSP extends CSP<Variable, TuplaIntInt>{
	
	
	public WeeklyMapCSP(ArrayList<Tupla> blocos, Horario[][] MatrixHorario, ArrayList<Double> horasVagas){
		//For para inclusão de variáveis na lista de Var
		int contador = 0;
		for(int i = 0; i < blocos.size(); i++) {
			for(int j=0; j < blocos.get(i).getSecond(); j++)
				addVariable(new Variable(blocos.get(i).getFirst() + (i+1) + j));
			
			//Adicionando Restrições TableSpace e SameColumn
			for(int c=contador; c<getVariables().size()-1; c++) {
				Variable var1 = getVariables().get(c);
				Variable var2 = getVariables().get(c+1);
				addConstraint(new TableSpaceConstraint(var1, var2));
				addConstraint(new SameColumnConstraint(var1, var2));
				contador++;
			}
			
			contador++;
		}
		
		//Criação do dominio
		ArrayList<TuplaIntInt> dominio = new ArrayList<TuplaIntInt>();
		int dias;
		//Pré-processamento do sábado
		if (SabadoIsNeeded(blocos,horasVagas))  dias = 6;
			
		else  dias = 5;
		
		for(int i=0; i<dias; i++) {
			for(int j=0; j<10; j++) {
				if(MatrixHorario[j][i].getHoras() != 0) {//Verifica se tem horas vagas
					dominio.add(new TuplaIntInt((2*j),i));
					dominio.add(new TuplaIntInt((2*j) + 1,i));
				}
			}
		}
		
		Domain<TuplaIntInt> horarios = new Domain<>(dominio);
		
		//Definir o domínio das variáveis para ser igual ao definido
		for(Variable var : getVariables())
			setDomain(var, horarios);
		
		//Definição da Restrição NotEqual
		for (int i = 0; i < getVariables().size(); i++) {
			Variable var1 = getVariables().get(i);
			for (int j = i+1; j < getVariables().size(); j++) {
				Variable var2 = getVariables().get(j);
				addConstraint(new NotEqualConstraint<Variable, TuplaIntInt>(var1, var2));
			}
		}
	}
	
	//Método que faz um pré-processamento para saber se o sábado é necessário ou não
	private boolean SabadoIsNeeded(ArrayList<Tupla> blocos, ArrayList<Double> horasVagas) {
			
		boolean sabado = false;
		for(int i = 0; i < blocos.size();i++) {
			double hNecessaria = (double) blocos.get(i).getSecond()/2;
			for (int j = 0; j < horasVagas.size(); j++) {
				if (j == horasVagas.size()-1) {
					sabado = true;
					return sabado;
				}
				
				if (hNecessaria	 <= horasVagas.get(j)) {
					horasVagas.set(j, horasVagas.get(j) - hNecessaria);
					Collections.sort(horasVagas);
					break;
				}
			}
		}
		return sabado;
	}
}

	

