package service;

import java.util.HashMap;
import java.util.List;

import modelos.Casa;
import modelos.Peca;
import modelos.Torre;
import Exception.CasaOcupadaException;
import Exception.MoimentoInvalidoException;

public class MovimentoTorre implements Movimento<Torre>{

	private static final int CIMA = -7;
	private static final int DIR = 2;
	private static final int ESQ = 0;
	private static final int BAIXO = 9;
	private Integer[] direcoes = {-7, 2, 0, 9};
	
	private TomadaDePeca tomadaDePeca = new TomadaDePeca();
	private Check check = new Check();
	@Override
	public void andar(Torre t, Casa casaDestino, HashMap<Integer, Casa> casas, List<Peca> pecas) {
		try {
			if ( isCasaOcupadaMesmaCor(casaDestino, t))
				throw new CasaOcupadaException();
			
			Integer direcao = getDirecao(t, casaDestino);
			
			if(movimentoValido(t, casaDestino)){
				while(pecaNaoEstaNaCasa(t, casaDestino)){
					if ( isCasaOcupadaMesmaCor(casas.get(t.getCasa().getNumCasa() + direcao), t))
						throw new CasaOcupadaException();
					if ( isTomadaDePeca(casas.get(t.getCasa().getNumCasa() + direcao), casaDestino))
						tomadaDePeca.tomar(casas, t, casas.get(t.getCasa().getNumCasa() + direcao), pecas);
					else if(movimentoValido(t, casas.get(t.getCasa().getNumCasa() + direcao))){
						casas.get(t.getCasa().getNumCasa()+1).setPeca(null);
						t.setCasa(casas.get(t.getCasa().getNumCasa() + direcao));
						casas.get(t.getCasa().getNumCasa()+1).setPeca(t);
					}
					else throw new MoimentoInvalidoException();
				}
				check.verificaCheck(t, casas, direcoes);
			}else throw new MoimentoInvalidoException();
		} catch (MoimentoInvalidoException e) {
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
	public boolean isCasaOcupadaMesmaCor(Casa casa, Torre torre) {
		if(casa.getPeca() == null)
			return false;
		return casa.getPeca().isBranco().equals(torre.isBranco());
	}

	@Override
	public boolean isTomadaDePeca(Casa casa, Casa casaDestino) {
		return casa.getPeca() != null && casa.getNumCasa().equals(casaDestino.getNumCasa());
	}

	@Override
	public void andar(Torre e, Casa c, HashMap<Integer, Casa> casas,
			List<Peca> pecasAdversarias, List<Peca> pecasAmigas) {
		
	}

}
