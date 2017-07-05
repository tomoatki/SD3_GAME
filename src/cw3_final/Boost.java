package cw3_final;

public class Boost {

	private String boostOne = "Damage";
	private String boostTwo = "Health";
	   private int damage = 10;
	   private int health = 25;
	  

	   public void Damage(){
	      System.out.println(""+boostOne+", increased by: " + damage);
	   }
	   public void Health(){
	      System.out.println(""+boostTwo+", increased by: " + health);
	   }
}
