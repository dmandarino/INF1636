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

	public Casa andarPeca(Casa casaDestino) {
		if(primeiroMovimento){
			if(casaDestino.getY() == super.casa.getY()+2)
				super.casa.setY(casaDestino.getY());
			else if ( casaDestino.getY() == super.casa.getY()+1 )
				super.casa.setY(casaDestino.getY());
		}
		return super.casa;
	}
}
