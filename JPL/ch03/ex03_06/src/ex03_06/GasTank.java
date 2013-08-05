package ex03_06;

public class GasTank extends EnergySource{
	private double Energy = 0;
	public GasTank(double gass) {
		this.Energy = gass;
	}
	boolean empty(){
		if(this.Energy  <= 0){
			return true;
		}else{
			return false ;
		}
	}

}
