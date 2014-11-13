package service;

import Exception.CasaInvalidaException;
import Exception.CasaOcupadaException;
import modelos.Casa;
import modelos.Peao;

public class MoviementoPeao implements Movimento<Peao>{

	public static final int CASA_VERT = 8;
	public static final int CASA_HOR = 1;
	
	@Override
	public void andar(Peao p, Casa casaDestino) {
		try {
			if( isCasaOcupada(casaDestino) )
				throw new CasaOcupadaException();
			if( movimentoValido(p, casaDestino))
				p.setCasa(casaDestino);
			throw new CasaInvalidaException();
		} catch(CasaInvalidaException e){
			
		} catch (CasaOcupadaException e) {
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private boolean movimentoValido(Peao p, Casa casaDestino) {
		if(p.GetPrimeiroMovimento())
			return isPrimeiroMovimentoValidoBranco(p, casaDestino) || isPrimeiroMovimentoValidoPreto(p, casaDestino); 
		return isPecaBrancaECasaValida(p, casaDestino) || isPecaPretaECasaValida(p, casaDestino);
	}

	private boolean isCasaOcupada(Casa casaDestino) {
		return casaDestino.getPeca() != null;
	}

	private boolean isPrimeiroMovimentoValidoPreto(Peao p, Casa casaDestino) {
		return (casaDestino.getNumCasa() == p.getCasa().getNumCasa() + 2*CASA_VERT && p.isBranco()) || isPecaBrancaECasaValida(p, casaDestino);
	}

	private boolean isPrimeiroMovimentoValidoBranco(Peao p, Casa casaDestino) {
		return (casaDestino.getNumCasa() == p.getCasa().getNumCasa() - 2*CASA_VERT && p.isBranco()) || isPecaBrancaECasaValida(p, casaDestino);
	}

	private boolean isPecaPretaECasaValida(Peao p, Casa casaDestino) {
		return casaDestino.getNumCasa() == p.getCasa().getNumCasa() + CASA_VERT && !p.isBranco();
	}

	private boolean isPecaBrancaECasaValida(Peao p, Casa casaDestino) {
		return casaDestino.getNumCasa() == p.getCasa().getNumCasa() - CASA_VERT && p.isBranco();
	}

}
