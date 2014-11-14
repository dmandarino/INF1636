package service;

import java.util.HashMap;

import modelos.Casa;
import modelos.Rei;

public class MovimentoRei implements Movimento<Rei>{

	@Override
	public void andar(Rei e, Casa c, HashMap<Integer, Casa> casas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean movimentoValido(Rei e, Casa c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCasaOcupada(Casa c) {
		// TODO Auto-generated method stub
		return false;
	}

}
