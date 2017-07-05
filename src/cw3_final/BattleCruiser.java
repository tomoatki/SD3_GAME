package cw3_final;

public class BattleCruiser implements Ship {
	public int spawn(int x) {
		String name = "BattleCrusier";
		int damage = 10;
		System.out.println(name + " has spawned with a damage of " + damage + " At location "+ x);
		return x;
	}
}
