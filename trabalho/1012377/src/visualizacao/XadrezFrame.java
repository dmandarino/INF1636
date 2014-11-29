package visualizacao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;

import javax.swing.JPanel;

import modelos.Casa;


public class XadrezFrame extends JPanel implements MouseListener, MouseMotionListener{
	
	private Casa casaClicada = new Casa();
	private HashMap<Integer, Casa> casas = new HashMap<Integer, Casa>();
	private XadrezPainel p = new XadrezPainel();
	
	
	public XadrezFrame()
	{
		this.addMouseListener(this);
	}
	
	 public void paintComponent(Graphics g) {
         super.paintComponent(g);
         Graphics2D g2d = (Graphics2D) g;
         Boolean branco = true;
         
         for (int x = 0; x < 400; x+=50)
         {
        	 for (int y = 0; y < 400; y+=50)
        	 {
        		 if (branco)
        		 {
			         g2d.setColor(new Color(255, 255, 255));
			         g2d.drawRect(x, y, 50, 50);
			         branco = false;
        		 }
        		 else
        		 {
        			 g2d.setColor(new Color(0, 0, 0));
    		         g2d.drawRect(x, y, 50, 50);
    		         branco = true;
        		 }
        		 g2d.fillRect(x, y, 50, 50);
        	 }
        	 if (branco)
        		 branco = false;
        	 else
        		 branco = true;
         }
         p.paintComponent(g2d);
	 }

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	 	  int click = getClick(e);
		  casaClicada =  p.mouseClicked(click);
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		 int click = getClick(e);
		 p.mouseReleased(casaClicada, click);
		 repaint();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	private int getClick(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int click = (x/50 + 8*(y/50));
		click++;
		return click;
	}
}
