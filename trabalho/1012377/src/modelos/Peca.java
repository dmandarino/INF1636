package modelos;

import java.awt.Image;


public class Peca {
	
	protected Casa casa;
	private PecaEnum tipo;
	private String nome;
	private Integer x;
	private Integer y;
	private Image figura;
	
	public Casa andarPeca(Casa casaDestino){
        switch (tipo) {
            case PEAO:
                Peao p = new Peao();
            	casa = p.andarPeca(casa, casaDestino);
                break;
            case TORRE:
                System.out.println("Segunda-feira");
                break;
            case CAVALO:
                System.out.println("Terça-feira");
                break;
            case BISPO:
                System.out.println("Quarta-feira");
                break;
            case RAINHA:
                System.out.println("Quinta-feira");
                break;
            case REI:
                System.out.println("Sexta-feira");
                break;
        }
        return casa;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}
	
}
