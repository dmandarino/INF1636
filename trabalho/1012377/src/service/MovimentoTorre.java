package service;

import java.util.HashMap;

import modelos.Casa;
import modelos.Torre;
import Exception.CasaOcupadaException;
import Exception.MoimentoInvalidoException;

public class MovimentoTorre implements Movimento<Torre>{

	private static final int CIMA = -7;
	private static final int DIR = 2;
	private static final int ESQ = 0;
	private static final int BAIXO = 7;
	
	@Override
	public void andar(Torre t, Casa casaDestino, HashMap<Integer, Casa> casas) {
		try {
			if ( isCasaOcupada(casaDestino))
				throw new CasaOcupadaException();
			
			Integer direcao = getDirecao(t, casaDestino);
			
			while(pecaNaoEstaNaCasa(t, casaDestino)){
				if ( isCasaOcupada(casas.get(t.getCasa().getNumCasa() + direcao)))
					throw new CasaOcupadaException();
				if(movimentoValido(t, casas.get(t.getCasa().getNumCasa() + direcao))){
					casas.get(t.getCasa().getNumCasa()+1).setPeca(null);
					if(direcao.equals(BAIXO))
						t.setCasa(casas.get(t.getCasa().getNumCasa() + direcao + 2));
					else if (direcao.equals(ESQ))
						t.setCasa(casas.get(t.getCasa().getNumCasa()));
					else
						t.setCasa(casas.get(t.getCasa().getNumCasa() + direcao));
					casas.get(t.getCasa().getNumCasa()).setPeca(t);
				}
				else throw new MoimentoInvalidoException();
			}
		} catch (CasaOcupadaException e) {
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private boolean pecaNaoEstaNaCasa(Torre t, Casa casaDestino) {
		return !t.getCasa().getNumCasa().equals(casaDestino.getNumCasa());
	}
	
	private int getDirecao(Torre t, Casa casaDestino) {
		if(casaDestino.getX().equals(t.getCasa().getX())){
			if(casaDestino.getY() > t.getCasa().getY() ){
				return BAIXO;
			} else {
				return CIMA;
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
	public boolean isCasaOcupada(Casa casa) {
		return casa.getPeca() != null;
	}

}
