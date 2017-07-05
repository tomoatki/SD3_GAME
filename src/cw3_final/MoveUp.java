package cw3_final;

public class MoveUp implements Strategy {
	
	@Override
	public  int move(int x) {
		// TODO Auto-generated method stub
		x = x + -4;
		if (x < 0 || x > 16){
			x = x + 4;
		}
		
		return x;
	}
	
}
