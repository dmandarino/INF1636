package Exception;

import javax.swing.JOptionPane;

public class CasaOcupadaException extends Exception {
	
	private JOptionPane jOptionPane = new JOptionPane();
	
	public CasaOcupadaException() {
		jOptionPane.showMessageDialog(null, "CASA J� EST� OCUPADA!");
		System.out.println("CasaEstaOcupada");
	}
}
