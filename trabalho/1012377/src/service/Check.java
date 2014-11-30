package service;

import java.util.HashMap;

import javax.swing.JOptionPane;

import modelos.Casa;
import modelos.Peca;
import modelos.PecaEnum;

public class Check {

	private JOptionPane jOptionPane = new JOptionPane();
	
	public void verificaCheck(Peca peca, HashMap<Integer, Casa> casas, Integer[] direcoes) {
		for(int i=0; i < direcoes.length; i++){
			if(casas.get(peca.getCasa().getNumCasa()+direcoes[i]+1) == null)
				return;
			Casa casa = casas.get(peca.getCasa().getNumCasa()+direcoes[i]+1);
			while(casa.getPeca() == null){
				if(!isLimiteTabuleiro(casas.get(casa.getNumCasa()+1))){
					casa = casas.get(casa.getNumCasa()+direcoes[i]+1);
				} 
				else break;
			}
			if(casa.getPeca() != null)
				if(casa.getPeca().getTipo().equals(PecaEnum.REI))
					jOptionPane.showMessageDialog(null, "CHECK!");
		}
	}

	private boolean isLimiteTabuleiro(Casa casa) {
		return casa.getNumCasa()%8 == 0 || casa.getNumCasa()%8 == 7;
	}


}
