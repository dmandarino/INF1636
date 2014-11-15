package service;

import java.util.HashMap;

import modelos.Bispo;
import modelos.Casa;
import Exception.CasaOcupadaException;
import Exception.MoimentoInvalidoException;

public class MovimentoBispo implements Movimento<Bispo>{

	private static final int BAIXO_DIR = 8;
	private static final int BAIXO_ESQ = 6;
	private static final int CIMA_DIR = -6;
	private static final int CIMA_ESQ = -8;
	
	
	@Override
	public void andar(Bispo bispo, Casa casaDestino, HashMap<Integer, Casa> casas) {
		try {
			if ( isCasaOcupada(casaDestino))
				throw new CasaOcupadaException();
			
			Integer direcao = getDirecao(bispo, casaDestino);
			
			while(pecaNaoEstaNaCasa(bispo, casaDestino)){
				if ( isCasaOcupada(casas.get(bispo.getCasa().getNumCasa() + direcao)))
					throw new CasaOcupadaException();
				if(movimentoValido(bispo, casas.get(bispo.getCasa().getNumCasa() + direcao))){
					casas.get(bispo.getCasa().getNumCasa()+1).setPeca(null);
					bispo.setCasa(casas.get(bispo.getCasa().getNumCasa() + direcao));
					casas.get(bispo.getCasa().getNumCasa()).setPeca(bispo);
				}
				else throw new MoimentoInvalidoException();
			}
		} catch (CasaOcupadaException e) {
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private Integer getDirecao(Bispo bispo, Casa casaDestino) {
		if(casaDestino.getX() > bispo.getCasa().getX()){
			if(casaDestino.getY() > bispo.getCasa().getY() ){
				return CIMA_DIR;
			} else {
				return BAIXO_DIR;
			}
		} else if (casaDestino.getY() > bispo.getCasa().getY()){
			return CIMA_ESQ;
		}
		return BAIXO_ESQ;
	}
	
	private boolean pecaNaoEstaNaCasa(Bispo bispo, Casa casaDestino) {
		return !bispo.getCasa().getNumCasa().equals(casaDestino.getNumCasa());
	}

	@Override
	public boolean movimentoValido(Bispo bispo, Casa c) {
		return (c.getX() - bispo.getCasa().getX() == c.getY() - bispo.getCasa().getY());
	}

	@Override
	public boolean isCasaOcupada(Casa casa) {
		return casa.getPeca() != null;
	}

}
