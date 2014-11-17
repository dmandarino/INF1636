package visualizacao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;


public class XadrezFrame extends JPanel implements MouseListener, MouseMotionListener{
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
         XadrezPainel p = new XadrezPainel();
         p.paintComponent(g2d);
}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("CLIQUE");
		
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

		System.out.println("PRESSED");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
