

import javax.swing.JOptionPane;

public class NetworkMain {

	public static void main(String[] args) {
		Paridade p = new Paridade();
		Hamming h = new Hamming();
		Crc c= new Crc();
		Checksum v = new Checksum();
		String opcoes = "Selecione técnica de detecção:\n"
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
				
				break;
			case "2":
				
                     System.out.println("CRC");
                     c.Emissor();
				break;			
			case "3":
				System.out.println("CHECKSUM");
				v.emissor();
				break;
			case "4":
				String bloco;
				String mensagemJP = "Digite o bloco a ser recebido: " ;
				 bloco= JOptionPane.showInputDialog(mensagemJP);
				 v.receptor(bloco);
				break;
				
			case "5":
				System.out.println("Hamming");
				h.hamming();
				break;
			}
			
		}while(opcaoSelecionada != null);
		
	}

}
