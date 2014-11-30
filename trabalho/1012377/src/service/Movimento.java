package service;

import java.util.HashMap;
import java.util.List;

import modelos.Casa;
import modelos.Peca;

public interface Movimento <E>{

	public void andar(E e, Casa c, HashMap<Integer, Casa> casas, List<Peca> pecas);
	
	public void andar(E e, Casa c, HashMap<Integer, Casa> casas, List<Peca> pecasAdversarias, List<Peca> pecasAmigas);
	
	public boolean movimentoValido(E e, Casa c);

	public boolean isCasaOcupadaMesmaCor(Casa casa, E e);
	
	public boolean isTomadaDePeca(Casa casa, Casa casaDestino);

}
