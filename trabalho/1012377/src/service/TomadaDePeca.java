package service;

import java.util.HashMap;
import java.util.List;

import Exception.RemocaoComErroException;
import modelos.Casa;
import modelos.Peca;

public class TomadaDePeca{

	public void tomar(HashMap<Integer, Casa> casas, Peca p, Casa casaDestino, List<Peca> pecas) {
		try{
			for (Peca peca : pecas) {
				if(peca.equals(casaDestino.getPeca())){
					if(!pecas.remove(casaDestino.getPeca()))
						throw new RemocaoComErroException();
				}
			}
		}catch(RemocaoComErroException e) {
		}catch(Exception e) {
			System.out.println(e);
		}

		casas.get(p.getCasa().getNumCasa()+1).setPeca(null);
		p.setCasa(casas.get(casaDestino));
		casas.get(p.getCasa().getNumCasa()).setPeca(p);
		
	}

}
