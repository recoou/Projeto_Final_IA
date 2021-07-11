package aima.core.search.csp.projeto;

/*
 * Classe de Suporte que guarda dois valores
 * sendo tanto o primeiro como o segundo inteiros
 */

public class TuplaIntInt {
	private final int linha;
	private final int coluna;
	
	public TuplaIntInt(int x, int y){
		this.linha = x;
		this.coluna = y;
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}
	
	
}
