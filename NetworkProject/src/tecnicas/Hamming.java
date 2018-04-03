package tecnicas;

import javax.swing.JOptionPane;

public class Hamming {
	public void iniciaHamming() {


		String msg = JOptionPane.showInputDialog("Informar mensagem: ");

		int r = 0, m = msg.length();


		while (true)

		{

			if (m + r + 1 <= Math.pow(2, r))

			{

				break;

			}

			r++;
			

		}

		
		
		int transLength = msg.length() + r, temp = 0, temp2 = 0, j = 0;

		int transMsg[] = new int[transLength + 1]; 

		for (int i = 1; i <= transLength; i++)

		{

			temp2 = (int) Math.pow(2, temp);

			if (i % temp2 != 0)

			{

				transMsg[i] = Integer.parseInt(Character.toString(msg.charAt(j)));

				j++;

			}

			else

			{

				temp++;

			}

		}

		String numeroComBitsP = "";
		
		for (int i = 1; i <= transLength; i++)

		{
			numeroComBitsP = numeroComBitsP + Integer.toString(transMsg[i]);
		}
		
		String mensagemJP = "Numero de bit de redundancia necessarios e: "+ r + "\n- " + numeroComBitsP;
		
		JOptionPane.showMessageDialog(null, mensagemJP, "Mensagem", JOptionPane.INFORMATION_MESSAGE);

		String mensJP = "";
		
		for (int i = 0; i < r; i++)

		{

			int smallStep = (int) Math.pow(2, i);

			int bigStep = smallStep * 2;

			int start = smallStep, checkPos = start;

			
			mensJP = mensJP + "Calculando bit para posicao:  " + smallStep + "\n";

			
			mensJP = mensJP + "Bits a ser checado: ";
			
			String msg1 = "";

			while (true)

			{

				for (int k = start; k <= start + smallStep - 1; k++)

				{

					checkPos = k;

					
					msg1 = msg1+checkPos + " ";

					if (k > transLength)

					{

						break;

					}

					transMsg[smallStep] ^= transMsg[checkPos];

				}

				if (checkPos > transLength)

				{

					break;

				}

				else

				{

					start = start + bigStep;

				}

			}
			
			mensJP = mensJP + " " +msg1+ "\n";
			
			


		}
		
		JOptionPane.showMessageDialog(null, mensJP, "", JOptionPane.INFORMATION_MESSAGE);

		
		numeroComBitsP = "";

		for (int i = 1; i <= transLength; i++)

		{
			numeroComBitsP = numeroComBitsP + Integer.toString(transMsg[i]);
			System.out.print(transMsg[i]);

		}
		
		JOptionPane.showMessageDialog(null, "Mensagem \"Hammingficada\" : "+numeroComBitsP, "", JOptionPane.INFORMATION_MESSAGE);


	}
}
