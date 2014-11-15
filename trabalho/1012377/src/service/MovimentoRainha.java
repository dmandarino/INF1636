package service;

import java.util.HashMap;

import modelos.Casa;
import modelos.Rainha;
import Exception.CasaOcupadaException;
import Exception.MoimentoInvalidoException;

public class MovimentoRainha implements Movimento<Rainha>{

	private static final int CIMA = -7;
	private static final int DIR = 1;
	private static final int ESQ = -1;
	private static final int BAIXO = 7;
	private static final int BAIXO_DIR = 8;
	private static final int BAIXO_ESQ = 6;
	private static final int CIMA_DIR = -6;
	private static final int CIMA_ESQ = -8;
	
	
	@Override
	public void andar(Rainha rainha, Casa casaDestino, HashMap<Integer, Casa> casas) {
		try {
			if ( isCasaOcupada(casaDestino))
				throw new CasaOcupadaException();
			
			Integer direcao = getDirecao(rainha, casaDestino);
			
			while(pecaNaoEstaNaCasa(rainha, casaDestino)){
				if ( isCasaOcupada(casas.get(rainha.getCasa().getNumCasa() + direcao)))
					throw new CasaOcupadaException();
				if(movimentoValido(rainha, casas.get(rainha.getCasa().getNumCasa() + direcao))){
					casas.get(rainha.getCasa().getNumCasa()+1).setPeca(null);
					rainha.setCasa(casas.get(rainha.getCasa().getNumCasa() + direcao));
					casas.get(rainha.getCasa().getNumCasa()).setPeca(rainha);
				}
				else throw new MoimentoInvalidoException();
			}
		} catch (CasaOcupadaException e) {
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private boolean isMovDiagonal(Casa casaDestino, Rainha rainha) {
		return !casaDestino.getX().equals(rainha.getCasa().getX()) && !casaDestino.getY().equals(rainha.getCasa().getY()); 
	}

	private Integer getDirecao(Rainha rainha, Casa casaDestino) {
		if (isMovDiagonal(casaDestino, rainha)){
			if(casaDestino.getX() > rainha.getCasa().getX()){
				if(casaDestino.getY() > rainha.getCasa().getY() ){
					return CIMA_DIR;
				} else {
					return BAIXO_DIR;
				}
			} else if (casaDestino.getY() > rainha.getCasa().getY()){
				return CIMA_ESQ;
			}
			return BAIXO_ESQ;
		} 
		if(casaDestino.getX().equals(rainha.getCasa().getX())){
			if(casaDestino.getY() > rainha.getCasa().getY() ){
				return BAIXO;
			} else {
				return CIMA;
			}
		} else if (casaDestino.getX() > rainha.getCasa().getX()){
			return DIR;
		}
		return ESQ;
	}
	
	private boolean pecaNaoEstaNaCasa(Rainha rainha, Casa casaDestino) {
		return !rainha.getCasa().getNumCasa().equals(casaDestino.getNumCasa());
	}

	@Override
	public boolean movimentoValido(Rainha rainha, Casa c) {
		return rainha.getCasa().getX().equals(c.getX()) || rainha.getCasa().getY().equals(c.getY()) ||
				(c.getX().equals(rainha.getCasa().getX()) && c.getY().equals(rainha.getCasa().getY()));
	}

	@Override
	public boolean isCasaOcupada(Casa casa) {
		return casa.getPeca() != null;
	}


}
