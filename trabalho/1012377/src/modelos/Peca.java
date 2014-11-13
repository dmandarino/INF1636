package modelos;

import java.awt.Image;


public class Peca {
	
	protected Casa casa;
	private PecaEnum tipo;
	private Image figura;
	private Boolean isBranco;
	

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

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	public PecaEnum getTipo() {
		return tipo;
	}

	public void setTipo(PecaEnum tipo) {
		this.tipo = tipo;
	}

}
