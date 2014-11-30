package service;

import java.util.HashMap;
import java.util.List;

import modelos.Casa;
import modelos.Peca;
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
	
	private TomadaDePeca tomadaDePeca = new TomadaDePeca();
	
	@Override
	public void andar(Rei rei, Casa casaDestino, HashMap<Integer, Casa> casas, List<Peca> pecas) {
		try{
			if ( isCasaOcupadaMesmaCor(casaDestino, rei))
				throw new CasaOcupadaException();
			
			Integer direcao = getDirecao(rei, casaDestino);
			
			if(movimentoValido(rei, casaDestino)){
				if ( isCasaOcupadaMesmaCor(casas.get(rei.getCasa().getNumCasa() + direcao), rei))
					throw new CasaOcupadaException();
				if ( isTomadaDePeca(casas.get(rei.getCasa().getNumCasa() + direcao), casaDestino))
					tomadaDePeca.tomar(casas, rei, casas.get(rei.getCasa().getNumCasa() + direcao), pecas);
				else if(movimentoValido(rei, casas.get(rei.getCasa().getNumCasa() + direcao))){
					casas.get(rei.getCasa().getNumCasa()+1).setPeca(null);
					rei.setCasa(casas.get(rei.getCasa().getNumCasa() + direcao));
					casas.get(rei.getCasa().getNumCasa()+1).setPeca(rei);
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
	public boolean isCasaOcupadaMesmaCor(Casa casa, Rei rei) {
		if(casa.getPeca() == null)
			return false;
		return casa.getPeca().isBranco().equals(rei.isBranco());
	}

	@Override
	public boolean isTomadaDePeca(Casa casa, Casa casaDestino) {
		return casa.getPeca() != null && casa.getNumCasa().equals(casaDestino.getNumCasa());
	}

	@Override
	public void andar(Rei e, Casa c, HashMap<Integer, Casa> casas,
			List<Peca> pecasAdversarias, List<Peca> pecasAmigas) {
		// TODO Auto-generated method stub
		
	}

}
