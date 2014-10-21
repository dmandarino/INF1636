package modelos;

public class Peca {
	
	private Casa casa;
	private PecaEnum nome;
	
	public PecaEnum getNome() {
		return nome;
	}

	public void setNome(PecaEnum nome) {
		this.nome = nome;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	public void print(){
		System.out.println("hello wolrd!");
	}
}
