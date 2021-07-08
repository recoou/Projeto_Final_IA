package aima.core.search.csp.projeto;

/*
 * Restrição de que duas variáveis do mesmo bloco seguidas
 * devem
 */

import java.util.ArrayList;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;

public class TableSpaceConstraint implements Constraint<Variable, TuplaIntInt>{

	private Variable var1;
	private Variable var2;
	private List<Variable> scope;
	
	public TableSpaceConstraint(Variable var1, Variable var2) {
		this.var1 = var1;
		this.var2 = var2;
		scope = new ArrayList<Variable>(2);
		scope.add(var1);
		scope.add(var2);
	}
	
	@Override
	public List<Variable> getScope(){
		return this.scope;
	}
	
	@Override
	public boolean isSatisfiedWith(Assignment<Variable, TuplaIntInt> assignment) {
		TuplaIntInt value1 = assignment.getValue(var1);
		TuplaIntInt value2 = assignment.getValue(var2);
		if(value1 == null || value2 == null) {
			return true;
		}
		else {
			if(value2.getLinha() == value1.getLinha() + 1) {
				return true;
			}
			else {
				return false;
			}
		}
	}
}
