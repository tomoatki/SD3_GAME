package cw3_final;

public class MoveRight implements Strategy {

	@Override
	public int move(int x) {
		// TODO Auto-generated method stub
		x = x + 1;
		if (x < 0 || x > 15 || x == 4 || x == 8 || x == 12){
			x = x - 1;
		}
		
		return x;
	}

}
