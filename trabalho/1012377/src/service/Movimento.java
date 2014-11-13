package service;

import java.util.HashMap;

import modelos.Casa;

public interface Movimento <E>{

	public void andar(E e, Casa c, HashMap<Integer, Casa> casas);
	
	public boolean movimentoValido(E e, Casa c);

	public boolean isCasaOcupada(Casa c);

}
