package service;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

import modelos.Casa;
import modelos.Peao;
import modelos.Peca;
import modelos.PecaEnum;
import modelos.Rainha;
import Exception.CasaOcupadaException;
import Exception.MoimentoInvalidoException;
import Exception.RemocaoComErroException;

public class MovimentoPeao implements Movimento<Peao>{

	private static final int CIMA = -7;
	private static final int BAIXO = 9;
	
	private TomadaDePeca tomadaDePeca = new TomadaDePeca();
	private Image imageBranca;
	private Image imagePreta;
	
	@Override
	public void andar(Peao p, Casa casaDestino, HashMap<Integer, Casa> casas, List<Peca> pecasAdversarias, List<Peca> pecasAmigas) {
		try {
			if ( isCasaOcupadaMesmaCor(casaDestino, p))
				throw new CasaOcupadaException();
			
			Integer direcao = getDirecao(p, casaDestino);
			
			if(movimentoValido(p, casaDestino)){
				while(pecaNaoEstaNaCasa(p, casaDestino)){
					if ( isCasaOcupadaMesmaCor(casas.get(p.getCasa().getNumCasa() + direcao), p))
						throw new CasaOcupadaException();
					
					if ( isTomadaDePeca(casas.get(p.getCasa().getNumCasa() + direcao), casaDestino))
						tomadaDePeca.tomar(casas, p, casas.get(p.getCasa().getNumCasa() + direcao), pecasAdversarias);
//						tomar(casas, t, casas.get(t.getCasa().getNumCasa() + direcao), pecas);
					
					else if(movimentoValido(p, casas.get(p.getCasa().getNumCasa() + direcao))){
						p.setPrimeiroMovimento(false);
						casas.get(p.getCasa().getNumCasa()+1).setPeca(null);
						p.setCasa(casas.get(p.getCasa().getNumCasa() + direcao));
						casas.get(p.getCasa().getNumCasa()+1).setPeca(p);
						isPromocaoPeao(p, casas, pecasAmigas);
					}
					else throw new MoimentoInvalidoException();
				}
			}else throw new MoimentoInvalidoException();
		} catch (MoimentoInvalidoException e) {
		} catch (CasaOcupadaException e) {
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private boolean pecaNaoEstaNaCasa(Peao p, Casa casaDestino) {
		return !p.getCasa().getNumCasa().equals(casaDestino.getNumCasa());
	}

	public boolean movimentoValido(Peao p, Casa c) {
		if(p.GetPrimeiroMovimento())
			return p.getCasa().getX().equals(c.getX()) && andarDuasCasas(p, c);
		return p.getCasa().getX().equals(c.getX()) && andarUmaCasa(p, c); 
	}
	
	private boolean andarUmaCasa(Peao p, Casa c) {
		return Math.abs(c.getY() - p.getCasa().getY()) == 50;
	}
	
	private boolean andarDuasCasas(Peao p, Casa c) {
		return Math.abs(c.getY() - p.getCasa().getY()) == 50 || Math.abs(c.getY() - p.getCasa().getY()) == 100;
	}

	@Override
	public boolean isCasaOcupadaMesmaCor(Casa casa, Peao peao) {
		if (casa.getPeca() == null)
			return false;
		else if(casa.getPeca() != null && peao.getCasa().getX().equals(casa.getX()))
			return true;
		return casa.getPeca().isBranco().equals(peao.isBranco());
	}

	@Override
	public boolean isTomadaDePeca(Casa casa, Casa casaDestino) {
		return casa.getPeca() != null && casa.getNumCasa().equals(casaDestino.getNumCasa());
	}

	private boolean isMovDiagonal(Casa casaDestino, Peao p) {
		return !casaDestino.getX().equals(p.getCasa().getX()) && !casaDestino.getY().equals(p.getCasa().getY()); 
	}
	
	private int getDirecao(Peao p, Casa casaDestino) {
			if(casaDestino.getY() > p.getCasa().getY() && !p.isBranco() ){
				return BAIXO;
			} else {
				return CIMA;
			}
	}

	private void isPromocaoPeao(Peao p, HashMap<Integer, Casa> casas, List<Peca> pecas){
		if(p.getCasa().getY().equals(Integer.valueOf(10)) || p.getCasa().getY().equals(Integer.valueOf(360))){
			try{
				pecas.remove(p);
				if(pecas.contains(p))
					throw new RemocaoComErroException();
				
				casas.get(p.getCasa().getNumCasa()).setPeca(null);
				
				try
				{
					imageBranca	= ImageIO.read(new File("Pecas/b_dama.png"));
					imagePreta	= ImageIO.read(new File("Pecas/p_dama.png"));
				}
				catch(IOException e)
				{
					System.out.println(e.getMessage());
				}

				Rainha rainha = new Rainha();
				rainha.setTipo(PecaEnum.RAINHA);
				rainha.setBranco(p.isBranco());
				rainha.setId(p.getId());
				if(rainha.isBranco()){
					rainha.setFigura(imageBranca);
				}else{
					rainha.setFigura(imagePreta);
				}
				casas.get(p.getCasa().getNumCasa()+1).setPeca(rainha);
				rainha.setCasa(casas.get(p.getCasa().getNumCasa() + 1));
					
				pecas.add(rainha);
			}catch(RemocaoComErroException e) {
			}catch(Exception e) {
				System.out.println(e);
			}

		}
	}

	@Override
	public void andar(Peao e, Casa c, HashMap<Integer, Casa> casas,
			List<Peca> pecas) {
		// TODO Auto-generated method stub
		
	}
}
