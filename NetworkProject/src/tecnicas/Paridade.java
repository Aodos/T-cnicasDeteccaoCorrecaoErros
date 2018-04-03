package tecnicas;

public class Paridade {

	String mensagem;

	public void iniciaTecnica(String mensagem) {
		this.mensagem = mensagem;
		adicionaBitDeParidade();
		}

	private int verificaSeEParOuImpar() {
		int numeroDeUns = 0;

		for (char i : mensagem.toCharArray()) {

			if (i == '1') {
				numeroDeUns++;
			}
		}

		return numeroDeUns % 2;
	}

	private void adicionaBitDeParidade() {
		if(verificaSeEParOuImpar() == 0) {
			this.mensagem = this.mensagem.concat("-0");
		}else {
			this.mensagem = this.mensagem.concat("-1");
		}
	}


}
