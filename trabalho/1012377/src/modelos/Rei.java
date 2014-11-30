package modelos;


public class Rei extends Peca{

	public Rei (){
		super();
	}
	private boolean primeiroMovimento;

	public void setPrimeiroMovimento(boolean primeiroMovimento) {
		this.primeiroMovimento = primeiroMovimento;
	}
	
	public boolean getPrimeiroMovimento() {
		 return primeiroMovimento;
	}
	
	
}