
public class TestaPessoa {

	public static void main(String[] args) {

		RepositorioPessoasArray local = new RepositorioPessoasArray(3);

		// Cursos
		Curso curso1 = new Curso(001, "Análise e Desenvolvimento de Sistemas");
		Curso curso2 = new Curso(002, "Psicologia");

		System.out.println("CURSOS:" + "\n");
		System.out.println(curso1.toString());
		System.out.println(curso2.toString());

		// Professores
		Professor professor1 = new Professor("Vera Lucia", "125.874.85-9", 45, 2500.00);
		Professor professor2 = new Professor("Manoel Julio", "775.882.15-5", 54, 2500.00);

		System.out.println("PROFESSORES:");
		System.out.println(professor1.toString());
		System.out.println(professor2.toString());

		// Alunos
		Aluno aluno1 = new Aluno("Maria Fernanda", "123.456.78-9", 22, curso1);
		Aluno aluno2 = new Aluno("José Henrique", "344.564.33-9", 20, curso2);

		System.out.println("\n" + "ALUNOS:");
		System.out.println(aluno1.toString());
		System.out.println(aluno2.toString());

		// Inserir nova Pessoa
		Aluno aluno3 = new Aluno("Vanessa Cristina", "123.654.87-0", 24, curso2);
		local.inserir(aluno3);
		System.out.println(aluno3.toString());

		Aluno aluno4 = new Aluno("Fabio Luis", "456.983.29-0", 35, curso1);
		local.inserir(aluno4);
		System.out.println(aluno4.toString());

		// Procurar por uma Pessoa
		Pessoa encontrada = local.procurar("123.654.87-0");
		System.out.println("\n" + "PROCURAR PESSOAS:");
		System.out.println(
				" \nA pessoa procurada foi: " + encontrada.getNome() + " portadora do CPF: " + aluno3.getCpf());
		
		//Procurando Pessoa inválida
		Pessoa encontrada = local.procurar("321.777.97-1");
		System.out.println("\n" + "PROCURAR PESSOAS:");
		if(encontrada == null){
			System.out.println(" Pessoa não encontra ");
		}
		else{
			System.out.println(
				" \nA pessoa procurada foi: " + encontrada.getNome() + " portadora do CPF: " + aluno3.getCpf());
		}

		// Remover uma Pessoa
		System.out.println("\n" + "REMOVER PESSOAS:" + "\n");
		encontrada = local.procurar("456.983.29-0");
		if (encontrada == null) {
			System.out.println("Não existe pessoa com esse cpf informado!");
		} else {
			local.remover("45698329-0");
			System.out.println("A pessoa com o nome " + encontrada.getNome() + " foi removida!");
		}

	}

}
