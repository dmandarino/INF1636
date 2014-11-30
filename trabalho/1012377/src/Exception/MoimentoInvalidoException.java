package Exception;

import javax.swing.JOptionPane;

public class MoimentoInvalidoException extends Exception {
	
	private JOptionPane jOptionPane = new JOptionPane();
	
	public MoimentoInvalidoException() {
		jOptionPane.showMessageDialog(null, "MOVIMENTO INVALIDO");
		System.out.println("Movimento invalido");
	}
}
