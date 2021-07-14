package aima.core.search.csp.projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.CSP;
import aima.core.search.csp.Variable;
import java.util.NoSuchElementException;
import aima.core.search.csp.solver.inference.*;
import aima.core.search.csp.solver.*;

/*
 * Classe Pricipal que simula os 3 casos definidos pelo projeto do 
 * professor. Aqui é utilizado o Backtracking junto das heurísticas
 * de AC-3 consistente, MRV e Lcv para solucionar o PSR modelado.
 * A classe também cuida de printar na tela a tabela resultante
 * de cada caso.
 */

public class demo {
	
	public static void main(String[] args) {
		//Criação dos casos de teste e das suas entradas para o WeeklyMapCSP:
		CasoTeste1 teste1 = new CasoTeste1();
		CasoTeste2 teste2 = new CasoTeste2();
		CasoTeste3 teste3 = new CasoTeste3();
		
		ArrayList<Double> horasLivres1 = teste1.horasVagas();
		ArrayList<Double> horasLivres2 = teste2.horasVagas();
		ArrayList<Double> horasLivres3 = teste3.horasVagas();
		
		ListaBlocos lista = new ListaBlocos();
		
		ArrayList<Tupla> list1 =  lista.getCaso1();
		ArrayList<Tupla> list2 =  lista.getCaso2();
		ArrayList<Tupla> list3 =  lista.getCaso3();
		
		Horario[][] horario1 = teste1.getHorario();
		Horario[][] horario2 = teste2.getHorario();
		Horario[][] horario3 = teste3.getHorario();
		
		//Caso 1
		CSP<Variable, TuplaIntInt> csp = new WeeklyMapCSP(list1, horario1, horasLivres1);
		
		CspListener.StepCounter<Variable, TuplaIntInt> stepCounter = new CspListener.StepCounter<>();
		CspSolver<Variable, TuplaIntInt> solver;
		Optional<Assignment<Variable, TuplaIntInt>> solution;
		
		solver = new FlexibleBacktrackingSolver<Variable, TuplaIntInt>().set(new AC3Strategy<>()).set(CspHeuristics.mrv()).set(CspHeuristics.lcv());
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Caso 1");
		solution = solver.solve(csp);
		System.out.println(stepCounter.getResults() + "\n");
		
		try {
			Assignment<Variable, TuplaIntInt> solucao = solution.get();
			List<Variable> variaveis = solucao.getVariables();
			for(Variable var : variaveis) {
				int linha = solucao.getValue(var).getLinha();
				int coluna = solucao.getValue(var).getColuna();
				teste1.setMateria((int)linha/2, coluna, Cores.ANSI_BLUE + var.getName().substring(0, 8) + Cores.ANSI_RESET, linha%2);
				}
			System.out.println(teste1);
		}
		catch(NoSuchElementException e){
			System.out.println("O PSR não possui solução \n");
		}
		
		
		//Caso 2
		csp = new WeeklyMapCSP(list2, horario2, horasLivres2);
		
		solver = new FlexibleBacktrackingSolver<Variable, TuplaIntInt>().set(new AC3Strategy<>()).set(CspHeuristics.lcv()).set(CspHeuristics.mrv());
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Caso 2");
		solution = solver.solve(csp);
		System.out.println(stepCounter.getResults() + "\n");
		
		try {
			Assignment<Variable, TuplaIntInt> solucao = solution.get();
			List<Variable> variaveis = solucao.getVariables();
			for(Variable var : variaveis) {
				int linha = solucao.getValue(var).getLinha();
				int coluna = solucao.getValue(var).getColuna();
				teste2.setMateria((int)linha/2, coluna, Cores.ANSI_BLUE + var.getName().substring(0, 8) + Cores.ANSI_RESET, linha%2);
				}
			System.out.println(teste2);
		}
		catch(NoSuchElementException e){
			System.out.println("O PSR não possui solução \n");
		}
		
		
		//Caso 3
		csp = new WeeklyMapCSP(list3, horario3, horasLivres3);
		
		solver = new FlexibleBacktrackingSolver<Variable, TuplaIntInt>().set(new AC3Strategy<>()).set(CspHeuristics.mrv()).set(CspHeuristics.lcv());
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Caso 3");
		solution = solver.solve(csp);
		System.out.println(stepCounter.getResults() + "\n");
		
		try {
			Assignment<Variable, TuplaIntInt> solucao = solution.get();
			List<Variable> variaveis = solucao.getVariables();
			for(Variable var : variaveis) {
				int linha = solucao.getValue(var).getLinha();
				int coluna = solucao.getValue(var).getColuna();
				teste3.setMateria((int)linha/2, coluna, Cores.ANSI_BLUE + var.getName().substring(0, 8) + Cores.ANSI_RESET, linha%2);
				}
			System.out.println(teste3);
		}
		catch(NoSuchElementException e){
			System.out.println("O PSR não possui solução \n");
		}
	}
}