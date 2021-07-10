package aima.core.search.csp.projeto;

import java.util.ArrayList;
import java.util.Collections;


public class CasoTeste3 {

	//matrix do Caso de teste 3
	private final Horario[][] horario= new Horario[10][6];
	
	// Criação da matrix do Caso de teste 3
	// Foi posto o valor 0 no tempo dos
	// horarios com as matérias do caso de teste.
	// 1 para as livres.
	public CasoTeste3(){
		for (int i = 0; i<10;i++) {
			for(int j = 0;j<6;j++) {
				this.horario[i][j] = new Horario(1);//"--------"
			}
		}
		//linha 1 2
		horario[0][0].setMateria(0, "ELET0043");
		horario[1][0].setMateria(0, "ELET0043");
		
		horario[0][0].setHoras(0);
		horario[1][0].setHoras(0);
		
		horario[0][1].setMateria(0, "MATE0096");
		horario[1][1].setMateria(0, "MATE0096");
		horario[0][3].setMateria(0, "MATE0096");
		horario[1][3].setMateria(0, "MATE0096");
		
		horario[0][1].setHoras(0);
		horario[1][1].setHoras(0);
		horario[0][3].setHoras(0);
		horario[1][3].setHoras(0);
		
		horario[0][2].setMateria(0, "MATE0154");
		horario[1][2].setMateria(0, "MATE0154");
		horario[0][4].setMateria(0, "MATE0154");
		horario[1][4].setMateria(0, "MATE0154");
		
		horario[0][2].setHoras(0);
		horario[1][2].setHoras(0);
		horario[0][4].setHoras(0);
		horario[1][4].setHoras(0);
		
		//linha 3 4
		horario[2][0].setMateria(0, "ESTA0011");
		horario[3][0].setMateria(0, "ESTA0011");
		horario[2][2].setMateria(0, "ESTA0011");
		horario[3][2].setMateria(0, "ESTA0011");
		
		horario[2][0].setHoras(0);
		horario[3][0].setHoras(0);
		horario[2][2].setHoras(0);
		horario[3][2].setHoras(0);
		
		horario[2][1].setMateria(0, "COMP0409");
		horario[3][1].setMateria(0, "COMP0409");
		horario[2][3].setMateria(0, "COMP0409");
		horario[3][3].setMateria(0, "COMP0409");

		horario[2][1].setHoras(0);
		horario[3][1].setHoras(0);
		horario[2][3].setHoras(0);
		horario[3][3].setHoras(0);
		
		//linha 5 6
		horario[4][1].setMateria(0, "COMP0412");
		horario[5][1].setMateria(0, "COMP0412");
		horario[4][3].setMateria(0, "COMP0412");
		horario[5][3].setMateria(0, "COMP0412");
		
		horario[4][1].setHoras(0);
		horario[5][1].setHoras(0);
		horario[4][3].setHoras(0);
		horario[5][3].setHoras(0);
		
		horario[4][0].setMateria(0, "COMP0415");
		horario[5][0].setMateria(0, "COMP0415");
		horario[4][2].setMateria(0, "COMP0415");
		horario[5][2].setMateria(0, "COMP0415");
		
		horario[4][0].setHoras(0);
		horario[5][0].setHoras(0);
		horario[4][2].setHoras(0);
		horario[5][2].setHoras(0);
		
		horario[4][4].setMateria(0, "COMP0417");
		horario[5][4].setMateria(0, "COMP0417");
		
		horario[4][4].setHoras(0);
		horario[5][4].setHoras(0);
		
		//PALESTRA
		horario[6][4].setMateria(0, Cores.ANSI_GREEN + "PALESTRA" + Cores.ANSI_RESET);
		horario[7][4].setMateria(0, Cores.ANSI_GREEN + "PALESTRA" + Cores.ANSI_RESET);
		horario[6][1].setMateria(0, Cores.ANSI_GREEN + "PALESTRA" + Cores.ANSI_RESET);
		horario[7][1].setMateria(0, Cores.ANSI_GREEN + "PALESTRA" + Cores.ANSI_RESET);
		
		horario[6][1].setHoras(0);
		horario[7][1].setHoras(0);
		horario[6][4].setHoras(0);
		horario[7][4].setHoras(0);
		
		
	}
	
	// Get da Matrix
	public Horario[][] getHorario() {
		return this.horario;
	}
	
	public void setMateria(int linha, int  coluna, String nome, int posicao) {
		horario[linha][coluna].setMateria(posicao, nome);
	}
	
	// Transforma a Matrix para string
	// Baseado no tempo de cada horario
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
	// Baseado no tempo de cada horario
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
	    System.out.println("Seu Horário é: ");
	    return es;
	}
	
	// Retorna as horas vagas de cada dia da semana
	// Segunda até Sábado
	public ArrayList<Double> horasVagas() {
		ArrayList<Double> vagas = new ArrayList<Double>();
		double vago = 0;
		for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 10; j++)
                {
            		
                    if (horario[j][i].getMateria() == null){
                    	vago ++;
                    }else {
                    	vago += horario[j][i].getHoras();
                    	if(vago > 0)    vagas.add(vago);
                    	vago = 0;
                    }
                }
            if(vago > 0)    vagas.add(vago);
            vago = 0;
        }
		Collections.sort(vagas);
		return vagas;
	}
	
}
