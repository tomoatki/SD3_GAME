package cw3_final;
import java.awt.*;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;





import javax.swing.*;

public class main extends JFrame {
	public static final int COLUMN_COUNT = 16;
	static Random rand = new Random();
	public JButton btn_arr;
	public Container c;
	int tmp = (int) ( Math.random() * 3 + 1);
	public JLabel[] lbl = new JLabel[COLUMN_COUNT];
	Context context  = new Context(new MoveUp());
	Context context2 = new Context(new MoveDown());
	Context context3 = new Context(new MoveLeft());
	Context context4 = new Context(new MoveRight());
	ShipFactory shipFactory = new ShipFactory();
	Ship ship1 = shipFactory.getShip(tmp);
	static int operationalMode = 1;
	static int count = 0;
	static int current = 0;
	static int start = rand.nextInt((16 - 1 ) + 1) + 1;
	static String name = "starship.png";
	
	ImageIcon imgThisImg = new ImageIcon("C:\\Users\\tomat_000\\workspace\\cw3_final\\src\\cw3_final\\starship.png");
	ImageIcon blank = new ImageIcon("");
	ImageIcon enemyShip = new ImageIcon("C:\\Users\\tomat_000\\workspace\\cw3_final\\src\\cw3_final\\enemy.png");
	static int enemyPost = 0;
	static ArrayList<Integer> arl = new ArrayList<Integer>();

	
	public static void spawn(){
		arl.add(0);
	}

	public static  ArrayList<Integer> getNumEnemies(ArrayList<Integer> array){
		count = 0;
		for(int i =0; i < array.size(); i++){
			if(array.get(i) == current){
				count = count + i;
			}
			
		}
		System.out.println( "The count is " + count);
		return array;
	}

	public static ArrayList<Integer> enemyMove(ArrayList<Integer> array){
		
		int [] moves = {-1,1,4,-4};
		int rnd = new Random().nextInt(moves.length);
		for (int i = 0; i < array.size(); i++) {
			
		
		int index = array.get(i) + moves[rnd];
		array.set(i, index);
		
		
		if (array.get(i) < 0){
			array.set(i, 0);
			
		}
		else if (array.get(i) > 15){
			array.set(i, 15);
		}
		else if (moves[rnd] == 1 && array.get(i) == 4 || array.get(i) == 8 || array.get(i) == 12 ){
			index = index - moves[rnd];
			array.set(i, index);
		}
		else if (moves[rnd] == -1 && array.get(i) == 5 || array.get(i) == 8 || array.get(i) == 12){
			index = index - moves[rnd];
			array.set(i, index);
		}
		else if (moves[rnd] == -4 && array.get(i) == 0 || array.get(i) == 1 || array.get(i) == 2 || array.get(i) == 3){
			index = index - moves[rnd];
			array.set(i, index);
		}
		else if (moves[rnd] == 4 && array.get(i) == 12 || array.get(i) == 13 ||  array.get(i) == 14){
			index = index - moves[rnd];
			array.set(i, index);
		}
		
		}
		
		return array;
		
		}

	
public static void disable(final AbstractButton b, final long ms){
	b.setEnabled(false);
	new SwingWorker(){

		@Override
		protected Object doInBackground() throws Exception {
			Thread.sleep(ms);
			// TODO Auto-generated method stub
			return null;
		}
		protected void done(){
			b.setEnabled(true);
		}
	}.execute();
}
	
	public main(){
		
		Subject subject = new Subject();
		new OffensiveState(subject);
		new DefensiveState(subject);
		c = getContentPane();
		c.setLayout(new GridLayout(6,COLUMN_COUNT));
		JButton b = new JButton("up");
		JButton bk = new JButton("down");
		JButton lft = new JButton("left");
		JButton right = new JButton("right");
		JButton defensive = new JButton("Defensive");
		JButton offensive = new JButton("Offensive");
	
		for(int i =0; i < lbl.length; i ++){
			lbl[i] = new JLabel("" + (i + 1));
			//post.add(i);
			c.add(lbl[i]);
		}
		c.add(b);
		c.add(bk);
		c.add(lft);
		c.add(right);
		c.add(defensive);
		c.add(offensive);
		
		current = start;
		lbl[current].setIcon(imgThisImg);
		lbl[current].setText("");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				disable(b,1000);
				// TODO Auto-generated method stub
				for (int i = 0; i < arl.size(); i++) {
					lbl[arl.get(i)].setIcon(blank);
				}
				enemyMove(arl);
				for (int i = 0; i < arl.size(); i++) {
				
				
				lbl[arl.get(i)].setIcon(enemyShip);
				lbl[arl.get(i)].setText("");
				
				}
				
				lbl[current].setIcon(blank);
				
				current = context.executeStrategy(current);
				System.out.println(current);
				lbl[current].setIcon(imgThisImg);
				lbl[current].setText("");
				
				System.out.println(current);
				int rnd2 = rand.nextInt(3) + 1;
				
				if (rnd2 == 2){
					spawn();
					ship1.spawn(0);
				}
				
				getNumEnemies(arl);
				
				if(operationalMode == 1){
					//x2.defensiveMode(arl);
					//offensiveMode(arl);
					Offensive.offensiveMode2(arl);
					
				}
				else if (operationalMode == 2){
					
					Defensive.defensiveMode2(arl);
					//defensiveMode(arl);
				}
				
				System.out.println(operationalMode);
				
			}
		});
		
		bk.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				disable(bk,1000);
				
				for (int i = 0; i < arl.size(); i++) {
					lbl[arl.get(i)].setIcon(blank);
				}
				enemyMove(arl);
				for (int i = 0; i < arl.size(); i++) {
				
				lbl[arl.get(i)].setIcon(enemyShip);
				lbl[arl.get(i)].setText("");
				
				}
				// TODO Auto-generated method stub
				lbl[current].setIcon(blank);
				current = context2.executeStrategy(current);
				//moveDown(current);
				lbl[current].setIcon(imgThisImg);
				lbl[current].setText("");
				System.out.println(current);
				int rnd2 = rand.nextInt(3) + 1;
				
				if (rnd2 == 2){
					spawn();
					ship1.spawn(0);
				}
				
				getNumEnemies(arl);
				
				if(operationalMode == 1){
					//x2.defensiveMode(arl);
					//offensiveMode(arl);
					Offensive.offensiveMode2(arl);
					
				}
				else if (operationalMode == 2){
					
					Defensive.defensiveMode2(arl);
					//defensiveMode(arl);
				}
				
				System.out.println(operationalMode);
				
				
				
			}
			
		});
		
		
		lft.addActionListener(new ActionListener(){
		

			@Override
			public void actionPerformed(ActionEvent arg0) {
				disable(lft,1000);
				// TODO Auto-generated method stub
				for (int i = 0; i < arl.size(); i++) {
					lbl[arl.get(i)].setIcon(blank);
				}
				enemyMove(arl);
				for (int i = 0; i < arl.size(); i++) {
				
				lbl[arl.get(i)].setIcon(enemyShip);
				lbl[arl.get(i)].setText("");
				
				}
				lbl[current].setIcon(blank);
				//moveLeft(current);
				current = context3.executeStrategy(current);
				lbl[current].setIcon(imgThisImg);
				lbl[current].setText("");
				System.out.println(current);
				
				
				int rnd2 = rand.nextInt(3) + 1;
				
				if (rnd2 == 2){
					spawn();
					ship1.spawn(0);
				}
				
				getNumEnemies(arl);
				
				if(operationalMode == 1){
					//x2.defensiveMode(arl);
					//offensiveMode(arl);
					Offensive.offensiveMode2(arl);
					
				}
				else if (operationalMode == 2){
					
					Defensive.defensiveMode2(arl);
					//defensiveMode(arl);
				}
				
				System.out.println(operationalMode);
				
				
				
				
			}
			
		});
		
		
		
		right.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				disable(right,1000);
				for (int i = 0; i < arl.size(); i++) {
					lbl[arl.get(i)].setIcon(blank);
				}
				enemyMove(arl);
				for (int i = 0; i < arl.size(); i++) {
				
				lbl[arl.get(i)].setIcon(enemyShip);
				lbl[arl.get(i)].setText("");
				
				}
				// TODO Auto-generated method stub
				lbl[current].setIcon(blank);
				//moveRight(current);
				current = context4.executeStrategy(current);
				lbl[current].setIcon(imgThisImg);
				lbl[current].setText("");
				System.out.println(current);
				
				int rnd2 = rand.nextInt(3) + 1;
				
				if (rnd2 == 2){
					spawn();
					ship1.spawn(0);
				}
				
				getNumEnemies(arl);
				
				if(operationalMode == 1){
					//x2.defensiveMode(arl);
					//offensiveMode(arl);
					Offensive.offensiveMode2(arl);
					
				}
				else if (operationalMode == 2){
					
					Defensive.defensiveMode2(arl);
					//defensiveMode(arl);
				}
				
				System.out.println(operationalMode);
				
				
			}
			
		});
		
		defensive.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				disable(defensive,1000);
				// TODO Auto-generated method stub
				operationalMode = 1;
				subject.setState(1);
			}
			
		});
		
		offensive.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				disable(offensive,1000);
				operationalMode = 2;
				
				
				subject.setState(2);
			}
			
		});
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		main x = new main();
		
		x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x.pack();
		x.setLocationRelativeTo(null);
		x.setVisible(true);
		x.setSize(450,450);
		
		Boost status = new Boost();

	      DamageBoost damageBoostRequest = new DamageBoost(status);
	      HealthBoost healthBoostRequest = new HealthBoost(status);

	      Invoker invoker = new Invoker();
	      invoker.takerequest(damageBoostRequest);
	      invoker.takerequest(healthBoostRequest);

	      invoker.placerequests();
	}

}
