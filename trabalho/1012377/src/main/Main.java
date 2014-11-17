package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension; 
import java.awt.FlowLayout; 
import java.awt.Toolkit; 
import java.awt.event.MouseListener; 
import java.awt.event.MouseMotionListener; 

import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JFrame;

import visualizacao.XadrezFrame;
import visualizacao.XadrezPainel;

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
