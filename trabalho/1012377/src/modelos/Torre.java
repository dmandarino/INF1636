package modelos;


public class Torre extends Peca{

	private Boolean primeiroMovimento = true;
	
	public Torre (){
		super();
	}
	
	public Casa andarPeca(Casa casa, Casa casaDestino) {
		if(primeiroMovimento){
			if(casaDestino.getY() == casa.getY()+2)
				casa.setY(casaDestino.getY());
			else if ( casaDestino.getY() == casa.getY()+1 )
				casa.setY(casaDestino.getY());
		}
		return casa;
	}
}