package modelos;


public class Peao extends Peca{

	private Boolean primeiroMovimento;
	
	public Peao (){
		super();
		this.primeiroMovimento = true;
	}

	public Boolean GetPrimeiroMovimento() {
		return primeiroMovimento;
	}

	public void setPrimeiroMovimento(Boolean isPrimeiroMovimento) {
		this.primeiroMovimento = isPrimeiroMovimento;
	}
	
}