package modelos;


public class Cavalo extends Peca{

	private Boolean primeiroMovimento = true;
	
	public Cavalo (){
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