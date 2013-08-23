package ex03_06;

public class Battery extends EnergySource{
	private double energy = 0;
	public Battery(double elec) {
		this.energy = elec;
	}
	boolean empty(){
		if(this.energy  <= 0){
			return true;
		}else{
			return false ;
		}
	}

}
