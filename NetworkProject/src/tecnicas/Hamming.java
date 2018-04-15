package tecnicas;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Hamming {
	private String msg;
	private int r;
	private ArrayList<Character> mensagemMaisRedundantes = new ArrayList<Character>();
	private ArrayList<Character> mensagemErradaMaisRedundantes = new ArrayList<Character>();
	private String resultadoRedundantesReceptor = "";
	
	public void hamming() {
		msg = JOptionPane.showInputDialog("Informar mensagem: ");

		calculaQntDeRedundantes();
		adicionaRedundantesNaMsg();
		calculaSubstituiR();
		
		msg = "";
		for(int i = mensagemMaisRedundantes.size()-1; i >= 0 ; i--) {
			msg = msg.concat(mensagemMaisRedundantes.get(i).toString());	
		}
		
		
		JOptionPane.showMessageDialog(null, "Mensagem \"Hammingficada\" = "+msg, "Resultado", JOptionPane.INFORMATION_MESSAGE);
		
		simulandoErro();
		
		msg = "";
		r = 0;
		mensagemMaisRedundantes.clear();
		mensagemErradaMaisRedundantes.clear();
		resultadoRedundantesReceptor = "";
	}
	
	private void simulandoErro() {
		String msgComErro = "";
		switch (JOptionPane.showInputDialog("Deseja simular erro??\n"
				+ "1-SIM\n"
				+ "2-NAO\n ")) {
		case "1":
			msgComErro = JOptionPane.showInputDialog("Mensagem sem erros: "+msg+"\n"
					+ "Informar mensagem com erro: ");
			
			for (int i = msg.length() - 1; i >= 0; i--) {
				mensagemErradaMaisRedundantes.add(msgComErro.toCharArray()[i]);
			}
			
			calculaRedundantesReceptor();
			
			int posicaoErrada = 0;
			int aux = 0;
			int aux2 = 0;
			for(int i = resultadoRedundantesReceptor.length()-1; i >= 0 ; i--) {
				aux = Character.getNumericValue(resultadoRedundantesReceptor.toCharArray()[i]);
				aux2 = (int) Math.pow(2, i);
				posicaoErrada = posicaoErrada + (aux * aux2);
			}
			
			JOptionPane.showMessageDialog(null, "Erro posicao = " +posicaoErrada+"\n"
					+ "Realizando correcao", "Resultado", JOptionPane.INFORMATION_MESSAGE);
			
			System.out.println(Arrays.toString(mensagemErradaMaisRedundantes.toArray()));
			
			break;
		case "2":
			break;
		}
	}

	private void calculaQntDeRedundantes() {
		boolean interruptor = true;

		do {
			r++;
			if (Math.pow(2, r) >= msg.length() + r + 1) {
				interruptor = !interruptor;
			}
		} while (interruptor);
	}

	private void adicionaRedundantesNaMsg() {
		for (int i = msg.length() - 1; i >= 0; i--) {
			mensagemMaisRedundantes.add(msg.toCharArray()[i]);
		}

		for (int i = 0; i < r; i++) {
			mensagemMaisRedundantes.add(((int) Math.pow(2, i)) - 1, 'r');
		}
		
	}

	private void calculaSubstituiR() {
		for (int i = 0; i < r; i++)
		{
			int smallStep = (int) Math.pow(2, i);
			int bigStep = smallStep * 2;
			int start = smallStep;
			int checkPos = start;
			int numeroDeUns = 0;
			while (true)
			{
				for (int k = start; k <= start + smallStep - 1; k++)
				{
					checkPos = k;
					try {
						
						if(mensagemMaisRedundantes.get(checkPos-1) != 'r' && mensagemMaisRedundantes.get(checkPos-1) != '0') {
							
							numeroDeUns++;
						}
					} catch (java.lang.IndexOutOfBoundsException e) {

					}
					if (k > mensagemMaisRedundantes.size())
					{
						break;
					}
				}
				if (checkPos > mensagemMaisRedundantes.size())
				{
					break;
				}
				else
				{
					start = start + bigStep;
				}
			}
			mensagemMaisRedundantes.set(smallStep - 1, numeroDeUns%2 == 0 ? '0' : '1');
			
		}
	}

	private void calculaRedundantesReceptor() {
		for (int i = 0; i < r; i++)
		{
			int smallStep = (int) Math.pow(2, i);
			int bigStep = smallStep * 2;
			int start = smallStep;
			int checkPos = start;
			int numeroDeUns = 0;
			while (true)
			{
				for (int k = start; k <= start + smallStep - 1; k++)
				{
					checkPos = k;
					try {
						if(mensagemErradaMaisRedundantes.get(checkPos-1) != '0') {
							numeroDeUns++;
						}
					} catch (java.lang.IndexOutOfBoundsException e) {

					}
					if (k > mensagemErradaMaisRedundantes.size())
					{
						break;
					}
				}
				if (checkPos > mensagemErradaMaisRedundantes.size())
				{
					break;
				}
				else
				{
					start = start + bigStep;
				}
			}
			if(numeroDeUns%2 == 0) {
				resultadoRedundantesReceptor += "0";
			}else {
				resultadoRedundantesReceptor += "1";
			}
		}
	}
}
