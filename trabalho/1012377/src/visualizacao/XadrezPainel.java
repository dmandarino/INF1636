package visualizacao;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import modelos.Bispo;
import modelos.Cavalo;
import modelos.Peao;
import modelos.Peca;
import modelos.PecaEnum;
import modelos.Rainha;
import modelos.Rei;
import modelos.Torre;

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
			iniciaPecasBrancas(g);
			iniciaPecasPretas(g);
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
	
	private void iniciaPecasBrancas(Graphics g) {
		List<Peca> pecasBrancas = criarPecas();
		
		setPosInicialBranca(pecasBrancas);
		
		for (Peca peca : pecasBrancas) {
			g.drawImage(peca.getFigura(),peca.getX(),peca.getY(),null);
		}
	}

	private void iniciaPecasPretas(Graphics g) {
		List<Peca> pecasPretas = criarPecas();
		
		setPosInicialPretas(pecasPretas);
		
		for (Peca peca : pecasPretas) {
			g.drawImage(peca.getFigura(),peca.getX(),peca.getY(),null);
		}
	}
	
	private void setPosInicialBranca(List<Peca> pecasBrancas) {
		for (Peca peca : pecasBrancas) {
			PecaEnum tipo = peca.getTipo();
			peca.setY(360);
			switch (tipo) {
			 case PEAO:
				 	peca.setFigura(peao_branco);
				    peca.setY(310);
				 	if(peca.getNome() == "peao1")
				 		peca.setX(10);
				 	else if(peca.getNome() == "peao2")
				 		peca.setX(60);
				 	else if(peca.getNome() == "peao3")
				 		peca.setX(110);
				 	else if(peca.getNome() == "peao4")
				 		peca.setX(160);
				 	else if(peca.getNome() == "peao5")
				 		peca.setX(210);
				 	else if(peca.getNome() == "peao6")
				 		peca.setX(260);
				 	else if(peca.getNome() == "peao7")
				 		peca.setX(310);
				 	else if(peca.getNome() == "peao8")
				 		peca.setX(360);
	                break;
	            case TORRE:
	            	peca.setFigura(torre_branco);
	            	if(peca.getNome() == "torre1")
	            		peca.setX(10);
	            	else if(peca.getNome() == "torre2")
				 		peca.setX(360);
	                break;
	            case CAVALO:
	            	peca.setFigura(cavalo_branco);
	            	if(peca.getNome() == "cavalo1")
	            		peca.setX(60);
	            	else if(peca.getNome() == "cavalo2")
				 		peca.setX(310);
	            	break;
	            case BISPO:
	            	peca.setFigura(bispo_branco);
	            	if(peca.getNome() == "bispo1")
	            		peca.setX(110);
	            	else if(peca.getNome() == "bispo2")
				 		peca.setX(260);
	            	break;
	            case RAINHA:
	            	peca.setFigura(dama_branco);
	            	peca.setX(160);
	            	break;
	            case REI:
	            	peca.setFigura(rei_branco);
	            	peca.setX(210);
	            	break;
			}
		}
	}
	
	private void setPosInicialPretas(List<Peca> pecasPretas) {
		for (Peca peca : pecasPretas) {
			PecaEnum tipo = peca.getTipo();
			peca.setY(10);
			switch (tipo) {
			 case PEAO:
				 	peca.setFigura(peao_preto);
				    peca.setY(60);
				 	if(peca.getNome() == "peao1")
				 		peca.setX(10);
				 	else if(peca.getNome() == "peao2")
				 		peca.setX(60);
				 	else if(peca.getNome() == "peao3")
				 		peca.setX(110);
				 	else if(peca.getNome() == "peao4")
				 		peca.setX(160);
				 	else if(peca.getNome() == "peao5")
				 		peca.setX(210);
				 	else if(peca.getNome() == "peao6")
				 		peca.setX(260);
				 	else if(peca.getNome() == "peao7")
				 		peca.setX(310);
				 	else if(peca.getNome() == "peao8")
				 		peca.setX(360);
	                break;
	            case TORRE:
	            	peca.setFigura(torre_preto);
	            	if(peca.getNome() == "torre1")
	            		peca.setX(10);
	            	else if(peca.getNome() == "torre2")
				 		peca.setX(360);
	                break;
	            case CAVALO:
	            	peca.setFigura(cavalo_preto);
	            	if(peca.getNome() == "cavalo1")
	            		peca.setX(60);
	            	else if(peca.getNome() == "cavalo2")
				 		peca.setX(310);
	            	break;
	            case BISPO:
	            	peca.setFigura(bispo_preto);
	            	if(peca.getNome() == "bispo1")
	            		peca.setX(110);
	            	else if(peca.getNome() == "bispo2")
				 		peca.setX(260);
	            	break;
	            case RAINHA:
	            	peca.setFigura(dama_preto);
	            	peca.setX(160);
	            	break;
	            case REI:
	            	peca.setFigura(rei_preto);
	            	peca.setX(210);
	            	break;
			}
		}
	}
	
	private List<Peca> criarPecas() {
		List<Peca> pecas = new ArrayList<Peca>();
	
		Peao peao1 = new Peao();
		peao1.setTipo(PecaEnum.PEAO);
		peao1.setNome("peao1");
		pecas.add(peao1);
		
		Peao peao2 = new Peao();
		peao2.setTipo(PecaEnum.PEAO);
		peao2.setNome("peao2");
		pecas.add(peao2);
		
		Peao peao3 = new Peao();
		peao3.setTipo(PecaEnum.PEAO);
		peao3.setNome("peao3");
		pecas.add(peao3);
		
		Peao peao4 = new Peao();
		peao4.setTipo(PecaEnum.PEAO);
		peao4.setNome("peao4");
		pecas.add(peao4);
		
		Peao peao5 = new Peao();
		peao5.setTipo(PecaEnum.PEAO);
		peao5.setNome("peao5");
		pecas.add(peao5);
		
		Peao peao6 = new Peao();
		peao6.setTipo(PecaEnum.PEAO);
		peao6.setNome("peao6");
		pecas.add(peao6);
		
		Peao peao7 = new Peao();
		peao7.setTipo(PecaEnum.PEAO);
		peao7.setNome("peao7");
		pecas.add(peao7);
		
		Peao peao8 = new Peao();
		peao8.setTipo(PecaEnum.PEAO);
		peao8.setNome("peao8");
		pecas.add(peao8);
		
		Torre torre1 = new Torre();
		torre1.setTipo(PecaEnum.TORRE);
		torre1.setNome("torre1");
		pecas.add(torre1);
		
		Torre torre2 = new Torre();
		torre2.setTipo(PecaEnum.TORRE);
		torre2.setNome("torre2");
		pecas.add(torre2);
		
		Cavalo cavalo1 = new Cavalo();
		cavalo1.setTipo(PecaEnum.CAVALO);
		cavalo1.setNome("cavalo1");
		pecas.add(cavalo1);
		
		Cavalo cavalo2 = new Cavalo();
		cavalo2.setTipo(PecaEnum.CAVALO);
		cavalo2.setNome("cavalo2");
		pecas.add(cavalo2);
		
		Bispo bispo1 = new Bispo();
		bispo1.setTipo(PecaEnum.BISPO);
		bispo1.setNome("bispo1");
		pecas.add(bispo1);
		
		Bispo bispo2 = new Bispo();
		bispo2.setTipo(PecaEnum.BISPO);
		bispo2.setNome("bispo2");
		pecas.add(bispo2);
		
		Rainha rainha = new Rainha();
		rainha.setTipo(PecaEnum.RAINHA);
		rainha.setNome("rainha");
		pecas.add(rainha);
		
		Rei rei = new Rei();
		rei.setTipo(PecaEnum.REI);
		rei.setNome("rei");
		pecas.add(rei);
		
		return pecas;
	}
	
}

