package dados;
import java.util.*;
import negocios.Pessoa;
import negocios.RepositorioPessoas;

public class RepositorioPessoasLista implements RepositorioPessoas {
	
	private List <Pessoa> pessoas;
	
	public RepositorioPessoasLista() {
		pessoas = new ArrayList<Pessoa>();
	}
	
	
	public RepositorioPessoasLista(List<Pessoa> pessoas) {
		super();
		this.pessoas = pessoas;
	}

	//Inserir novas pessoas	
	public void inserir(Pessoa pessoa) {
		pessoas.add(pessoa);
	}
	
	//Procurar novas pessoas
	public Pessoa procurar(String cpf) {
		Pessoa encontrada = null;
		for (Pessoa pessoa : pessoas ) {
			if (pessoa.getCpf().equals(cpf))
				encontrada = pessoa;
		}
		return encontrada;
	}
	
	//Remover 
	public void remover(String cpf) {
		int posicao = -1;
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getCpf().equals(cpf)) {
				posicao = pessoas.indexOf(pessoa);
				break;
				
			}
			
		}
		
		if (posicao != -1)
			pessoas.remove(posicao);
	}
	
		public List <Pessoa> listarPessoas(){
			return this.pessoas;
		}
}




	
	

