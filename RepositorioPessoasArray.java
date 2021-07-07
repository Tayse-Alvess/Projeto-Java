package dados;
import negocios.Pessoa;

public class RepositorioPessoasArray {

	private Pessoa[] pessoas;
	private int indice;

	public RepositorioPessoasArray(int tamanho) {
		indice = 0;
		pessoas = new Pessoa[tamanho];

	}

	public void inserir(Pessoa individuo) {
		pessoas[indice] = individuo;
		indice = indice + 1;

	}

	public Pessoa procurar(String cpf) {
		Pessoa encontrada = null;
		for (int i = 0; i < indice; i++) {
			Pessoa procura = this.pessoas[i];
			if (procura.getCpf().equals(cpf))
				encontrada = procura;
		}
		return encontrada;
	}

	public void remover(String cpf) {
		for (int i = 0; i < indice; i++) {
			Pessoa procura = this.pessoas[i];
			if (procura.getCpf().equals(cpf)) {

				this.pessoas[i] = this.pessoas[indice - 1];
				this.pessoas[indice - 1] = null;

				indice = indice - 1;
			}

		}
	}

}
