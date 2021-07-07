package aima.core.search.csp.projeto;

import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;

import java.util.ArrayList;
import java.util.List;

public class WeeklyMapCSP extends CSP<Variable, TuplaIntInt>{
	
	
	public WeeklyMapCSP(ArrayList<Tupla> blocos, Horário[][] MatrixHorario) {
		for(int i = 0; i < blocos.size(); i++) {
			for(int j=0; j < blocos.get(i).getSecond(); j++)
				addVariable(new Variable(blocos.get(i).getFirst() + (i+1) + j));
		}
		
		ArrayList<TuplaIntInt> dominio = new ArrayList<TuplaIntInt>();
		
		for(int i=0; i<6; i++) {
			for(int j=0; j<10; j++) {
				Horario amostra = new Horario();
				MatrixHorario[j][i] = amostra;
				if(amostra.getMateria0 == "-----") {
					dominio.add(new TuplaIntInt((2*j),i));
					dominio.add(new TuplaIntInt((2*j) + 1,i));
				}
			}
		}
		
		Domain<TuplaIntInt> horarios = new Domain<>(dominio);
		
		for(Variable var : getVariables())
			setDomain(var, horarios);
		
		
	}
}

