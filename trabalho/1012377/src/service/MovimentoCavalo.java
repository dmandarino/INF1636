package service;

import java.util.HashMap;

import modelos.Casa;
import modelos.Cavalo;

public class MovimentoCavalo implements Movimento<Cavalo>{

	@Override
	public void andar(Cavalo e, Casa c, HashMap<Integer, Casa> casas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean movimentoValido(Cavalo e, Casa c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCasaOcupada(Casa c) {
		// TODO Auto-generated method stub
		return false;
	}

}
