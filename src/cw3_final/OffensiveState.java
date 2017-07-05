package cw3_final;

public class OffensiveState extends Observer {
	
	
	public OffensiveState(Subject subject){
		this.subject = subject;
		this.subject.attach(this);
		
	}

	@Override
	public void update() {
		
		if(subject.getState() == 2){
			System.out.println("Offensive mode selected");
		}
		else{
			System.out.println("Offensive Mode offline");
		}
		// TODO Auto-generated method stub
		
	}

}
