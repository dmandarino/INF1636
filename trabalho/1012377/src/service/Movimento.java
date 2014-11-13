package service;

import modelos.Casa;

public interface Movimento <E>{

	public void andar(E e, Casa c);
}
