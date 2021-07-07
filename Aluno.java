package negocios;

// Herança. Classe Aluno herda da Classe Pessoa
public class Aluno extends Pessoa {

	private Curso curso;

	public Aluno() {

	}

	// Construtor da SuperClass
	public Aluno(String nome, String cpf, int idade, Curso curso) {
		super(nome, cpf, idade);
		this.curso = curso;
	}

	// Métodos Get e Set
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + "Curso: " + getCurso().getNome();
	}

}
