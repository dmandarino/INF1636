package main;

import javax.swing.JFrame;

import visualizacao.XadrezFrame;

public class Main {

	
	public static void main(String args[]) { 
	 

		XadrezFrame rects = new XadrezFrame();
	    JFrame frame = new JFrame("Xadrez");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(rects);
	    frame.setSize(420, 440);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
   }
	
}
