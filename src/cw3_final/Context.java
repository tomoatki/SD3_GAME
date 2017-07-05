package cw3_final;

public class Context {
	private Strategy strategy;
	
	public Context(Strategy strategy){
		this.strategy = strategy;
	}
	
	public int executeStrategy(int x){
		return strategy.move(x);
	}

}
