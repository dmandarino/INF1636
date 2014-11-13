package service;

import java.util.HashMap;

import modelos.Casa;
import modelos.Torre;
import Exception.CasaOcupadaException;
import Exception.MoimentoInvalidoException;

public class MovimentoTorre implements Movimento<Torre>{

	private static final int CIMA = -8;
	private static final int DIR = 1;
	private static final int ESQ = -1;
	private static final int BAIXO = 8;
	
	@Override
	public void andar(Torre t, Casa casaDestino, HashMap<Integer, Casa> casas) {
		try {
			if ( isCasaOcupada(casaDestino))
				throw new CasaOcupadaException();
			
			Integer direcao = getDirecao(t, casaDestino);
			
			while(isPecaNotNaCasa(t, casaDestino)){
				if(movimentoValido(t, casas.get(t.getCasa().getNumCasa() + direcao))){
					casas.get(t.getCasa().getNumCasa()).setPeca(null);
					t.setCasa(casas.get(t.getCasa().getNumCasa() + direcao));
					casas.get(t.getCasa().getNumCasa()).setPeca(t);
				}
				throw new MoimentoInvalidoException();
			}

		} catch (CasaOcupadaException e) {
		} catch (Exception e) {
		}
	}

	private boolean isPecaNotNaCasa(Torre t, Casa casaDestino) {
		return casaDestino.getY() != t.getCasa().getY() && casaDestino.getX() != t.getCasa().getX();
	}

	private int getDirecao(Torre t, Casa casaDestino) {
		if(casaDestino.getX() == t.getCasa().getX()){
			if(casaDestino.getY() > t.getCasa().getY() ){
				return CIMA;
			} else {
				return BAIXO;
			}
		} else if (casaDestino.getX() > t.getCasa().getX()){
			return DIR;
		}
		return ESQ;
	}

	@Override
	public boolean movimentoValido(Torre t, Casa c) {
		return t.getCasa().getX().equals(c.getX()) || t.getCasa().getY().equals(c.getY()); 
	}

	@Override
	public boolean isCasaOcupada(Casa casaDestino) {
		return casaDestino.getPeca() != null;
	}

}
