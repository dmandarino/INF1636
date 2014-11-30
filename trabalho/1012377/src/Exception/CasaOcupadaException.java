package Exception;

import javax.swing.JOptionPane;

public class CasaOcupadaException extends Exception {
	
	private JOptionPane jOptionPane = new JOptionPane();
	
	public CasaOcupadaException() {
		jOptionPane.showMessageDialog(null, "CASA JÁ ESTÁ OCUPADA!");
		System.out.println("CasaEstaOcupada");
	}
}
