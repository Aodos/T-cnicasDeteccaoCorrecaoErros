package tecnicas;

import javax.swing.JOptionPane;

public class TesteDeTecnicas {

	public static void main(String[] args) {
		Paridade p = new Paridade();
		Hamming h = new Hamming();
		CheckSum c= new CheckSum();
		
		String opcoes = "Selecione t�cnica de detec��o:\n"
					+ "1 - Paridade.\n"
					+ "2 - CRC\n"
					+ "3 - CHECKSUM\n"
					+ "4 - Hamming\n";
		String opcaoSelecionada = "";
		
		do {
			opcaoSelecionada = JOptionPane.showInputDialog(null, opcoes);
			
			switch (opcaoSelecionada) {
			case "1":
				System.out.println("Paridade");
				p.iniciaTecnica(JOptionPane.showInputDialog("Informe cadeia de bits"));
				JOptionPane.showMessageDialog(null, p.mensagem + "   <- Bit de paridade", "Resultado", JOptionPane.INFORMATION_MESSAGE);
				break;
			case "2":
				System.out.println("CRC");
				break;			
			case "3":
				System.out.println("CHECKSUM");
				c.Emissor();
				break;
			case "4":
				System.out.println("Hamming");
				h.iniciaHamming();
				break;
			}
			
		}while(opcaoSelecionada != null);
		
	}

}
