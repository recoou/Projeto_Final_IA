package aima.core.search.csp.projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.CSP;
import aima.core.search.csp.CspListener;
import aima.core.search.csp.CspSolver;
import aima.core.search.csp.FlexibleBacktrackingSolver;
import aima.core.search.csp.MinConflictsSolver;
import aima.core.search.csp.Variable;
import java.util.NoSuchElementException;

public class demo {
	
	public static void main(String[] args) {
		CasoTeste1 teste1 = new CasoTeste1();
		CasoTeste2 teste2 = new CasoTeste2();
		CasoTeste3 teste3 = new CasoTeste3();
		
		ArrayList<Double> horasLivres1 = teste1.horasVagas();
		ArrayList<Double> horasLivres2 = teste2.horasVagas();
		ArrayList<Double> horasLivres3 = teste3.horasVagas();
		
		listaVariaveis lista = new listaVariaveis();
		
		ArrayList<Tupla> list1 =  lista.getCaso1();
		ArrayList<Tupla> list2 =  lista.getCaso2();
		ArrayList<Tupla> list3 =  lista.getCaso3();
		
		Horario[][] horario1 = teste1.getHorario();
		Horario[][] horario2 = teste2.getHorario();
		Horario[][] horario3 = teste3.getHorario();
		
		
		CSP<Variable, TuplaIntInt> csp = new WeeklyMapCSP(list1, horario1, horasLivres1);
		
		CspListener.StepCounter<Variable, TuplaIntInt> stepCounter = new CspListener.StepCounter<>();
		CspSolver<Variable, TuplaIntInt> solver;
		Optional<Assignment<Variable, TuplaIntInt>> solution;
		
		//solver = new MinConflictsSolver<>(1000);
		solver = new FlexibleBacktrackingSolver<Variable, TuplaIntInt>().setAll();
		//solver = new FlexibleBacktrackingSolver<Variable, TuplaIntInt>().set(CspHeuristics.mrvDeg());
		//solver = new FlexibleBacktrackingSolver<>();
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Map Coloring (Minimum Conflicts)");
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
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
		
		csp = new WeeklyMapCSP(list2, horario2, horasLivres2);
		
		//solver = new MinConflictsSolver<>(1000);
		solver = new FlexibleBacktrackingSolver<Variable, TuplaIntInt>().setAll();
		//solver = new FlexibleBacktrackingSolver<Variable, TuplaIntInt>().set(CspHeuristics.mrvDeg());
		//solver = new FlexibleBacktrackingSolver<>();
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Map Coloring (Minimum Conflicts)");
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
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
		
		csp = new WeeklyMapCSP(list3, horario3, horasLivres3);
		
		//solver = new MinConflictsSolver<>(1000);
		solver = new FlexibleBacktrackingSolver<Variable, TuplaIntInt>().setAll();
		//solver = new FlexibleBacktrackingSolver<Variable, TuplaIntInt>().set(CspHeuristics.mrvDeg());
		//solver = new FlexibleBacktrackingSolver<>();
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Map Coloring (Minimum Conflicts)");
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
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