package aima.core.search.csp.projeto;

/*
 * Classe de suporte que cria uma representação da posição 
 * da tabela de horário
 */

public class Horario {
	private double horas;//Tempo disponível no dia
	private final String[] materia =  new String[2];//Matérias que ocupam aquele horário
	
	public Horario(double horas) {
		this.horas = horas;
        this.materia[0] = null;
    }
	
	public void setMateria(int i, String materia) {
		this.materia[i] = materia;
	}
	
	public double getHoras() {
		return horas;
	}
	public String getMateria() {
		return materia[0];
		
	}
	public void setHoras(double d) {
			this.horas = d;
	}
	
	//To string que retorna as matérias daquele horário como String
	public String MateriaToString() {
	    String es = new String();
	    for (int i = 0; i< 2; i++) {
	    	if (materia[i] != null) {
	    		if (i != 0) {
	    			if (materia[1].equals(materia[0])) break;
	    			es += "|";
	    		}
	    		es += materia[i];
	    	}
	    }
	    return es;
	}

}
