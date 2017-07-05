package cw3_final;

public class DefensiveState extends Observer {
	
	public DefensiveState(Subject subject){
		this.subject = subject;
		this.subject.attach(this);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(subject.getState() == 1){
			System.out.println("Defensive mode is Online");
		}
		else {
			System.out.println("Deffensive Mode is offline");
		}
		
	}

	
}
