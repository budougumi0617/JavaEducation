
public class Battery implements EnergySource{
	private double Energy = 0;
	public Battery(double elec) {
		this.Energy = elec;
	}
	public boolean empty(){
		if(this.Energy  <= 0){
			return true;
		}else{
			return false ;
		}
	}

}
