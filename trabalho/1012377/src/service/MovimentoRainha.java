package service;

import java.util.HashMap;
import java.util.List;

import modelos.Casa;
import modelos.Peca;
import modelos.PecaEnum;
import modelos.Rainha;
import Exception.CasaOcupadaException;
import Exception.MoimentoInvalidoException;

public class MovimentoRainha implements Movimento<Rainha>{

	private static final int CIMA = -7;
	private static final int DIR = 2;
	private static final int ESQ = 0;
	private static final int BAIXO = 9;
	private static final int BAIXO_DIR = 10;
	private static final int BAIXO_ESQ = 8;
	private static final int CIMA_DIR = -6;
	private static final int CIMA_ESQ = -8;
	private Integer[] direcoes = {-7, 2, 0, 9, 10, 8, -6, -8};
	
	private TomadaDePeca tomadaDePeca = new TomadaDePeca();
	
	@Override
	public void andar(Rainha rainha, Casa casaDestino, HashMap<Integer, Casa> casas, List<Peca> pecas) {
		try{
			if ( isCasaOcupadaMesmaCor(casaDestino, rainha))
				throw new CasaOcupadaException();
 
			Integer direcao = getDirecao(rainha, casaDestino);

			if(movimentoValido(rainha, casaDestino)){
				rainha.setPrimeiroMovimento(false);
				while(pecaNaoEstaNaCasa(rainha, casaDestino)){
					if ( isCasaOcupadaMesmaCor(casas.get(rainha.getCasa().getNumCasa() + direcao), rainha))
						throw new CasaOcupadaException();

					if ( isTomadaDePeca(casas.get(rainha.getCasa().getNumCasa() + direcao), casaDestino))
						tomadaDePeca.tomar(casas, rainha, casas.get(rainha.getCasa().getNumCasa() + direcao), pecas);
					
					else if(movimentoValido(rainha, casas.get(rainha.getCasa().getNumCasa() + direcao))){
						rainha.setPrimeiroMovimento(false);
						casas.get(rainha.getCasa().getNumCasa()+1).setPeca(null);
						rainha.setCasa(casas.get(rainha.getCasa().getNumCasa() + direcao));
						casas.get(rainha.getCasa().getNumCasa()+1).setPeca(rainha);
					}
					else throw new MoimentoInvalidoException();
				}
				if(isCheck(rainha, casas))
					System.out.println("CHECK!");
			
			}else throw new MoimentoInvalidoException();
			} catch (MoimentoInvalidoException e) {
			} catch (CasaOcupadaException e) {
			} catch (Exception e) {
				System.out.println(e);
			}
	}

	private boolean pecaNaoEstaNaCasa(Rainha rainha, Casa casaDestino) {
		return !rainha.getCasa().getNumCasa().equals(casaDestino.getNumCasa());
	}

	private boolean isMovDiagonal(Casa casaDestino, Rainha rainha) {
		return !casaDestino.getX().equals(rainha.getCasa().getX()) && !casaDestino.getY().equals(rainha.getCasa().getY()); 
	}

	private Integer getDirecao(Rainha rainha, Casa casaDestino) {
		if (isMovDiagonal(casaDestino, rainha)){
			if(casaDestino.getX() > rainha.getCasa().getX()){
				if(casaDestino.getY() < rainha.getCasa().getY() ){
					return CIMA_DIR;
				} else {
					return BAIXO_DIR;
				}
			} else if (casaDestino.getY() < rainha.getCasa().getY()){
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

	@Override
	public boolean movimentoValido(Rainha rainha, Casa c) {
		return rainha.getCasa().getX().equals(c.getX()) || rainha.getCasa().getY().equals(c.getY()) ||
				(Math.abs(c.getX() - rainha.getCasa().getX()) == Math.abs(c.getY() - rainha.getCasa().getY()));
	}

	@Override
	public boolean isCasaOcupadaMesmaCor(Casa casa, Rainha rainha) {
		if(casa.getPeca() == null)
			return false;
		return casa.getPeca().isBranco().equals(rainha.isBranco());
	}

	@Override
	public boolean isTomadaDePeca(Casa casa, Casa casaDestino) {
		return casa.getPeca() != null && casa.getNumCasa().equals(casaDestino.getNumCasa());
	}

	@Override
	public void andar(Rainha e, Casa c, HashMap<Integer, Casa> casas,
			List<Peca> pecasAdversarias, List<Peca> pecasAmigas) {
		// TODO Auto-generated method stub
		
	}

	private boolean isCheck(Rainha rainha, HashMap<Integer, Casa> casas){
		for(int i=1; i <= direcoes.length; i++){
			Casa casa = casas.get(rainha.getCasa().getNumCasa()+direcoes[i]-1);
			while(casa.getPeca() != null){
				if(!isLimiteTabuleiro(casas.get(casa.getNumCasa()+1))){
					casa = casas.get(casa.getNumCasa()+direcoes[i]);
				} 
				else break;
			}
			if(casa.getPeca().getTipo().equals(PecaEnum.REI))
				return true;
		}
		return false;
	}

	private boolean isLimiteTabuleiro(Casa casa) {
		return casa.getNumCasa()%8 == 0 || casa.getNumCasa()%8 == 7;
	}

}
