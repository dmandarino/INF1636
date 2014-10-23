package visualizacao;

import javax.imageio.ImageIO;
import javax.swing.*;

import modelos.Peca;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class XadrezPainel extends JPanel implements MouseListener 
{
	
	
	public Peca peca = new Peca();
	private Image	bispo_branco, 
					cavalo_branco,
					dama_branco,
					peao_branco,
					rei_branco,
					torre_branco,
					bispo_preto,
					cavalo_preto,
					dama_preto,
					peao_preto,
					rei_preto,
					torre_preto;


	int painel	= 0;
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		//Carregar imagens que seram necessarias
		try
		{
			bispo_branco	= ImageIO.read(new File("b_bispo.gif"));
			cavalo_branco	= ImageIO.read(new File("b_cavalo.gif"));
			dama_branco		= ImageIO.read(new File("b_dama.gif"));
			peao_branco		= ImageIO.read(new File("b_peao.gif"));
			rei_branco		= ImageIO.read(new File("b_rei.gif"));
			torre_branco	= ImageIO.read(new File("b_torre.gif"));
			bispo_preto		= ImageIO.read(new File("p_bispo.gif"));
			cavalo_preto	= ImageIO.read(new File("p_cavalo.gif"));
			dama_preto		= ImageIO.read(new File("p_dama.gif"));
			peao_preto		= ImageIO.read(new File("p_peao.gif"));
			rei_preto		= ImageIO.read(new File("p_rei.gif"));
			torre_preto		= ImageIO.read(new File("p_torre.gif"));
			
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());

	}
		
		if(painel == 0)
		{
			g.drawImage(bispo_branco, 100 ,100,null);
			g.drawImage(cavalo_branco, 100 ,100,null);
			g.drawImage(dama_branco,100,100,null);
			g.drawImage(peao_branco,100 ,100,null);
			g.drawImage(rei_branco,100,100,null);
			g.drawImage(torre_branco,100,100,null);
			
			g.drawImage(bispo_preto,100 , 100,null);
			g.drawImage(cavalo_preto, 100, 100,null);
			g.drawImage(dama_preto,100 , 100,null);
			g.drawImage(peao_preto,100 , 100,null);
			g.drawImage(rei_preto, 100 , 100,null);
			g.drawImage(torre_preto, 0 , 0,null);
			
			
		}
	}
//@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub

}
//@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub

}
//@Override
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub

}
//@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub

}
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
}