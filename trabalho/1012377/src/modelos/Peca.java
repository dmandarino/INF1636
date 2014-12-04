package modelos;

import java.awt.Image;


public class Peca {
	
	protected Casa casa;
	private PecaEnum tipo;
	private Image figura;
	private Boolean isBranco;
	private Boolean primeiroMovimento = true;
	private Long id;
	

	public Boolean isBranco() {
		return isBranco;
	}

	public void setBranco(Boolean isBranco) {
		this.isBranco = isBranco;
	}

	public Image getFigura() {
		return figura;
	}

	public void setFigura(Image figura) {
		this.figura = figura;
	}

	public Casa getCasa() {
		return casa;
	}
	
	public void setPrimeiroMovimento(boolean primeiroMovimento) {
		this.primeiroMovimento = primeiroMovimento;
	}
	
	public boolean isPrimeiroMovimento() {
		 return primeiroMovimento;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	public PecaEnum getTipo() {
		return tipo;
	}

	public void setTipo(PecaEnum tipo) {
		this.tipo = tipo;
	}

	public void setIsBranco(Boolean isBranco) {
		this.isBranco = isBranco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
