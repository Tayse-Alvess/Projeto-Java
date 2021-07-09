import java.util.Scanner;

import dados.RepositorioPessoasArray;
import dados.RepositorioPessoasLista;
import negocios.Aluno;
import negocios.Curso;
import negocios.Pessoa;
import negocios.Professor;
import negocios.RepositorioPessoas;
import dados.PessoaDAO;
import dados.ArrayIndexOutOfBoundsException;

public class TestaPessoa {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// Repositorios e Banco de Dados
		RepositorioPessoasArray repArray = new RepositorioPessoasArray(2);
		RepositorioPessoas repLista = new RepositorioPessoasLista(); //Polimorfismo
		PessoaDAO banco = new PessoaDAO();

		// Criacao de objetos
		Curso curso = new Curso();

		// Inicio - digitar letra por letra

		String inicial = "Bem vindo ao Projeto de Java Básico da Academia Accenture!";
		for (int i = 0; i < inicial.length(); i++) {
			System.out.print(inicial.charAt(i));

		}
		System.out.println("\n");

		// variaveis de controle
		boolean on = true;
		int escolha;

		// Loop do menu, ate escolher a opcao sair
		while (on == true) {
			// Menu
			System.out.println("-------- Menu -------- " + "\n");

			System.out.println("1. Cadastrar");
			System.out.println("2. Procurar");
			System.out.println("3. Remover");
			System.out.println("4. Listagem de dados");
			System.out.println("5. Sair");

			System.out.print("\n" + "Escolha um numero: ");

			// Atualiza variavel de controle
			escolha = 0;

			// Seleciona uma opção
			int selecao = 0;
			selecao = input.nextInt();
			System.out.println();
			switch (selecao) {

			// Cadastrar pessoa
			case 1:
				System.out.println("\n" + "-------- Cadastrar pessoa -------- " + "\n");

				// Escolher se é Aluno ou Professor
				System.out.println("\n" + "1. Aluno" + "\n" + "2. Professor");
				System.out.print("Escolha 1 ou 2: ");
				escolha = input.nextInt();
				// Caso a pessoa digite algo diferente de 1 ou 2, é necessário escolher
				// novamente
				while (escolha != 1 && escolha != 2) {
					System.out.println("\n" + "Escolha invalida!");
					System.out.println("1. Aluno" + "\n" + "2. Professor");
					System.out.print("Por favor, escolha 1 ou 2: ");
					escolha = input.nextInt();
				}

				// Nome, cpf e idade
				System.out.print("\n" + "Digite o nome: ");
				String nome = input.next();
				System.out.print("Digite o cpf: ");
				String cpf = input.next();
				System.out.print("Digite a idade: ");
				int idade = input.nextInt();

				// Caso tenha escolhido Aluno
				if (escolha == 1) {
					// Escolher curso
					System.out.println("\n" + "\n" + "1. Ciencia da Computacao" + "\n" + "2. Engenharia da Computacao");
					System.out.print("Qual o curso? Escolha 1 ou 2: ");
					escolha = input.nextInt();
					// Caso a pessoa digite algo diferente de 1 ou 2, é necessário escolher
					// novamente
					while (escolha != 1 && escolha != 2) {
						System.out.println("\n" + "Escolha invalida!");
						System.out.println("1. Ciencia da Computacao" + "\n" + "2. Engenharia da Computacao");
						System.out.print("Por favor, escolha 1 ou 2: ");
						escolha = input.nextInt();
					}

					// De acordo com o curso escolhido
					if (escolha == 1) {
						curso.setCodigo(10);
						curso.setNome("Ciencia da Computacao");
					} else {
						curso.setCodigo(20);
						curso.setNome("Engenharia da Computacao");
					}

					// Salvar o cadastro do Aluno no Array, na Lista e no Banco de Dados
					Aluno aluno = new Aluno(nome, cpf, idade, curso);
					
					/*Verifica se está no limite da quantidade de pessoas que podem ser
					  armazenadas no Array*/
					try{
						repArray.inserir(aluno);
					}
					catch(ArrayIndexOutOfBoundsException e){
						System.out.println(e.getMessage());
					}
					
					repLista.inserir(aluno);
					banco.adicionaAluno(aluno);

					System.out.println("\n" + "\n" + "Aluno cadastrado!" + "\n");
				}

				// Caso tenha escolhido Professor
				else {
					// Salario
					System.out.print("Digite o salario: ");
					double salario = input.nextDouble();

					// Salvar o cadastro do Professor no Array, na Lista e no Banco de Dados
					Professor professor = new Professor(nome, cpf, idade, salario);
					
					/*Verifica se esta no limite da quantidade de pessoas que podem ser
					  armazenadas no Array*/
					try{
						repArray.inserir(professor);
					}
					catch(ArrayIndexOutOfBoundsException e){
						System.out.println(e.getMessage());
					}

					repLista.inserir(professor);
					banco.adicionaProfessor(professor);

					System.out.println("\n" + "\n" + "Professor cadastrado!" + "\n");
				}

				break;

			// Procurar pessoa - Utilizando Lista
			case 2:
				System.out.println("\n" + "-------- Procurar -------- " + "\n");
				
				//Escolha entre procurar aluno ou professor
				System.out.println("1. Aluno" + "\n" + "2. Professor");
				System.out.print("Escolha uma opcao: ");
				escolha = input.nextInt();
				
				// Caso a pessoa digite algo diferente de 1 ou 2, é necessário escolher
				// novamente
				while (escolha != 1 && escolha != 2) {
					System.out.println("\n" + "Escolha invalida!");
					System.out.println("1. Aluno" + "\n" + "2. Professor");
					System.out.print("Por favor, escolha 1 ou 2: ");
					escolha = input.nextInt();
				}	
				
				System.out.print("Digite o CPF: ");
				
				/*
				 * Procurar no repositorio(repLista.procurar) o cpf digitado Valor retorna para
				 * o "procurado"
				 */
				Pessoa procurado = repLista.procurar(input.next());

				// Se retornar null, então nao existe. Caso exista, utilizei toString para o print
				if (procurado == null)
					System.out.println("\n" + "\n" + "Nao ha pessoa cadastrada com esse CPF!");
				else
					System.out.println("\n" + "\n" + "Pessoa encontrada!" + "\n" + procurado.toString());

				break;

			// Remover pessoa
			case 3:
				System.out.println("\n" + "-------- Remover -------- " + "\n");
					
				//Escolha entre remover aluno ou professor
				System.out.println("1. Aluno" + "\n" + "2. Professor");
				System.out.print("Escolha uma opcao: ");
				escolha = input.nextInt();
				
				// Caso a pessoa digite algo diferente de 1 ou 2, é necessário escolher
				// novamente
				while (escolha != 1 && escolha != 2) {
					System.out.println("\n" + "Escolha invalida!");
					System.out.println("1. Aluno" + "\n" + "2. Professor");
					System.out.print("Por favor, escolha 1 ou 2: ");
					escolha = input.nextInt();
				}	

				System.out.println("Digite o CPF: ");
				// Auxiliar recebe o CPF da pessoa a ser removida
				String auxiliar = input.next();

				// Primeiro é necessário verificar se existe pessoa com esse cpf
				procurado = repLista.procurar(auxiliar);
				if (procurado == null)
					System.out.println("\n" + "\n" + "Não há pessoa cadastrada com esse CPF!");

				// Caso exista a pessoa, então remove na Lista, no Array e no Banco de Dados
				else {
					//Remove na Lista
					repLista.remover(auxiliar);
					
					//Remove no Banco de Dados
					if(escolha == 1)
						banco.removeAluno(auxiliar);
					else
						banco.removeProfessor(auxiliar);
					
					//Verifica se esta no Array - e necessario porque Array esta com tamanho 2
					procurado = repArray.procurar(auxiliar);
					//Remove no Array
					if(procurado != null)
						repArray.remover(auxiliar);
					
					//Dados da pessoa removida
					System.out.println(procurado.toString());
				}
				break;

			// Listagem de dados - Utilizando Lista e Banco de Dados
			case 4:
				System.out.println("\n" + "-------- Listagem de dados -------- " + "\n");
				System.out.println("1. Alunos");
				System.out.println("2. Professores");
				System.out.println("3. Todos");
				System.out.print("Escolha uma opção: ");
				escolha = input.nextInt();
				// Caso a pessoa digite algo diferente de 1 ou 2 ou 3, e necessario escolher
				// novamente
				while (escolha != 1 && escolha != 2 && escolha !=3) {
					System.out.println("\n" + "Escolha invalida!");
					System.out.print("Por favor, escolha 1, 2 ou 3: ");
					escolha = input.nextInt();
				}
				System.out.println();
				
				//Listagem de todos os alunos - Utilizando Banco de Dados
				if(escolha == 1){
					//Mesma linha de raciocínio da Listagem de todas as pessoas, logo abaixo 
					for (int i = 0; i < ((PessoaDAO) banco).getListaAluno().size(); i++) {
						System.out.println(((PessoaDAO) banco).getListaAluno().get(i));
					}
				}
					
				//Listagem de todos os professores - Utilizando Banco de Dados
				else if(escolha ==2){
					//Mesma linha de raciocínio da Listagem de todas as pessoas, logo abaixo 
					for (int i = 0; i < ((PessoaDAO) banco).getListaProfessor().size(); i++) {
						System.out.println(((PessoaDAO) banco).getListaProfessor().get(i));
					}
				}
					
				//Listagem de todas as pessoas - Utilizando Lista
				else{
					/*
				 	* Quando se utiliza o metodo listarPessoas, ele retorna uma Lista com todas as
				 	* pessoas Mas a formatacao fica separado por "," e "]" Entao utilizei um for,
				 	* para percorrer esta lista e ir printando cada pessoa de cada vez
				 	* (RepositorioPessoaLista) repLista).listarPessoas().size() --> Isso me retorna
				 	* o tamanho da lista. Em outras palavras, me retorna a quantidade de pessoas
				 	*/
					for (int i = 0; i < ((RepositorioPessoasLista) repLista).listarPessoas().size(); i++) {
						System.out.println(((RepositorioPessoasLista) repLista).listarPessoas().get(i));
					}
				}
				
				break;

			// Sair
			case 5:
				// Atualiza a variavel e a aplicacao não mais volta para o Menu
				on = false;
				break;

			// Opção inválida - Qualquer outro numero digitado no menu sera invalido
			default:
				System.out.println("Opcao invalida! Por favor, escolha um numero valido!");
				break;
			}

			// Para sair caracter por caracter

			System.out.print("\n" + "Redirecionando");
			System.out.print(".");
			System.out.print(".");
			System.out.print(".");
			System.out.print("\n" + "\n");
		}

		// Fim da aplicação
		System.out.print("Encerrando em ");
		System.out.print("3");
		System.out.print(".");
		System.out.print(".");
		System.out.print(".");
		System.out.print("2");
		System.out.print(".");
		System.out.print(".");
		System.out.print(".");
		System.out.print("1");

		System.out.println("\n" + "Até logo! :)");
		input.close();

	}
}
