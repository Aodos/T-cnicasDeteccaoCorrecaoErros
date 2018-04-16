import javax.swing.JOptionPane;

public class Checksum {
	
	String msgFinalEmissor = "";
	String msgFinalReceptor = "";
	String msgEmissor = "";
	String msgParaEnvio = "";

	public void emissor() {
		
		//Inicializando a lógica
		//A-String mensagem="";
		int repet;
		String mensagemJP = "Informe a mensagem a ser enviada:" ;
		msgEmissor= JOptionPane.showInputDialog(mensagemJP);
		msgFinalEmissor += "-------------------Bloco Emissor ------------------\n";
		 repet= (msgEmissor.length())/8;
		 String[] segmento= new String[10];
		
		 
		//Separando os segmentos da mensagem em posições de um vetor a ser somados posteriormente
		while(repet>0) { 
			   segmento[repet]= msgEmissor.substring((repet-1)*8, repet*8);
				repet--;
			}
				
		
		//Somando Todos os Segmentos para gerar os bits de redundancia
		repet= (msgEmissor.length())/8;
		int soma=2;
		while(repet>0) {
			soma=Integer.parseInt(segmento[repet],2)+soma;
			repet--;
		}
		soma=soma-2;
		
		///Invertendo o Segmento dos Bits de redundancia
		String redu=Integer.toBinaryString(soma);
		msgFinalEmissor += "Bits de redundancia: " + redu+"\n";
		redu=redu.replaceAll("1", "2");
		redu=redu.replaceAll("0", "1");
		redu=redu.replaceAll("2", "0");
		msgFinalEmissor += "Bits de redundancia invertidos: " + redu+"\n";
		
		//Gerando o bloco a ser enviado
		String bloco=msgEmissor+redu;
		msgFinalEmissor += "Bloco a ser enviado :" +bloco + "\n";
		JOptionPane.showMessageDialog(null, msgFinalEmissor, "Emissor", JOptionPane.INFORMATION_MESSAGE);
		msgParaEnvio = bloco;
		//A-receptor(bloco);
		
	}

	public void receptor(String bloco) {
		
		msgFinalReceptor += "-------------------Bloco Receptor ------------------\n";
		
		//Incializando a logica
		String[] segmento= new String[10];
		int repet= (bloco.length())/8;
		String exp;
		int redu;
		exp=(bloco.substring((((repet-1)*8)),(bloco.length())));
		msgFinalReceptor += "Bloco recebido: "+bloco+"\n";
		msgFinalReceptor += "Bits de redundancia "+ exp+"\n";
		redu=Integer.parseInt(exp,2);
		repet--;
		
		
		//separando os segmentos da mensagem em posições de um vetor a ser somados posteriormente para conferir
		while(repet>0) { 
			   segmento[repet]= bloco.substring((repet-1)*8, repet*8);
				repet--;
			   
			 			}
		
		//somando todos segmentos
		repet= (bloco.length())/8;
		int soma=2;
		repet--;
		while(repet>0) { 
			soma=Integer.parseInt(segmento[repet],2)+soma;
			repet--;
	}
		soma=soma+redu;
		soma=soma-2;
		String resultado=Integer.toBinaryString(soma);
		
		//Invertendo o resultado
		resultado=resultado.replaceAll("1", "0");
		msgFinalReceptor += "Soma de todos os segmentos invertida: " + resultado+"\n";
		int resultadoz=Integer.parseInt(resultado);
		
		JOptionPane.showMessageDialog(null, msgFinalReceptor, "Receptor", JOptionPane.INFORMATION_MESSAGE);
		//verificando o resultado para saber se houveram erros
		if (resultadoz==0){
			JOptionPane.showMessageDialog(null, "não houve erros");
		}else {
		JOptionPane.showMessageDialog(null, "Houveram erros");
		}
	
	
}
}
