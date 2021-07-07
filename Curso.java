package negocios;

public class Curso {

	//Atributos privados
	private double codigo;
	private String nome;

	//Construtores
	public Curso() {

	}

	public Curso(double codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;

	}

	//método Get e Set
	public double getCodigo() {
		return codigo;
	}

	public void setCodigo(double codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	//método toString
	@Override
	public String toString() {
		return "Codigo do curso: " + getCodigo() + "\n" + "Nome do curso: " + getNome() + "\n";
	}

}
