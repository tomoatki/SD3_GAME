package cw3_final;

public class BattleStar implements Ship {
	public int spawn(int x){
		String name = "Battle Star";
		int damage = 8;
		System.out.println(name + " has spawned with a damage of " + damage + " at location " + x);
		return x;
	}

}
