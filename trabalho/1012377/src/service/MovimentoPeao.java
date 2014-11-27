package service;

import java.awt.Image;
import java.util.HashMap;
import java.util.List;

import modelos.Casa;
import modelos.Peao;
import modelos.Peca;
import modelos.PecaEnum;
import modelos.Rainha;
import Exception.CasaOcupadaException;
import Exception.MoimentoInvalidoException;
import Exception.RemocaoComErroException;

public class MovimentoPeao implements Movimento<Peao>{

	public static final int CASA_VERT = 8;
	public static final int CASA_HOR = 1;
	
	
	private Image image;
	
	public MovimentoPeao(Image image) {
		this.image = image;
	}
	
	@Override
	public void andar(Peao p, Casa casaDestino, HashMap<Integer, Casa> casas, List<Peca> pecas) {
		try {
			if( isCasaOcupadaMesmaCor(casaDestino, p) )
				throw new CasaOcupadaException();
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
	
	private void isPromocaoPeao(Peao p, HashMap<Integer, Casa> casas, List<Peca> pecas){
		if(p.getCasa().getY().equals(Integer.valueOf(10)) || p.getCasa().getY().equals(Integer.valueOf(360))){
			Rainha rainha = new Rainha();
			rainha.setTipo(PecaEnum.RAINHA);
			rainha.setCasa(casas.get(p.getCasa().getNumCasa()));
			rainha.setBranco(p.isBranco());
			rainha.setFigura(image);
			casas.get(p.getCasa().getNumCasa()).setPeca(rainha);
			
			try{
				for (Peca peca : pecas) {
					if(peca.equals(p)){
						if(!pecas.remove(p))
							throw new RemocaoComErroException();
					}
				}
			}catch(RemocaoComErroException e) {
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}

}
