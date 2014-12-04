package service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import modelos.Peca;

public class Arquivo { 
	
	public void salvaJogo(List<Peca> pecasPretas, List<Peca> pecasBrancas) throws IOException{
				
		FileWriter arq = new FileWriter("jogo.txt"); 
		PrintWriter gravarArq = new PrintWriter(arq); 
		
		for (Peca peca : pecasBrancas) {
			gravarArq.printf(" %2d | %s | %s %n", peca.getCasa().getNumCasa(), peca.getTipo().toString(), peca.isBranco());
		}
		
		for (Peca peca : pecasPretas) {
			gravarArq.printf(" %2d | %s | %s %n", peca.getCasa().getNumCasa(), peca.getTipo().toString(), peca.isBranco());
		}
		
//		for (HashMap.Entry<Integer, Casa> casa : casas.entrySet()) {
//			if(casa.getValue().getPeca() != null)
//			
//			gravarArq.printf("| %2d | %s |\n", casa.getValue().getNumCasa(), casa.getValue().getPeca().getTipo().toString());
//		}
		arq.close(); 
		
	} 
}