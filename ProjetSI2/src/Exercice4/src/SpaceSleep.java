package Exercice4.src;

import jfkbits.ExprList;
import tools.Tools;

public  class SpaceSleep implements Command  {

	
	@Override
	public void run(Object receiver, ExprList method) {
		
		Tools.sleep(Integer.parseInt(method.get(2).getValue()));
		
	}
	
}
