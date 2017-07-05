package cw3_final;

public class DamageBoost implements Request {
	
	private Boost Status;

	   public DamageBoost(Boost Status){
	      this.Status = Status;
	   }

	   public void execute() {
	      Status.Damage();
	   }

}
