package aima.core.search.csp.projeto;

public class Horario {
	private final int horas;
	private final String[] materia =  new String[2];
	
	public Horario(int horas) {
        this.horas = horas;
    }
	
	public void setMateria(int i, String materia) {
		this.materia[i] = materia;
	}
	
	public int getHoras() {
		return horas;
	}
	
	public String getMateria0() {
		return this.materia[0];
	}
	
	public String getMateria1() {
		return this.materia[1];
	}

	public String MateriaToString() {
	    String es = new String();
	    for (int i = 0; i< 2; i++) {
	    	if (materia[i] != null) {
	    		if (i != 0) {
	    			es += " ";
	    		}
	    		es += materia[i];
	    		
	    	}
	    	
	    }
	            
	    System.out.println();
	    System.out.println("Suas matéria são: ");
	    return es;
	}

}
