import javax.swing.JOptionPane;

public class Paridade {

	String mensagem;
	String[] bitRedundante = new String[2];
	int aux = 0;

	public void iniciaTecnica(String mensagem) {
		this.mensagem = mensagem;
		adicionaBitDeParidade(this.mensagem);
		JOptionPane.showMessageDialog(null, mensagem + " " + bitRedundante[0] + "   <- Bit de paridade", "Resultado",
				JOptionPane.INFORMATION_MESSAGE);

		aux++;
		simulaErro();

		aux = 0;
		mensagem = "";

	}

	private int verificaSeEParOuImpar(String mensagem) {
		int numeroDeUns = 0;

		for (char i : mensagem.toCharArray()) {

			if (i == '1') {
				numeroDeUns++;
			}
		}

		return numeroDeUns % 2;
	}

	private void adicionaBitDeParidade(String mensagem) {
		if (verificaSeEParOuImpar(mensagem) == 0) {
			bitRedundante[aux] = "0";
		} else {
			bitRedundante[aux] = "1";
		}
	}

	private void simulaErro() {
		String msgComErro;
		switch (JOptionPane.showInputDialog("Deseja simular erro??\n" + "1-SIM\n" + "2-NAO\n ")) {
		case "1":
			msgComErro = JOptionPane
					.showInputDialog("Mensagem sem erros: " + mensagem + "\n" + "Informar mensagem com um erro: ");
			JOptionPane.showMessageDialog(null, "Verificando nova msg", "Receptor", JOptionPane.INFORMATION_MESSAGE);
			adicionaBitDeParidade(msgComErro);

			if (bitRedundante[0] != bitRedundante[1]) {
				String msg;
				if (bitRedundante[0] == "0") {
					msg = "O bit redundante da msg original indica par e nova mensagem resulta em impar";
				}else {
					msg = "O bit redundante da msg original indica impar e nova mensagem resulta em par";
				}

				JOptionPane.showMessageDialog(null, "Nova msg com erro\n"+msg, "Receptor", JOptionPane.INFORMATION_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(null, "Alteracao para mensagem com erro esta com mais de um bit alterado ou a mensagem para simulacao e igual a original",
						"Receptor", JOptionPane.INFORMATION_MESSAGE);
			}

			break;
		case "2":
			break;
		}
	}
}
