package service;

import java.awt.Image;
import java.util.HashMap;
import java.util.List;

import modelos.Casa;
import modelos.Peao;
import modelos.Peca;
import modelos.PecaEnum;
import modelos.Rainha;
import modelos.Rei;
import Exception.CasaOcupadaException;
import Exception.MoimentoInvalidoException;
import Exception.RemocaoComErroException;

public class MovimentoPeao implements Movimento<Peao>{

	public static final int CASA_VERT = 8;
	public static final int CASA_HOR = 1;
	
	private TomadaDePeca tomadaDePeca = new TomadaDePeca();
	private Image image;
	
	public MovimentoPeao(Image image) {
		this.image = image;
	}
	
	@Override
	public void andar(Peao p, Casa casaDestino, HashMap<Integer, Casa> casas, List<Peca> pecas) {
		try {
			if ( isCasaOcupadaMesmaCor(casaDestino, p))
				throw new CasaOcupadaException();
			
			Integer direcao = getDirecao(p, casaDestino);
			
			if ( isTomadaDePeca(casas.get(p.getCasa().getNumCasa() + direcao), casaDestino))
				tomadaDePeca.tomar(casas, p, casas.get(p.getCasa().getNumCasa() + direcao), pecas);
			if( movimentoValido(p, casaDestino)){
				casas.get(p.getCasa().getNumCasa()).setPeca(null);
				p.setCasa(casaDestino);
				casas.get(casaDestino.getNumCasa()).setPeca(p);
				isPromocaoPeao(p, casas, pecas);
			} 
			else
				throw new MoimentoInvalidoException();
		} catch(MoimentoInvalidoException e){
			
		} catch (CasaOcupadaException e) {
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean movimentoValido(Peao p, Casa casaDestino) {
		if(p.GetPrimeiroMovimento())
			return isPrimeiroMovimentoValidoBranco(p, casaDestino) || isPrimeiroMovimentoValidoPreto(p, casaDestino); 
		return isPecaBrancaECasaValida(p, casaDestino) || isPecaPretaECasaValida(p, casaDestino);
	}

	@Override
	public boolean isCasaOcupadaMesmaCor(Casa casa, Peao peao) {
		return casa.getPeca().isBranco().equals(peao.isBranco());
	}

	@Override
	public boolean isTomadaDePeca(Casa casa, Casa casaDestino) {
		return casa.getPeca() != null && casa.getNumCasa().equals(casaDestino.getNumCasa());
	}


	private boolean isPrimeiroMovimentoValidoPreto(Peao p, Casa casaDestino) {
		return (casaDestino.getNumCasa().equals(p.getCasa().getNumCasa() + 2*CASA_VERT) && p.isBranco()) || isPecaBrancaECasaValida(p, casaDestino);
	}

	private boolean isPrimeiroMovimentoValidoBranco(Peao p, Casa casaDestino) {
		return (casaDestino.getNumCasa().equals(p.getCasa().getNumCasa() - 2*CASA_VERT) && p.isBranco()) || isPecaBrancaECasaValida(p, casaDestino);
	}

	private boolean isPecaPretaECasaValida(Peao p, Casa casaDestino) {
		return casaDestino.getNumCasa().equals(p.getCasa().getNumCasa() + CASA_VERT) && !p.isBranco();
	}

	private boolean isPecaBrancaECasaValida(Peao p, Casa casaDestino) {
		return casaDestino.getNumCasa().equals(p.getCasa().getNumCasa() - CASA_VERT) && p.isBranco();
	}
	
	private boolean isMovDiagonal(Casa casaDestino, Peao p) {
		return !casaDestino.getX().equals(p.getCasa().getX()) && !casaDestino.getY().equals(p.getCasa().getY()); 
	}
	
	private Integer getDirecao(Peao p, Casa casaDestino) {
		if (isMovDiagonal(casaDestino, p)){
			if(casaDestino.getX() > p.getCasa().getX()){
				if(casaDestino.getY() < p.getCasa().getY() )
					return 1;
				else
					return 2;
			}
			
		}
		return null; 
	}
				
	
	private void isPromocaoPeao(Peao p, HashMap<Integer, Casa> casas, List<Peca> pecas){
		if(p.getCasa().getY().equals(Integer.valueOf(10)) || p.getCasa().getY().equals(Integer.valueOf(360))){
			try{
				for (Peca peca : pecas) {
					if(peca.getId().equals(p.getId())){
						pecas.remove(p);
						if (pecas.contains(p))
							throw new RemocaoComErroException();
					}
				}
			
			Rainha rainha = new Rainha();
			rainha.setTipo(PecaEnum.RAINHA);
			rainha.setCasa(casas.get(p.getCasa().getNumCasa()));
			rainha.setBranco(p.isBranco());
			rainha.setFigura(image);
			rainha.setId(p.getId());
			casas.get(p.getCasa().getNumCasa()).setPeca(rainha);
			pecas.add(rainha);
			
			}catch(RemocaoComErroException e) {
			}catch(Exception e) {
				System.out.println(e);
			}

		}
	}

}
