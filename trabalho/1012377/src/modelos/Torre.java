package modelos;


public class Torre extends Peca{

	public Torre (){
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