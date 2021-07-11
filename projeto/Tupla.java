package aima.core.search.csp.projeto;

/*
 * Classe de Suporte que guarda dois valores
 * sendo o primeiro uma String e o segundo um inteiro
 */

public class Tupla {
	private String first;
	private int second;
	
	public Tupla(String x, int y) {
		this.first = x;
		this.second = y;
	}
	
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	
	
}