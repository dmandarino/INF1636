package modelos;

public enum PecaEnum {
	
	PEAO(1), TORRE(2), CAVALO(3), BISPO(4), RAINHA(5), REI(6);
	
	public Integer peca;
	
	PecaEnum(Integer peca){
		this.peca = peca;
	}
}
