package negocios;

public class Pessoa {
	
	private String nome;
	private String cpf;
	private int idade;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, String cpf, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}
	
	public Pessoa(String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "\n" + "Nome: " + getNome() + "\n" + "CPF: " + getCpf() + "\n" + "Idade: " + getIdade();
	}

	public void add(Pessoa pessoa) {
		// TODO Auto-generated method stub
		
	}
	
			
	
}
