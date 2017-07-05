package cw3_final;

import java.util.Random;

public class ShipFactory {

	
	
	public Ship getShip(int shipType){
		if (shipType == 0){
			return null;
		}
		if (shipType == 1){
			return new BattleCruiser();
			
		}
		if(shipType == 2){
			return new BattleStar();
		}
		if (shipType == 3){
			return new BattleShooter();
		}
		return null;
	}
}
