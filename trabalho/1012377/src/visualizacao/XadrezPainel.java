package visualizacao;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelos.Bispo;
import modelos.Casa;
import modelos.Cavalo;
import modelos.Peao;
import modelos.Peca;
import modelos.PecaEnum;
import modelos.Rainha;
import modelos.Rei;
import modelos.Torre;
import service.Movimento;
import service.MovimentoBispo;
import service.MovimentoCavalo;
import service.MovimentoPeao;
import service.MovimentoRainha;
import service.MovimentoRei;
import service.MovimentoTorre;

@SuppressWarnings("serial")
public class XadrezPainel extends JPanel 
{
	JLabel mousePosition;
	private static final int NUM_CASAS_X = 8;
	private static final int NUM_CASAS_Y = 8;
	private static final int DIMEN = 50;
	private static final int NUM_PEAO = 8;
	private static final int NUM_PECAS_NAO_REAIS = 2;
	private static final int PIXEL_INI = 10;
	private HashMap<Integer, Casa> casas = new HashMap<Integer, Casa>();
	private List<Peca> pecasBrancas = new ArrayList<Peca>();
	private List<Peca> pecasPretas = new ArrayList<Peca>();
	private Casa casaClicada = new Casa();
	private Casa casaDestino = new Casa();
	
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
	protected Object inputRecorder;
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
//        this.addMouseListener(this);
//        this.addMouseMotionListener(this);

		//Carregar imagens que seram necessarias
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
		
		if(painel == 0)	{
            super.paintComponent(g);
		        
			criarCasas();
			iniciarPecas(g);
			desenhaPecas(g);
		}
	
	
//	=======================   TESTANDO O MOVIMENTO DE UMA TORRE  =========================
//	
//	
//	
//	System.out.println(pecasBrancas.get(16).getCasa().getNumCasa().toString() + "     onde ir: " + casas.get(37).getNumCasa().toString());
//	Movimento mov= new MovimentoTorre();
//	mov.andar(pecasBrancas.get(16), casas.get(37), casas, pecasBrancas);
//	repaint();
// 
//
//	=======================   TESTANDO O MOVIMENTO DE UMA PEAO  =========================
//	
//	
//	
//	System.out.println(pecasBrancas.get(0).getCasa().getNumCasa().toString() + "     onde ir: " + casas.get(41).getNumCasa().toString());
//    Movimento mov= new MovimentoPeao();
//    mov.andar(pecasBrancas.get(0), casas.get(41), casas);
//
//    desenhaPecas(g);
//
//	=======================   TESTANDO O MOVIMENTO DO REI  =========================
//	
//	
//	
//	System.out.println(pecasBrancas.get(16).getCasa().getNumCasa().toString() + "     onde ir: " + casas.get(41).getNumCasa().toString());
//    Movimento mov= new MovimentoRei();
//    mov.andar(pecasBrancas.get(16), casas.get(43), casas);
//
//    desenhaPecas(g);
//	=======================   TESTANDO O MOVIMENTO DA RAINHA  =========================
//	
//	
//	
//	System.out.println(pecasBrancas.get(16).getCasa().getNumCasa().toString() + "     onde ir: " + casas.get(41).getNumCasa().toString());
//    Movimento mov= new MovimentoRainha();
//    mov.andar(pecasBrancas.get(16), casas.get(42), casas);
//
//    desenhaPecas(g);
//
//	=======================   TESTANDO O MOVIMENTO DO BISPO  =========================
//	
//	
//	System.out.println(pecasBrancas.get(16).getCasa().getNumCasa().toString() + "     onde ir: " + casas.get(41).getNumCasa().toString());
//    Movimento mov= new MovimentoBispo();
//    mov.andar(pecasBrancas.get(16), casas.get(28), casas);
//
//    desenhaPecas(g);
//	
//	=======================   TESTANDO O MOVIMENTO DO CAVALO  =========================
//	
//	
//	System.out.println(pecasBrancas.get(16).getCasa().getNumCasa().toString() + "     onde ir: " + casas.get(41).getNumCasa().toString());
//    Movimento mov= new MovimentoCavalo();
//    mov.andar(pecasBrancas.get(16), casas.get(18), casas);
//
//    desenhaPecas(g);
 
}

    public Casa mouseClicked(int click) {
		  casaClicada = casas.get(click);
		  return casaClicada;
    }  

    public void mouseReleased(Casa casaClicada, int click) {
		  casaDestino = casas.get(click);
		  System.out.println(casaClicada.getNumCasa().toString() + "  " + casaDestino.getNumCasa().toString());
		  Peca peca = casaClicada.getPeca();
		  
		  
		  Movimento mov = null;
		  switch (peca.getTipo()) {
			case PEAO:
				mov = new MovimentoPeao(peca.getFigura());
				break;
		    case TORRE:
				mov = new MovimentoTorre();
				break;
		    case CAVALO:
				mov = new MovimentoCavalo();
				break;
		    case BISPO:
				mov = new MovimentoBispo();
				break;
		    case RAINHA:
				mov = new MovimentoRainha();
				break;
			default:
				mov = new MovimentoRei();
		  }
		  if(peca.isBranco())
			  mov.andar (peca, casaDestino, casas, pecasPretas);
		  else 
			  mov.andar (peca, casaDestino, casas, pecasBrancas);
		  repaint();
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
	
	private void iniciarPecas(Graphics g) {
		pecasBrancas = criarPecas(true, casas);
		pecasPretas = criarPecas(false, casas);
	}

	private void desenhaPecas(Graphics g) {
		for (Peca peca : pecasBrancas) {
			g.drawImage(peca.getFigura(),peca.getCasa().getX(),peca.getCasa().getY(),null);
		}
		for (Peca peca : pecasPretas) {
			g.drawImage(peca.getFigura(),peca.getCasa().getX(),peca.getCasa().getY(),null);
		}
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
		
//		Rei TESTE = new Rei();
//		TESTE.setTipo(PecaEnum.REI);
//		TESTE.setBranco(isBranca);
//		if(isBranca){
//			TESTE.setFigura(rei_branco);
//			TESTE.setCasa(casas.get(34));
//			casas.get(34).setPeca(TESTE);
//			pecas.add(TESTE);
//		} 
//		
		Torre TESTE = new Torre();
		TESTE.setTipo(PecaEnum.TORRE);
		TESTE.setBranco(isBranca);
		if(isBranca){
			TESTE.setFigura(torre_branco);
			TESTE.setCasa(casas.get(34));
			casas.get(34).setPeca(TESTE);
			pecas.add(TESTE);
		}
//		
//		Rainha TESTE = new Rainha();
//		TESTE.setTipo(PecaEnum.RAINHA);
//		TESTE.setBranco(isBranca);
//		if(isBranca){
//			TESTE.setFigura(dama_branco);
//			TESTE.setCasa(casas.get(34));
//			casas.get(34).setPeca(TESTE);
//			pecas.add(TESTE);
//		}
//		
//		Bispo TESTE = new Bispo();
//		TESTE.setTipo(PecaEnum.BISPO);
//		TESTE.setBranco(isBranca);
//		if(isBranca){
//			TESTE.setFigura(bispo_branco);
//			TESTE.setCasa(casas.get(34));
//			casas.get(34).setPeca(TESTE);
//			pecas.add(TESTE);
//		}
//	
//		
//		Cavalo TESTE = new Cavalo();
//		TESTE.setTipo(PecaEnum.CAVALO);
//		TESTE.setBranco(isBranca);
//		if(isBranca){
//			TESTE.setFigura(cavalo_branco);
//			TESTE.setCasa(casas.get(35));
//			casas.get(35).setPeca(TESTE);
//			pecas.add(TESTE);
//		}
		Long id = 1L;
		for (Peca peca : pecas) {
			peca.setId(id);
			id++;
		}
		
		return pecas;
	}
}

