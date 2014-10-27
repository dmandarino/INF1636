package visualizacao;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

//Frame principal
@SuppressWarnings("serial")
public class XadrezFrame extends JPanel {
	
	public static final int LARG_DEFAULT	= 800;
	public static final int ALT_DEFAULT		= 800;
	private Graphics2D g2d;
	
	public XadrezFrame(Graphics g)
	{
		
		g2d = (Graphics2D) g;
		// Tamanho de cada casa, tanto em largura como em altura.
		int tamanho = 100;
		// branco ou preto
		boolean branco = true;
		
		for (int x = 0; x < LARG_DEFAULT; x += 100)
		{
			for (int y = 0; y < ALT_DEFAULT; y += 100)
			{
				if ( branco )
				{ 
					// Torna a casa BRANCA
					g2d.setColor(Color.WHITE); 
					branco = false;
				}
				else
				{
					// Torna a casa PRETA
					g2d.setColor(Color.BLACK); 
					branco = true;
		 	    }
				g2d.fill(new Rectangle2D.Double(x, y, tamanho, tamanho));
			}
		 
		  if ( branco )
		  {
			  branco = false;
		  } 
		  else
		  {
			  branco = true;
		  }
		}
	}
}