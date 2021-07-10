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
	
	public double getHoras() {
		return horas;
	}
	public String getMateria() {
		return materia[0];
		
	}
	public void setHoras(double d) {
			this.horas = d;
	}
	
	public String MateriaToString() {
	    String es = new String();
	    for (int i = 0; i< 2; i++) {
	    	if (materia[i] != null) {
	    		if (i != 0) {
	    			if (materia[i].substring(0,7) == materia[i-1].substring(0,7));
	    			es += "|";
	    		}
	    		es += materia[i];
	    	}
	    }
	    return es;
	}

}
