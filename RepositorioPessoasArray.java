package dados;
import negocios.Pessoa;// Importa do pacote Negócios a Classe Pessoa.

public class RepositorioPessoasArray {

	//Atributos privados
	private Pessoa[] pessoas;
	private int indice;

	//Construtores
	public RepositorioPessoasArray(int tamanho) {
		indice = 0;
		pessoas = new Pessoa[tamanho];

	}

	//Método inserir
	public void inserir(Pessoa individuo) {
		pessoas[indice] = individuo;
		indice = indice + 1;

	}

	//Método procurar
	public Pessoa procurar(String cpf) {
		Pessoa encontrada = null;
		for (int i = 0; i < indice; i++) {
			Pessoa procura = this.pessoas[i];
			if (procura.getCpf().equals(cpf))
				encontrada = procura;
		}
		return encontrada;
	}

	//Método remover
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
