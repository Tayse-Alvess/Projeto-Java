package negocios;

public interface RepositorioPessoas  {
	
	public void inserir (Pessoa pessoa);
	public Pessoa procurar (String cpf);
	public void remover (String cpf);
	
}
