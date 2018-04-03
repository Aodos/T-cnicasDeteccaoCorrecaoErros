package tecnicas;
import javax.swing.JOptionPane;

public class CheckSum {
	
	
	public void Emissor(){
	String divisor = "1101";
	String mensagem;
	int dividindo;
	String mensagemJP = "Informe a mensagem a ser enviada ou digite pular para informar a mensagem a ser recebida" ;
	 mensagem= JOptionPane.showInputDialog(mensagemJP);
	 
	if ( (mensagem.equals ("pular")==false)) {
		
	 //logica
	 dividindo = Integer.parseInt(mensagem,2) % Integer.parseInt(divisor,2);
	 mensagem = mensagem + Integer.toBinaryString(dividindo);
   
	 JOptionPane.showMessageDialog(null, "Enviando t(X) = " + mensagem);
	 
	 receptor(mensagem);
	
	}
	}
	public void receptor(String mensagem) {
		String divisor = "1101";
		int dividindo;
		String resto;
		String resultado=(mensagem.substring(6, 10));
		mensagem = mensagem.substring(0,6);
		System.out.println("resutlado: " +resultado);
		System.out.println("msg: " +mensagem);
		if (mensagem.equals ("pular")) {
			String mensagemJP = "Informe a mensagem a ser recebida" ;
			 mensagem= JOptionPane.showInputDialog(mensagemJP);
		}
		System.out.println("mensagem recebida: "+ mensagem);
		
		 dividindo = Integer.parseInt(mensagem,2) % Integer.parseInt(divisor,2);
		 resto=Integer.toBinaryString(dividindo);
		 System.out.println("resultado da divisão : " + resto);
		
		if (resto.equals(resultado)) {
			JOptionPane.showMessageDialog(null, "não houve erros");
		}else {
			JOptionPane.showMessageDialog(null, "Houveram erros");
		}
		
	}
}
