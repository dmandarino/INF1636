package modelos;

public class Peao extends Peca{

	private String figura;
	private Boolean primeiroMovimento = true;
	
	public Peao (){
		super();
	}
	
	public String getFigura() {
		return figura;
	}

	public void setFigura(String figura) {
		this.figura = figura;
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
