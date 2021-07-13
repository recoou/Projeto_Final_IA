package aima.core.search.csp.projeto;

import java.util.ArrayList;
import java.util.Optional;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.CSP;
import aima.core.search.csp.Variable;

import aima.core.search.csp.CspHeuristics;
import aima.core.search.csp.CspListener;
import aima.core.search.csp.CspSolver;
import aima.core.search.csp.FlexibleBacktrackingSolver;
import aima.core.search.csp.MinConflictsSolver;
import aima.core.search.csp.inference.AC3Strategy;
import aima.core.search.csp.inference.ForwardCheckingStrategy;
/*
import aima.core.search.csp.solver.inference.*;
import aima.core.search.csp.solver.*;
*/

/*
 * Classe de Suporte utilizada para comparar os algoritmos de solução
 * para o caso 2 do projeto definido pelo professor.
 */

public class TestDemo2 {
	
	public static void main(String[] args) {
		CasoTeste2 teste2 = new CasoTeste2();
		
		ArrayList<Double> horasLivres = teste2.horasVagas();
		
		ListaBlocos lista = new ListaBlocos();
		
		ArrayList<Tupla> list2 =  lista.getCaso2();
		
		Horario[][] horario = teste2.getHorario();
		
		
		CSP<Variable, TuplaIntInt> csp = new WeeklyMapCSP(list2, horario, horasLivres);
		
		CspListener.StepCounter<Variable, TuplaIntInt> stepCounter = new CspListener.StepCounter<>();
		CspSolver<Variable, TuplaIntInt> solver;
		Optional<Assignment<Variable, TuplaIntInt>> solution;
		
		solver = new MinConflictsSolver<>(1000);
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("WeeklyMapCSP (Minimum Conflicts)");
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");
		
		solver = new FlexibleBacktrackingSolver<>();
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("WeeklyMapCSP (Backtracking)");
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");
		
		solver = new FlexibleBacktrackingSolver<Variable, TuplaIntInt>().set(new AC3Strategy<>());
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("WeeklyMapCSP (Backtracking) AC3");
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");
		
		solver = new FlexibleBacktrackingSolver<Variable, TuplaIntInt>().set(new AC3Strategy<>()).set(CspHeuristics.lcv());
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("WeeklyMapCSP (Backtracking) AC3 + Lcv");
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");
		
		solver = new FlexibleBacktrackingSolver<Variable, TuplaIntInt>().set(new AC3Strategy<>()).set(CspHeuristics.deg());
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("WeeklyMapCSP (Backtracking) AC3 + DEG");
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");
		
		solver = new FlexibleBacktrackingSolver<Variable, TuplaIntInt>().set(new AC3Strategy<>()).set(CspHeuristics.mrv());
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("WeeklyMapCSP (Backtracking) AC3 + MRV");
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");
		
		//Algoritmo selecionado para a Demo final
		solver = new FlexibleBacktrackingSolver<Variable, TuplaIntInt>().set(new AC3Strategy<>()).set(CspHeuristics.mrv());
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("WeeklyMapCSP (Backtracking) AC3 + MRV + Lcv");
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");
		
		solver = new FlexibleBacktrackingSolver<Variable, TuplaIntInt>().set(new ForwardCheckingStrategy<>());
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("WeeklyMapCSP (Backtracking) FowardCheck");
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");
		
		solver = new FlexibleBacktrackingSolver<Variable, TuplaIntInt>().set(new ForwardCheckingStrategy<>()).set(CspHeuristics.lcv());
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("WeeklyMapCSP (Backtracking) FowardCheck + Lcv");
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");
		
		solver = new FlexibleBacktrackingSolver<Variable, TuplaIntInt>().set(new ForwardCheckingStrategy<>()).set(CspHeuristics.mrv());
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("WeeklyMapCSP (Backtracking) FowardCheck + MRV");
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");
		
		
	}

}
