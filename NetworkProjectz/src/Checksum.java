import javax.swing.JOptionPane;

public class Checksum {

	public void emissor() {
		
		//Inicializando a lógica
		String mensagem="";
		int repet;
		String mensagemJP = "Informe a mensagem a ser enviada:" ;
		 mensagem= JOptionPane.showInputDialog(mensagemJP);
		 System.out.println("-------------------Bloco Emissor ------------------\n");
		 repet= (mensagem.length())/8;
		 String[] segmento= new String[10];
		
		 
		//Separando os segmentos da mensagem em posições de um vetor a ser somados posteriormente
		while(repet>0) { 
			   segmento[repet]= mensagem.substring((repet-1)*8, repet*8);
				repet--;
			}
				
		
		//Somando Todos os Segmentos para gerar os bits de redundancia
		repet= (mensagem.length())/8;
		int soma=2;
		while(repet>0) {
			soma=Integer.parseInt(segmento[repet],2)+soma;
			repet--;
		}
		soma=soma-2;
		
		///Invertendo o Segmento dos Bits de redundancia
		String redu=Integer.toBinaryString(soma);
		System.out.println("Bits de redundancia: " + redu);
		redu=redu.replaceAll("1", "2");
		redu=redu.replaceAll("0", "1");
		redu=redu.replaceAll("2", "0");
		System.out.println("Bits de redundancia invertidos: " + redu);
		
		//Gerando o bloco a ser enviado
		String bloco=mensagem+redu;
		System.out.println("Bloco a ser enviado :" +bloco + "\n");
		receptor(bloco);
		
	}

	public void receptor(String bloco) {
		
		System.out.println("-------------------Bloco Receptor ------------------\n");
		
		//Incializando a logica
		String[] segmento= new String[10];
		int repet= (bloco.length())/8;
		String exp;
		int redu;
		exp=(bloco.substring((((repet-1)*8)),(bloco.length())));
		System.out.println("Bloco recebido: "+bloco);
		System.out.println("Bits de redundancia "+ exp);
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
		System.out.println("Soma de todos os segmentos invertida: " + resultado);
		int resultadoz=Integer.parseInt(resultado);
		
		//verificando o resultado para saber se houveram erros
		if (resultadoz==0){
			JOptionPane.showMessageDialog(null, "não houve erros");
		}else {
		JOptionPane.showMessageDialog(null, "Houveram erros");
		}
	
	
}
}
