package aima.core.search.csp.projeto;

import java.util.ArrayList;

import aima.core.util.datastructure.Pair;

public class CasoTeste2 {
	
	//matrix do Caso de teste 2
	// e a lista de variaveis.
	private final Horario[][] horario= new Horario[10][6];
	
	
	// Criação da matrix do Caso de teste 1
	// Foi posto o valor 0 no tempo dos
	// horarios com as matérias do caso de teste.
	// 1 para as livres.
	public CasoTeste2(){
		for (int i = 0; i<10;i++) {
			for(int j = 0;j<6;j++) {
				this.horario[i][j] = new Horario(1);
			}
		}
		// linha 1 2
		horario[0][0].setMateria(0, "COMP0409");
		horario[1][0].setMateria(0, "COMP0409");
		horario[0][2].setMateria(0, "COMP0409");
		horario[1][2].setMateria(0, "COMP0409");
		
		horario[0][0].setHoras(0);
		horario[1][0].setHoras(0);
		horario[0][2].setHoras(0);
		horario[1][2].setHoras(0);
		
		
		horario[0][4].setMateria(0, "COMP0438");
		horario[1][4].setMateria(0, "COMP0438");
		
		horario[0][4].setHoras(0);
		horario[1][4].setHoras(0);
		
		// linha 3 4
		horario[2][4].setMateria(0, "COMP0438");
		horario[3][4].setMateria(0, "COMP0438");
		
		horario[2][4].setHoras(0);
		horario[3][4].setHoras(0);
		
		
		horario[2][1].setMateria(0, "COMP0412");
		horario[3][1].setMateria(0, "COMP0412");
		horario[2][3].setMateria(0, "COMP0412");
		horario[3][3].setMateria(0, "COMP0412");
		
		horario[2][1].setHoras(0);
		horario[3][1].setHoras(0);
		horario[2][3].setHoras(0);
		horario[3][3].setHoras(0);
		
		horario[2][0].setMateria(0, Cores.ANSI_GREEN + "PIBIC###" + Cores.ANSI_RESET);
		horario[3][0].setMateria(0, Cores.ANSI_GREEN + "PIBIC###" + Cores.ANSI_RESET);
		horario[0][1].setMateria(0, Cores.ANSI_GREEN + "PIBIC###" + Cores.ANSI_RESET);
		horario[1][1].setMateria(0, Cores.ANSI_GREEN + "PIBIC###" + Cores.ANSI_RESET);
		horario[4][1].setMateria(0, Cores.ANSI_GREEN + "PIBIC###" + Cores.ANSI_RESET);
		horario[5][1].setMateria(0, Cores.ANSI_GREEN + "PIBIC###" + Cores.ANSI_RESET);
		horario[6][1].setMateria(0, Cores.ANSI_GREEN + "PIBIC###" + Cores.ANSI_RESET);
		horario[7][1].setMateria(0, Cores.ANSI_GREEN + "PIBIC###" + Cores.ANSI_RESET);
		horario[2][2].setMateria(0, Cores.ANSI_GREEN + "PIBIC###" + Cores.ANSI_RESET);
		horario[3][2].setMateria(0, Cores.ANSI_GREEN + "PIBIC###" + Cores.ANSI_RESET);
		horario[0][3].setMateria(0, Cores.ANSI_GREEN + "PIBIC###" + Cores.ANSI_RESET);
		horario[1][3].setMateria(0, Cores.ANSI_GREEN + "PIBIC###" + Cores.ANSI_RESET);
		horario[4][3].setMateria(0, Cores.ANSI_GREEN + "PIBIC###" + Cores.ANSI_RESET);
		horario[5][3].setMateria(0, Cores.ANSI_GREEN + "PIBIC###" + Cores.ANSI_RESET);
		horario[6][3].setMateria(0, Cores.ANSI_GREEN + "PIBIC###" + Cores.ANSI_RESET);
		horario[7][3].setMateria(0, Cores.ANSI_GREEN + "PIBIC###" + Cores.ANSI_RESET);
		horario[4][4].setMateria(0, Cores.ANSI_GREEN + "PIBIC###" + Cores.ANSI_RESET);
		horario[5][4].setMateria(0, Cores.ANSI_GREEN + "PIBIC###" + Cores.ANSI_RESET);
		horario[6][4].setMateria(0, Cores.ANSI_GREEN + "PIBIC###" + Cores.ANSI_RESET);
		horario[7][4].setMateria(0, Cores.ANSI_GREEN + "PIBIC###" + Cores.ANSI_RESET);
		
		horario[2][0].setHoras(0);
		horario[3][0].setHoras(0);
		horario[4][1].setHoras(0);
		horario[5][1].setHoras(0);
		horario[4][3].setHoras(0);
		horario[5][3].setHoras(0);
		horario[6][1].setHoras(0);
		horario[7][1].setHoras(0);
		horario[6][3].setHoras(0);
		horario[7][3].setHoras(0);
		horario[4][4].setHoras(0);
		horario[5][4].setHoras(0);
		horario[6][4].setHoras(0);
		horario[7][4].setHoras(0);
		
		horario[0][1].setHoras(0);
		horario[1][1].setHoras(0);
		horario[0][3].setHoras(0);
		horario[1][3].setHoras(0);
		horario[2][2].setHoras(0);
		horario[3][2].setHoras(0);
		
		
		// linha 5 6
		horario[4][0].setMateria(0, "COMP0408");
		horario[5][0].setMateria(0, "COMP0408");
		horario[4][2].setMateria(0, "COMP0408");
		horario[5][2].setMateria(0, "COMP0408");
		
		horario[4][0].setHoras(0);
		horario[5][0].setHoras(0);
		horario[4][2].setHoras(0);
		horario[5][2].setHoras(0);
		
		// linha 8 9
		horario[7][0].setMateria(0, "COMP0461");
		horario[8][0].setMateria(0, "COMP0461");
		horario[7][2].setMateria(0, "COMP0461");
		horario[8][2].setMateria(0, "COMP0461");
		
		horario[7][0].setHoras(0);
		horario[8][0].setHoras(0);
		horario[7][2].setHoras(0);
		horario[8][2].setHoras(0);
		
		
	}
	
	// Get da Matrix
	public Horario[][] getHorario() {
		return this.horario;
	}
	
	public void setMateria(int linha, int  coluna, String nome, int posicao) {
		horario[linha][coluna].setMateria(posicao, nome);
	}
	
	
	// Transforma a Matrix para string
	// Baseado na materia em cada horario
	public String toString()
	{
	    String es = new String();

	    for(int i = 0; i < 10; i++)
	        {
	            for(int j = 0; j < 6; j++)
	                {
	                    es += "[";
	                    es += horario[i][j].getHoras();
	                    es += "]";
	                }
	            es += '\n';
	        }
	    System.out.println();
	    System.out.println("Your matrix: ");
	    return es;
	}
	
	
	// Transforma a Matrix para string
	// Baseado na materia em cada horario
	public String resultadoString()
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
	}
	
	
	// Retorna as horas vagas de cada dia da semana
	// Segunda até Sábado
	private ArrayList<ArrayList<Double>> horasVagas() {
		ArrayList<ArrayList<Double>> vagas = new ArrayList<ArrayList<Double>>(6);
		double vago = 0;
		for(int i = 0; i < 6; i++)
        {
			ArrayList<Double> d1 = new ArrayList<Double>();
            for(int j = 0; j < 10; j++)
                {
            		
                    if (horario[j][i].getMateria() == null){
                    	vago ++;
                    }else {
                    	vago += horario[j][i].getHoras();
                    	if(vago > 0)    d1.add(vago);
                    	vago = 0;
                    }
                }
            if(vago > 0)    d1.add(vago);
            vago = 0;
            vagas.add(d1);
        }
		return vagas;
	}
	
	// Retorna um par com o total de horas vagas
	// Até a sexta feira e até ao Sabado
	public Pair<ArrayList<Double>, ArrayList<ArrayList<Double>>> horasTotaisSS() {
		ArrayList<Double> total = new ArrayList<Double>(2);
		
		ArrayList<ArrayList<Double>> horasV = this.horasVagas();
		double horas = 0;
		for (int i = 0; i < horasV.size(); i++) {
            for (int j = 0; j < horasV.get(i).size(); j++) {
               horas += horasV.get(i).get(j);
            }
            if (i >= 4){
            	total.add(horas);
            }
            
        }
		
		return new Pair<ArrayList<Double>, ArrayList<ArrayList<Double>>>(total,horasV);
	}
	
}
