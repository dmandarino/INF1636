package modelos;


public class Peca {
	
	protected Casa casa;
	private PecaEnum nome;	
	
	public Casa andarPeca(Casa casaDestino){
        switch (nome) {
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

}
