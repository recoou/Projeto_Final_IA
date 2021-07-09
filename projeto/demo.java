package aima.core.search.csp.projeto;

import java.util.ArrayList;
import java.util.List;
import aima.core.util.datastructure.Pair;


public class demo {
	
	public static void main(String[] args) {
		
		CasoTeste1 teste1 = new CasoTeste1();
		CasoTeste2 teste2 = new CasoTeste2();
		CasoTeste3 teste3 = new CasoTeste3();
		Horario[][] x = teste3.getHorario();
		//x[1][1].setMateria(1, "andre");
		//System.out.println(x[1][1].MateriaToString());
		
		System.out.println(teste3.resultadoString());
		System.out.println(teste2);
		Pair<ArrayList<Double>, ArrayList<ArrayList<Double>>> horasTotaiseHorasBlocosPorDia = teste2.horasTotaisSS();
		System.out.println(horasTotaiseHorasBlocosPorDia);
		double sexta = horasTotaiseHorasBlocosPorDia.getFirst().get(0);
		System.out.println(sexta);
		
	
		
		listaVariaveis lista = new listaVariaveis();
		
		List<Tupla> list1 = lista.getCaso1();
		List<Tupla> list2 = lista.getCaso2();
		List<Tupla> list3 = lista.getCaso3();
		
		
		String es = "";
		for (int i = 0; i < list1.size(); i++) {
			es += '[';
			es += list1.get(i).getFirst();
			es += '|';
			es += list1.get(i).getSecond();
			es += ']';
            }
		
		es += '\n';
		
		for (int i = 0; i < list2.size(); i++) {
			es += '[';
			es += list2.get(i).getFirst();
			es += '|';
			es += list2.get(i).getSecond();
			es += ']';
		    }
		
		es += '\n';
		
		for (int i = 0; i < list3.size(); i++) {
			es += '[';
			es += list3.get(i).getFirst();
			es += '|';
			es += list3.get(i).getSecond();
			es += ']';
		    }
		
		System.out.println(es);
		
		
	}
	
	
	
}
