package aima.core.search.csp.projeto;

public class Horario {
	private double horas;
	private final String[] materia =  new String[2];
	
	public Horario(double horas) {
		this.horas = horas;
        this.materia[0] = null;
    }
	
	public void setMateria(int i, String materia) {
		this.materia[i] = materia;
	}
	//Retorna as horas restantes do horário
	public double getHoras() {
		return horas;
	}
	
	//retorna a pimeira matéria do horário
	public String getMateria() {
		return materia[0];
		
	}
	
	// Atribui a quantidade de horas
	// disponiveis no horario
	public void setHoras(double d) {
			this.horas = d;
	}
	
	//Retorna as materias
	// em formato de string
	public String toString() {
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
