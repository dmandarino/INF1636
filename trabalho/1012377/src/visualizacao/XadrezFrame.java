package visualizacao;

import java.awt.*;

import javax.swing.JPanel;


public class XadrezFrame extends JPanel {
	 public void paintComponent(Graphics g) {
         super.paintComponent(g);
         XadrezPainel p = new XadrezPainel(); 
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
  // getRootPane().add(p); 	
 }
}
