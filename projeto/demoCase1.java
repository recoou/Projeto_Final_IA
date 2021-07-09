package aima.core.search.csp.projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.CSP;
import aima.core.search.csp.CspHeuristics;
import aima.core.search.csp.CspListener;
import aima.core.search.csp.CspSolver;
import aima.core.search.csp.FlexibleBacktrackingSolver;
import aima.core.search.csp.MinConflictsSolver;
import aima.core.search.csp.Variable;
import aima.core.util.datastructure.Pair;

public class demoCase1 {
	
	public static void main(String[] args) throws OutOfTimeException {
		CasoTeste1 teste1 = new CasoTeste1();
		CasoTeste2 teste2 = new CasoTeste2();
		CasoTeste3 teste3 = new CasoTeste3();
		
		Pair<ArrayList<Double>, ArrayList<ArrayList<Double>>> horasTotais = teste1.horasTotaisSS();
		
		listaVariaveis lista = new listaVariaveis();
		
		ArrayList<Tupla> list1 =  lista.getCaso1();
		ArrayList<Tupla> list2 =  lista.getCaso2();
		ArrayList<Tupla> list3 =  lista.getCaso3();
		
		Horario[][] horario1 = teste1.getHorario();
		
		
		CSP<Variable, TuplaIntInt> csp = new WeeklyMapCSP(list1, teste1.getHorario());
		CspListener.StepCounter<Variable, TuplaIntInt> stepCounter = new CspListener.StepCounter<>();
		CspSolver<Variable, TuplaIntInt> solver;
		Optional<Assignment<Variable, TuplaIntInt>> solution;
		
		solver = new FlexibleBacktrackingSolver<Variable, TuplaIntInt>().setAll();
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Map Coloring (Minimum Conflicts)");
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		Assignment<Variable, TuplaIntInt> solucao = solution.get();
		
		List<Variable> variaveis = solucao.getVariables();
		for(Variable var : variaveis) {
			int linha = solucao.getValue(var).getLinha();
			int coluna = solucao.getValue(var).getColuna();
			teste1.setMateria((int)linha/2, coluna, Cores.ANSI_PURPLE + var.getName().substring(0, 8) + Cores.ANSI_RESET, linha%2);
			//horario1[(int)linha/2][coluna].setMateria(linha%2, var.getName());
			}
				
		
		System.out.println(stepCounter.getResults() + "\n");
		
		
		System.out.println(teste1.resultadoString());
		//System.out.println(resultadoString(horario1));

	}


public static String resultadoString(Horario[][] horario)
{
    String es = new String();
    ArrayList<String> dia_semana = new ArrayList<String>();
    es += "     [ Segunda][  Terca ][ Quarta ][ Quinta ][ Sexta  ][ Sabado ]\n";
    dia_semana.add("13:00");
    dia_semana.add("14:00");
    dia_semana.add("15:00");
    dia_semana.add("16:00");
    dia_semana.add("17:00");
    dia_semana.add("18:00");
    dia_semana.add("19:00");
    dia_semana.add("20:00");
    dia_semana.add("21:00");
    dia_semana.add("22:00");

    for(int i = 0; i < 10; i++)
        {
    		es += dia_semana.get(i);
            for(int j = 0; j < 6; j++)
                {
                    es += "[";
                    if (horario[i][j].getMateria() == null){
                    	es +="--------";
                    }else {
                    	es += horario[i][j].MateriaToString();
                    }
                    es += "]";
                }
            es += '\n';
        }
    System.out.println();
    System.out.println("Your matrix: ");
    return es;
}}
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
