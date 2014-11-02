package visualizacao;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import modelos.Peca;
import modelos.PecaEnum;

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
			bispo_branco	= ImageIO.read(new File("Pecas/b_bispo.gif"));
			cavalo_branco	= ImageIO.read(new File("Pecas/b_cavalo.gif"));
			dama_branco		= ImageIO.read(new File("Pecas/b_dama.gif"));
			peao_branco		= ImageIO.read(new File("Pecas/b_peao.gif"));
			rei_branco		= ImageIO.read(new File("Pecas/b_rei.gif"));
			torre_branco	= ImageIO.read(new File("Pecas/b_torre.gif"));
			bispo_preto		= ImageIO.read(new File("Pecas/p_bispo.gif"));
			cavalo_preto	= ImageIO.read(new File("Pecas/p_cavalo.gif"));
			dama_preto		= ImageIO.read(new File("Pecas/p_dama.gif"));
			peao_preto		= ImageIO.read(new File("Pecas/p_peao.gif"));
			rei_preto		= ImageIO.read(new File("Pecas/p_rei.gif"));
			torre_preto		= ImageIO.read(new File("Pecas/p_torre.gif"));
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());

	}
	
	if(painel == 0)	{
		carregaPecas(g);

		g.drawImage(torre_branco,10,360,null);
		g.drawImage(torre_branco,360,360,null);
		g.drawImage(cavalo_branco, 310 ,360,null);
		g.drawImage(cavalo_branco, 60 ,360,null);
		g.drawImage(bispo_branco, 260 ,360,null);
		g.drawImage(bispo_branco, 110 ,360,null);
		g.drawImage(dama_branco, 160,360,null);
		g.drawImage(rei_branco,210,360,null);
		g.drawImage(peao_branco,10 ,310,null);
		g.drawImage(peao_branco,60 ,310,null);
		g.drawImage(peao_branco,110 ,310,null);
		g.drawImage(peao_branco,160 ,310,null);
		g.drawImage(peao_branco,210 ,310,null);
		g.drawImage(peao_branco,260 ,310,null);
		g.drawImage(peao_branco,310 ,310,null);
		g.drawImage(peao_branco,360 ,310,null);
		
		g.drawImage(torre_preto, 360 , 10,null);
		g.drawImage(torre_preto, 10 , 10,null);
		g.drawImage(cavalo_preto, 310, 10,null);
		g.drawImage(cavalo_preto, 60, 10,null);
		g.drawImage(bispo_preto,260 , 10,null);
		g.drawImage(bispo_preto,110 , 10,null);
		g.drawImage(dama_preto,160 ,10 ,null);
		g.drawImage(rei_preto, 210 , 10,null);
		g.drawImage(peao_preto,10 , 60,null);
		g.drawImage(peao_preto,60 , 60,null);
		g.drawImage(peao_preto,110 , 60,null);
		g.drawImage(peao_preto,160 , 60,null);
		g.drawImage(peao_preto,210 , 60,null);
		g.drawImage(peao_preto,260 , 60,null);
		g.drawImage(peao_preto,310 , 60,null);
		g.drawImage(peao_preto,360 , 60,null);
		
		
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
	private void carregaPecas(Graphics g) {
		iniciaPecasBrancas();
		// TODO Auto-generated method stub
		
	}
	private void iniciaPecasBrancas() {
		List<Peca> pecasBrancas = new ArrayList<Peca>();
		
		instanciarPecas();
	}
	
	private void instanciarPecas() {
		Peca peao1 = new Peca();
		peao1.setNome(PecaEnum.PEAO);
		Peca peao2 = new Peca();
		peao2.setNome(PecaEnum.PEAO);
		Peca peao3 = new Peca();
		peao3.setNome(PecaEnum.PEAO);
		Peca peao4 = new Peca();
		peao4.setNome(PecaEnum.PEAO);
		Peca peao5 = new Peca();
		peao5.setNome(PecaEnum.PEAO);
		Peca peao6 = new Peca();
		peao6.setNome(PecaEnum.PEAO);
		Peca peao7 = new Peca();
		peao7.setNome(PecaEnum.PEAO);
		Peca peao8 = new Peca();
		peao8.setNome(PecaEnum.PEAO);
		Peca torre1 = new Peca();
		torre1.setNome(PecaEnum.TORRE);
		Peca torre2 = new Peca();
		torre2.setNome(PecaEnum.TORRE);
		Peca cavalo1 = new Peca();
		cavalo1.setNome(PecaEnum.CAVALO);
		Peca cavalo2 = new Peca();
		cavalo2.setNome(PecaEnum.CAVALO);
		Peca bispo1 = new Peca();
		bispo1.setNome(PecaEnum.BISPO);
		Peca bispo2 = new Peca();
		bispo2.setNome(PecaEnum.BISPO);
		Peca rainha = new Peca();
		rainha.setNome(PecaEnum.RAINHA);
		Peca rei = new Peca();
		rei.setNome(PecaEnum.REI);
	}
}

