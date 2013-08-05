
public class Battery extends EnergySource{
	private double Energy = 0;
	public Battery(double elec) {
		this.Energy = elec;
	}
	boolean empty(){
		if(this.Energy  <= 0){
			return true;
		}else{
			return false ;
		}
	}

}
