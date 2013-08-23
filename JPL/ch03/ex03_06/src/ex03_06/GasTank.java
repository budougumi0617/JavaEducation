package ex03_06;

public class GasTank extends EnergySource{
	private double energy = 0;
	public GasTank(double gass) {
		this.energy = gass;
	}
	boolean empty(){
		if(this.energy  <= 0){
			return true;
		}else{
			return false ;
		}
	}

}
