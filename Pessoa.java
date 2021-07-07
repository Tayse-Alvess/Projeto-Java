package negocios;

public class Pessoa {
	
	// Atributos privados
	private String nome;
	private String cpf;
	private int idade;
	
	// Construtores
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, String cpf, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}
	
	// Método Get e Set
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

	//Método toString
	@Override
	public String toString() {
		return "\n" + "Nome: " + getNome() + "\n" + "CPF: " + getCpf() + "\n" + "Idade: " + getIdade();
	}
	
			
	
}
