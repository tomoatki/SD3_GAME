package cw3_final;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Offensive extends main {
	
	static String infoMessage ="Master Ship Destroyed, reload program";
	static String titleBar = "Alert";
	
	 public static void infoBox(String infoMessage, String titleBar)
	    {
	        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	    }
	public static ArrayList<Integer> offensiveMode2(ArrayList<Integer> array){
		if(count < 4){
		for (int i = 0; i < array.size(); i++){
			if(current == array.get(i)){
				array.remove(i);
				System.out.println("Target destroyed commander");
			}
		}
		}
		else if (count >= 4){
			infoBox(infoMessage,titleBar);
		}
			
		else {
			System.out.println("No targets found");
		}
		return array;
	}

}
