package service;

import java.util.HashMap;

import modelos.Casa;
import modelos.Cavalo;
import Exception.CasaOcupadaException;
import Exception.MoimentoInvalidoException;

public class MovimentoCavalo implements Movimento<Cavalo>{

	private static final int DOIS_CIMA_UM_DIR = -14;
	private static final int DOIS_CIMA_UM_ESQ = -16;
	private static final int DOIS_DIR_UM_CIMA = -5;
	private static final int DOIS_DIR_UM_BAIXO = 11;
	private static final int DOIS_ESQ_UM_CIMA = -9;
	private static final int DOIS_ESQ_UM_BAIXO = 7;
	private static final int DOIS_BAIXO_UM_DIR = 18;
	private static final int DOIS_BAIXO_UM_ESQ = 16;
	
	private static final int UMA_CASA = 50;
	private static final int DUAS_CASAS = 100;
	
	@Override
	public void andar(Cavalo cavalo, Casa casaDestino, HashMap<Integer, Casa> casas) {
		try{
			if ( isCasaOcupada(casaDestino))
				throw new CasaOcupadaException();
			
			Integer direcao = getDirecao(cavalo, casaDestino);
			
			if(movimentoValido(cavalo, casaDestino)){
				casas.get(cavalo.getCasa().getNumCasa()+1).setPeca(null);
				cavalo.setCasa(casas.get(cavalo.getCasa().getNumCasa() + direcao));
				casas.get(cavalo.getCasa().getNumCasa()).setPeca(cavalo);
			}
			else throw new MoimentoInvalidoException();
		} catch (MoimentoInvalidoException e) {
		} catch (CasaOcupadaException e) {
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private Integer getDirecao(Cavalo cavalo, Casa casaDestino) {
		if(casaDestino.getX() > cavalo.getCasa().getX()){
			if(casaDestino.getY() < cavalo.getCasa().getY() ){
				if(umaCasaX(cavalo, casaDestino) )
					return DOIS_CIMA_UM_DIR;
				return DOIS_DIR_UM_CIMA;
			} else {
				if(umaCasaX(cavalo, casaDestino) )
					return DOIS_BAIXO_UM_DIR;
				return DOIS_DIR_UM_BAIXO;
			}
		} else if(casaDestino.getY() < cavalo.getCasa().getY() ){
			if(umaCasaX(cavalo, casaDestino) )
				return DOIS_CIMA_UM_ESQ;
			return DOIS_ESQ_UM_CIMA;
		}
		if(umaCasaX(cavalo, casaDestino) )
			return DOIS_BAIXO_UM_ESQ;
		return DOIS_ESQ_UM_BAIXO;
	}

	private boolean umaCasaX(Cavalo cavalo, Casa casaDestino) {
		return Math.abs(casaDestino.getX() - cavalo.getCasa().getX()) == UMA_CASA;
	}

	@Override
	public boolean movimentoValido(Cavalo cavalo, Casa casaDestino) {
		boolean doisY = Math.abs(casaDestino.getX() - cavalo.getCasa().getX()) == UMA_CASA && Math.abs(casaDestino.getY() - cavalo.getCasa().getY()) == DUAS_CASAS;
		boolean doisX = Math.abs(casaDestino.getX() - cavalo.getCasa().getX()) == DUAS_CASAS && Math.abs(casaDestino.getY() - cavalo.getCasa().getY()) == UMA_CASA;
		return doisY || doisX;
	}

	@Override
	public boolean isCasaOcupada(Casa casa) {
		return casa.getPeca() != null;
	}

}
