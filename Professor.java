package negocios;
public class Professor extends Pessoa {

	private double salario;

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

	@Override
	public String toString() {
		return super.toString() + "\n" + "Salário: " + getSalario();

	}
}
