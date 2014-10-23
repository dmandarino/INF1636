package visualizacao;
import java.awt.Rectangle;
import java.util.*;

import javax.swing.*;

//Frame principal
@SuppressWarnings("serial")
public class XadrezFrame extends JFrame
{
	public static final int LARG_DEFAULT	= 800;
	public static final int ALT_DEFAULT		= 800;
	
	public XadrezFrame()
	{
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
					fill( 255, 255, 255 );
					branco = false;
				}
				else
				{
					// Torna a casa PRETA
					fill( 0, 0, 0 );
					branco = true;
		 	    }
			Rectangle rect = new Rectangle(x,y,tamanho,tamanho) ;
		    
		 
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
