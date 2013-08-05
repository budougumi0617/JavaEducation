
public class GasTank implements EnergySource{
	private double Energy = 0;
	public GasTank(double gass) {
		this.Energy = gass;
	}
	public boolean empty(){
		if(this.Energy  <= 0){
			return true;
		}else{
			return false ;
		}
	}

}
