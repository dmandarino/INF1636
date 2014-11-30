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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Exception.CasaOcupadaException;
import Exception.CasaVaziaException;
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
	private HashMap<Integer, Casa> casas = new HashMap<Integer, Casa>();
	private List<Peca> pecasBrancas = new ArrayList<Peca>();
	private List<Peca> pecasPretas = new ArrayList<Peca>();
	private Casa casaClicada = new Casa();
	private Casa casaDestino = new Casa();
	private Object xadrezFrame;
	private JOptionPane jOptionPane = new JOptionPane();

	
	public XadrezPainel() {
	}
	
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

		if(painel == 0)	{
            super.paintComponent(g);
			desenhaPecas(g);
		}
}

	public void carregaDados(HashMap<Integer, Casa> casas, List<Peca> pecasBrancas, List<Peca> pecasPretas){
		this.casas = casas;
		this.pecasBrancas = pecasBrancas;
		this.pecasPretas = pecasPretas;
	}
	
    public Casa mouseClicked(int click) {
		  casaClicada = casas.get(click);
		  return casaClicada;
    }  

    public void mouseReleased(Casa casaClicada, int click) {
		  casaDestino = casas.get(click);
		  System.out.println(casaClicada.getNumCasa().toString() + "  " + casaDestino.getNumCasa().toString());
		  Peca peca = casaClicada.getPeca();
		  if(peca == null){
			  System.out.println("Casa Vazia");
			  return;
		  }
			 
		  Movimento mov = null;
		  switch (peca.getTipo()) {
			case PEAO:
				mov= new MovimentoPeao();
				if(peca.isBranco())
					mov.andar(peca, casaDestino, casas, pecasPretas, pecasBrancas);
				else
					mov.andar(peca, casaDestino, casas, pecasBrancas, pecasPretas);
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
				if(peca.isBranco())
					mov.andar(peca, casaDestino, casas, pecasPretas, pecasBrancas);
				else
					mov.andar(peca, casaDestino, casas, pecasBrancas, pecasPretas);
		  }
		  if(peca.isBranco())
			  mov.andar (peca, casaDestino, casas, pecasPretas);
		  else 
			  mov.andar (peca, casaDestino, casas, pecasBrancas);
		  jogoTerminou(pecasPretas, pecasBrancas);
    }

	private void jogoTerminou(List<Peca> pretas, List<Peca> brancas) {
		boolean terminou = true;
		for (Peca branca : brancas) {
			if(branca.getTipo().equals(PecaEnum.REI))
				terminou = false;
		}
		for (Peca preta : pretas) {
			if(preta.getTipo().equals(PecaEnum.REI))
				terminou = false;
		}
		if(terminou)
			jOptionPane.showMessageDialog(null, "O JOGO CABOU!");
	}
	
	private void desenhaPecas(Graphics g) {
		for (Peca peca : pecasBrancas) {
			g.drawImage(peca.getFigura(),peca.getCasa().getX(),peca.getCasa().getY(),null);
		}
		for (Peca peca : pecasPretas) {
			g.drawImage(peca.getFigura(),peca.getCasa().getX(),peca.getCasa().getY(),null);
		}
	}

	public HashMap<Integer, Casa> getCasas() {
		return casas;
	}

	public List<Peca> getPecasBrancas() {
		return pecasBrancas;
	}

	public List<Peca> getPecasPretas() {
		return pecasPretas;
	}

}

