package service;

import java.util.HashMap;
import java.util.List;

import modelos.Casa;
import modelos.Peca;
import Exception.RemocaoComErroException;

public class TomadaDePeca{

	public void tomar(HashMap<Integer, Casa> casas, Peca p, Casa casaDestino, List<Peca> pecas) {
		Peca peca = casaDestino.getPeca();
		try{
			pecas.remove(casaDestino.getPeca());
			if(pecas.contains(peca))
				throw new RemocaoComErroException();
			casas.get(p.getCasa().getNumCasa()).setPeca(null);
			p.setCasa(casas.get(casaDestino.getNumCasa()+1));
			casas.get(p.getCasa().getNumCasa()+1).setPeca(p);
		}catch(RemocaoComErroException e) {
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
