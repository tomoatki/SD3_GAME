package cw3_final;

public class HealthBoost implements Request {
	
	private Boost Status;

	   public HealthBoost(Boost Status){
	      this.Status = Status;
	   }

	   public void execute() {
	      Status.Health();
	      
	   }

}
