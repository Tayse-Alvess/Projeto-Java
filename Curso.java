
public class Curso {

	//vari�veis da inst�ncia
	private int codigo;
	private String nome;
	
	public Curso(int codigo, String nome) {
		this.codigo = codigo; //armazena o codigo
		this.nome = nome; //armazena o nome
		
	}
	public Curso() {
		// TODO Auto-generated constructor stub
	}
	
	//m�todo para recuperar o objeto
	public int getCodigo() {
		return codigo; //retorna o valor do c�digo para o m�todo chamador
	}
	
	//m�todo para definir o objeto
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
