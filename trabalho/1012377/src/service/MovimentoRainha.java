package service;

import java.util.HashMap;

import modelos.Casa;
import modelos.Rainha;

public class MovimentoRainha implements Movimento<Rainha>{

	@Override
	public void andar(Rainha e, Casa c, HashMap<Integer, Casa> casas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean movimentoValido(Rainha e, Casa c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCasaOcupada(Casa c) {
		// TODO Auto-generated method stub
		return false;
	}

}
