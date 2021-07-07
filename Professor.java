package negocios;
//Herança. Classe Professor herda da Classe Pessoa
public class Professor extends Pessoa {

	//Atributo privado
	private double salario;

	//Construtor
	public Professor() {

	}
	// Construtor da SuperClass
	
	public Professor(String nome, String cpf, int idade, double salario) {
		super(nome, cpf, idade);
		this.salario = salario;
	}
	
	// Métodos Get e Set
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	//Método toString
	@Override
	public String toString() {
		return super.toString() + "\n" + "Salário: " + getSalario();

	}
}
