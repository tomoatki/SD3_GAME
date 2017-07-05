package cw3_final;

public class MoveLeft implements Strategy {

	@Override
	public int move(int x) {
		// TODO Auto-generated method stub
		x = x + -1;
		if (x < 0 || x > 16 || x == 3 || x == 7 || x == 11){
			x = x + 1;
		}
		
		return x;
	}

}
