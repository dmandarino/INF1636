package service;

import java.util.HashMap;

import modelos.Bispo;
import modelos.Casa;

public class MovimentoBispo implements Movimento<Bispo>{

	@Override
	public void andar(Bispo e, Casa c, HashMap<Integer, Casa> casas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean movimentoValido(Bispo e, Casa c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCasaOcupada(Casa c) {
		// TODO Auto-generated method stub
		return false;
	}

}
