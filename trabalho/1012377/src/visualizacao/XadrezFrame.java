package visualizacao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import service.Arquivo;
import modelos.Bispo;
import modelos.Casa;
import modelos.Cavalo;
import modelos.Peao;
import modelos.Peca;
import modelos.PecaEnum;
import modelos.Rainha;
import modelos.Rei;
import modelos.Torre;


public class XadrezFrame extends JPanel implements MouseListener, MouseMotionListener{
	
	private static final int NUM_CASAS_X = 8;
	private static final int NUM_CASAS_Y = 8;
	private static final int DIMEN = 50;
	private static final int NUM_PEAO = 8;
	private static final int NUM_PECAS_NAO_REAIS = 2;
	private static final int PIXEL_INI = 10;
	private Casa casaClicada = new Casa();
	private HashMap<Integer, Casa> casas = new HashMap<Integer, Casa>();
	private List<Peca> pecasBrancas = new ArrayList<Peca>();
	private List<Peca> pecasPretas = new ArrayList<Peca>();
	private XadrezPainel p = new XadrezPainel();
	private Arquivo arq = new Arquivo();
	
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

	public XadrezFrame()
	{
		this.addMouseListener(this);
		carregaImagem();
		criarCasas();
		iniciarPecas();
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
         arq.carregaDados(casas, pecasBrancas, pecasPretas);
         p.carregaDados(casas, pecasBrancas, pecasPretas);
         p.paintComponent(g2d);
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
		 casas = p.getCasas();
		 pecasBrancas = p.getPecasBrancas();
		 pecasPretas = p.getPecasPretas();
		 repaint();
	 }

	 @Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}


	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
	}

	private int getClick(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int click = (x/50 + 8*(y/50));
		click++;
		return click;
	}
	
	private void carregaImagem(){
		try
		{
			bispo_branco	= ImageIO.read(new File("Pecas/b_bispo.png"));
			cavalo_branco	= ImageIO.read(new File("Pecas/b_cavalo.png"));
			dama_branco		= ImageIO.read(new File("Pecas/b_dama.png"));
			peao_branco		= ImageIO.read(new File("Pecas/b_peao.png"));
			rei_branco		= ImageIO.read(new File("Pecas/b_rei.png"));
			torre_branco	= ImageIO.read(new File("Pecas/b_torre.png"));
			bispo_preto		= ImageIO.read(new File("Pecas/p_bispo.png"));
			cavalo_preto	= ImageIO.read(new File("Pecas/p_cavalo.png"));
			dama_preto		= ImageIO.read(new File("Pecas/p_dama.png"));
			peao_preto		= ImageIO.read(new File("Pecas/p_peao.png"));
			rei_preto		= ImageIO.read(new File("Pecas/p_rei.png"));
			torre_preto		= ImageIO.read(new File("Pecas/p_torre.png"));
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	private void criarCasas() {
		int cont = 0;
		for (int i = 0; i < NUM_CASAS_X; i++) {
 			for (int j = 0; j < NUM_CASAS_Y; j++) {
 				Casa c = new Casa();
				c.setNumCasa(cont);
				c.setY(PIXEL_INI + i*DIMEN);
				c.setX(PIXEL_INI + j*DIMEN);
//				System.out.println(c.getNumCasa().toString() + "  X= " + c.getX().toString() + "  Y= " + c.getY().toString());
				cont ++;
				casas.put(cont, c);
 			}
		}
	}
	
	private void iniciarPecas() {
		File file =  new File("jogo.txt");  
        if(file.exists()){
        	casas = arq.recuperaJogo(casas);
        	for (HashMap.Entry<Integer, Casa> casa : casas.entrySet()) {
        		if(casa.getValue().getPeca() != null){
	        		if(casa.getValue().getPeca().isBranco())
	        			pecasBrancas.add(casa.getValue().getPeca());
	        		else
	        			pecasPretas.add(casa.getValue().getPeca());
        		}
        	}
        }else{
        	pecasBrancas = criarPecas(true, casas);
        	pecasPretas = criarPecas(false, casas);
        }
        System.out.println("fim");
	}

	private List<Peca> criarPecas(boolean isBranca, HashMap<Integer, Casa> casas) {
		List<Peca> pecas = new ArrayList<Peca>();
		int cont = 0;
		boolean isPrimeiro = true;
		for (int i = 0; i < NUM_PEAO; i++) {
			Peao p = new Peao();
			p.setTipo(PecaEnum.PEAO);
			p.setBranco(isBranca);
			if(isBranca){
				p.setFigura(peao_branco);
				p.setCasa(casas.get(49 + cont));
				casas.get(49 + cont).setPeca(p);
			} else {
				p.setFigura(peao_preto);
				p.setCasa(casas.get(9 + cont));
				casas.get(9 + cont).setPeca(p);
			}
			pecas.add(p);
			cont ++;
		}
		
		for (int i = 0; i < NUM_PECAS_NAO_REAIS; i++) {
			Torre t = new Torre();
			t.setTipo(PecaEnum.TORRE);
			t.setBranco(isBranca);
			if(isBranca){
				t.setFigura(torre_branco);
				if(isPrimeiro){
					t.setCasa(casas.get(57));
					casas.get(57).setPeca(t);
					isPrimeiro = false;
				} else {
					t.setCasa(casas.get(64));
					casas.get(64).setPeca(t);
					isPrimeiro = true;
				}
			} else {
				t.setFigura(torre_preto);
				if(isPrimeiro){
					t.setCasa(casas.get(1));
					casas.get(1).setPeca(t);
					isPrimeiro = false;
				} else {
					t.setCasa(casas.get(8));
					casas.get(8).setPeca(t);
					isPrimeiro = true;
				}
			}
			pecas.add(t);
		}
		
		for (int i = 0; i < NUM_PECAS_NAO_REAIS; i++) {
			Cavalo c = new Cavalo();
			c.setTipo(PecaEnum.CAVALO);
			c.setBranco(isBranca);
			if(isBranca){
				c.setFigura(cavalo_branco);
				if(isPrimeiro){
					c.setCasa(casas.get(58));
					casas.get(58).setPeca(c);
					isPrimeiro = false;
				} else {
					c.setCasa(casas.get(63));
					casas.get(63).setPeca(c);
					isPrimeiro = true;
				}
			} else {
				c.setFigura(cavalo_preto);
				if(isPrimeiro){
					c.setCasa(casas.get(2));
					casas.get(2).setPeca(c);
					isPrimeiro = false;
				} else {
					c.setCasa(casas.get(7));
					casas.get(7).setPeca(c);
					isPrimeiro = true;
				}
			}
			pecas.add(c);
		}
		
		for (int i = 0; i < NUM_PECAS_NAO_REAIS; i++) {
			Bispo b = new Bispo();
			b.setTipo(PecaEnum.BISPO);
			b.setBranco(isBranca);
			if(isBranca){
				b.setFigura(bispo_branco);
				if(isPrimeiro){
					b.setCasa(casas.get(59));
					casas.get(59).setPeca(b);
					isPrimeiro = false;
				} else {
					b.setCasa(casas.get(62));
					casas.get(62).setPeca(b);
					isPrimeiro = true;
				}
			} else {
				b.setFigura(bispo_preto);
				if(isPrimeiro){
					b.setCasa(casas.get(3));
					casas.get(3).setPeca(b);
					isPrimeiro = false;
				} else {
					b.setCasa(casas.get(6));
					casas.get(6).setPeca(b);
					isPrimeiro = true;
				}
			}
			pecas.add(b);
		}
		
		Rainha rainha = new Rainha();
		rainha.setTipo(PecaEnum.RAINHA);
		rainha.setBranco(isBranca);
		if(isBranca){
			rainha.setFigura(dama_branco);
			rainha.setCasa(casas.get(60));
			casas.get(60).setPeca(rainha);
		} else {
			rainha.setFigura(dama_preto);
			rainha.setCasa(casas.get(4));
			casas.get(4).setPeca(rainha);
		}
		pecas.add(rainha);
		
		Rei rei = new Rei();
		rei.setTipo(PecaEnum.REI);
		rei.setBranco(isBranca);
		if(isBranca){
			rei.setFigura(rei_branco);
			rei.setCasa(casas.get(61));
			casas.get(61).setPeca(rei);
		} else {
			rei.setFigura(rei_preto);
			rei.setCasa(casas.get(5));
			casas.get(5).setPeca(rei); 
		}
		pecas.add(rei);

		Long id = 1L;
		for (Peca peca : pecas) {
			peca.setId(id);
			id++;
		}
		
		return pecas;
	}
}
