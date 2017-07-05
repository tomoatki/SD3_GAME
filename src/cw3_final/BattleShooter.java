package cw3_final;

public class BattleShooter implements Ship {

	@Override
	public int spawn(int x) {
		String name = "BattleShooter";
		int damage = 15;
		System.out.println(name + " has spawned with a damage of " + damage + " At location "+ x);
		// TODO Auto-generated method stub
		return x;
	}

}
