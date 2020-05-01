package Exercice3.src;

import tools.Tools;

public  class SpaceSleep implements Command  {

	
	String temps;
	
	
	public SpaceSleep(String temps) {
		super();
		this.temps = temps;
		
	}

	
	@Override
	public void run() {
		Tools.sleep(Integer.parseInt(temps));
	}
	
	
	
}
