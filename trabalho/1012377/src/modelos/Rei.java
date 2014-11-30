package modelos;


public class Rei extends Peca{

	public Rei (){
		super();
	}
	private boolean primeiroMovimento = true;

	public void setPrimeiroMovimento(boolean primeiroMovimento) {
		this.primeiroMovimento = primeiroMovimento;
	}
	
	public boolean isPrimeiroMovimento() {
		 return primeiroMovimento;
	}
	
	
}