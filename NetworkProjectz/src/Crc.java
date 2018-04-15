
import javax.swing.JOptionPane;

public class Crc {
	
	
	public void Emissor(){
	String gerador = "1101",bloco,mensagem,resto;
	String mensagemJP = "Informe a mensagem a ser enviada :" ;
	int dividendo,divisor;
	 mensagem= JOptionPane.showInputDialog(mensagemJP);
	 System.out.println("mensagem: "+ mensagem);
	bloco=mensagem;
     //adicionando R zeros ao final da mensagem, R é igual ao grau do gerador
	 mensagem=mensagem+"000";
	 
	 //dividindo a mensagem pelo gerador
	 dividendo= Integer.parseInt(mensagem,2);
	 divisor=Integer.parseInt(gerador,2);
	 System.out.println("Dividendo: "+dividendo);
	 System.out.println("Divisor: "+divisor);
	 resto= Integer.toBinaryString( dividendo%divisor);
	 bloco=bloco+resto;
	 
	 System.out.println("Resto: "+resto);
	 System.out.println("Bloco: "+bloco);
	 
	 
	 receptor(bloco);
	
	}
	
	
	public void receptor(String mensagem) {
		String divisor = "1101";
		int dividindo;
		String resto;
		int resultado;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*if (resto.equals(resultado)) {
			JOptionPane.showMessageDialog(null, "não houve erros");
		}else {
			JOptionPane.showMessageDialog(null, "Houveram erros");
		}
		*/
		
	}
}

