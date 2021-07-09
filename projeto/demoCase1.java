package aima.core.search.csp.projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.CSP;
import aima.core.search.csp.CspListener;
import aima.core.search.csp.CspSolver;
import aima.core.search.csp.MinConflictsSolver;
import aima.core.search.csp.Variable;
import aima.core.util.datastructure.Pair;

public class demoCase1 {
	
	public static void main(String[] args) throws OutOfTimeException {
		CasoTeste1 teste1 = new CasoTeste1();
		CasoTeste2 teste2 = new CasoTeste2();
		CasoTeste3 teste3 = new CasoTeste3();
		
		Pair<ArrayList<Double>, ArrayList<ArrayList<Double>>> horasTotais = teste1.horasTotaisSS();
		
		double sexta = horasTotais.getFirst().get(0);
		
		listaVariaveis lista = new listaVariaveis();
		
		ArrayList<Tupla> list1 =  lista.getCaso1();
		ArrayList<Tupla> list2 =  lista.getCaso2();
		ArrayList<Tupla> list3 =  lista.getCaso3();
		
		
		CSP<Variable, TuplaIntInt> csp = new WeeklyMapCSP(list1, teste1.getHorario());
		CspListener.StepCounter<Variable, TuplaIntInt> stepCounter = new CspListener.StepCounter<>();
		CspSolver<Variable, TuplaIntInt> solver;
		Optional<Assignment<Variable, TuplaIntInt>> solution;
		
		solver = new MinConflictsSolver<>(2000);
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Map Coloring (Minimum Conflicts)");
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		String solucao = solution.get().toString();
		
		System.out.println(solucao);
		
		System.out.println(stepCounter.getResults() + "\n");

	}
}
/*
package aima.gui.demo.search;

import aima.core.search.csp.*;
import aima.core.search.csp.examples.MapCSP;

import java.util.Optional;

public class MapColoringCspDemo {
	public static void main(String[] args) {
		
		solver = new FlexibleBacktrackingSolver<Variable, String>().setAll();
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Map Coloring (Backtracking + MRV & DEG + LCV + AC3)");
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");

		solver = new FlexibleBacktrackingSolver<Variable, String>().set(CspHeuristics.mrvDeg());
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Map Coloring (Backtracking + MRV & DEG)");
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");
		
		solver = new FlexibleBacktrackingSolver<>();
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Map Coloring (Backtracking)");
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");
	}
}
*/
