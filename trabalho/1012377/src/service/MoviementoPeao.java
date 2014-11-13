package service;

import java.util.HashMap;

import Exception.MoimentoInvalidoException;
import Exception.CasaOcupadaException;
import modelos.Casa;
import modelos.Peao;

public class MoviementoPeao implements Movimento<Peao>{

	public static final int CASA_VERT = 8;
	public static final int CASA_HOR = 1;
	
	@Override
	public void andar(Peao p, Casa casaDestino, HashMap<Integer, Casa> casas) {
		try {
			if( isCasaOcupada(casaDestino) )
				throw new CasaOcupadaException();
			if( movimentoValido(p, casaDestino)){
				casas.get(p.getCasa().getNumCasa()).setPeca(null);
				p.setCasa(casaDestino);
				casas.get(casaDestino.getNumCasa()).setPeca(p);
			}
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

	public boolean isCasaOcupada(Casa casaDestino) {
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
