package Exception;

import javax.swing.JOptionPane;

public class RemocaoComErroException extends Exception {
	
	private JOptionPane jOptionPane = new JOptionPane();
	
	public RemocaoComErroException() {
		jOptionPane.showMessageDialog(null, "ERRO AO REMOVER!");
		System.out.println("Ocorreu erro ao remover");
	}
}
