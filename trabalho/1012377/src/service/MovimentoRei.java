package service;

import java.util.HashMap;

import modelos.Casa;
import modelos.Rei;
import Exception.CasaOcupadaException;
import Exception.MoimentoInvalidoException;

public class MovimentoRei implements Movimento<Rei>{
	
	private static final int CIMA = -7;
	private static final int DIR = 2;
	private static final int ESQ = 0;
	private static final int BAIXO = 9;
	private static final int BAIXO_DIR = 10;
	private static final int BAIXO_ESQ = 8;
	private static final int CIMA_DIR = -6;
	private static final int CIMA_ESQ = -8;
	
	
	@Override
	public void andar(Rei rei, Casa casaDestino, HashMap<Integer, Casa> casas) {
		try{
			if ( isCasaOcupada(casaDestino))
				throw new CasaOcupadaException();
			
			Integer direcao = getDirecao(rei, casaDestino);
			
			if(movimentoValido(rei, casaDestino)){
				if ( isCasaOcupada(casas.get(rei.getCasa().getNumCasa() + direcao)))
					throw new CasaOcupadaException();
				if(movimentoValido(rei, casas.get(rei.getCasa().getNumCasa() + direcao))){
					casas.get(rei.getCasa().getNumCasa()+1).setPeca(null);
					rei.setCasa(casas.get(rei.getCasa().getNumCasa() + direcao));
					casas.get(rei.getCasa().getNumCasa()).setPeca(rei);
				}
				else throw new MoimentoInvalidoException();
			}else throw new MoimentoInvalidoException();
		} catch (MoimentoInvalidoException e) {
		} catch (CasaOcupadaException e) {
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private boolean isMovDiagonal(Casa casaDestino, Rei rei) {
		return !casaDestino.getX().equals(rei.getCasa().getX()) && !casaDestino.getY().equals(rei.getCasa().getY()); 
	}

	private Integer getDirecao(Rei rei, Casa casaDestino) {
		if (isMovDiagonal(casaDestino, rei)){
			if(casaDestino.getX() > rei.getCasa().getX()){
				if(casaDestino.getY() < rei.getCasa().getY() ){
					return CIMA_DIR;
				} else {
					return BAIXO_DIR;
				}
			} else if (casaDestino.getY() < rei.getCasa().getY()){
				return CIMA_ESQ;
			}
			return BAIXO_ESQ;
		} 
		if(casaDestino.getX().equals(rei.getCasa().getX())){
			if(casaDestino.getY() > rei.getCasa().getY() ){
				return BAIXO;
			} else {
				return CIMA;
			}
		} else if (casaDestino.getX() > rei.getCasa().getX()){
			return DIR;
		}
		return ESQ;
	}

	@Override
	public boolean movimentoValido(Rei rei, Casa c) {
		return rei.getCasa().getX().equals(c.getX()) || rei.getCasa().getY().equals(c.getY()) ||
				(Math.abs(c.getX() - rei.getCasa().getX()) == Math.abs(c.getY() - rei.getCasa().getY()));
	}

	@Override
	public boolean isCasaOcupada(Casa casa) {
		return casa.getPeca() != null;
	}

}
