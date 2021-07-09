import java.util.Scanner;

import dados.RepositorioPessoasArray;
import dados.RepositorioPessoasLista;
import negocios.Aluno;
import negocios.Curso;
import negocios.Pessoa;
import negocios.Professor;
import negocios.RepositorioPessoas;
public class TestaPessoa {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// Repositorios
		RepositorioPessoasArray repArray = new RepositorioPessoasArray(10);
		RepositorioPessoasLista repLista = new RepositorioPessoasLista();

		// Criação de objetos
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

		// Loop do menu, até escolher a opção sair
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
				System.out.println();

				// Caso tenha escolhido Aluno
				if (escolha == 1) {
					// Escolher curso
					System.out.println("\n" + "1. Ciencia da Computacao" + "\n" + "2. Engenharia da Computacao");
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
					repArray.inserir(aluno);
					repLista.inserir(aluno);
					
					//TESTAR BANCO DE DADOS
					add.adicionaAluno(aluno);
					

					System.out.println("\n" + "\n" + "Aluno cadastrado!" + "\n");
				}

				// Caso tenha escolhido Professor
				else {
					// Salario
					System.out.print("Digite o salario: ");
					double salario = input.nextDouble();

					// Salvar o cadastro do Professor no Array, na Lista e no Banco de Dados
					Professor professor = new Professor(nome, cpf, idade, salario);
					repArray.inserir(professor);
					repLista.inserir(professor);
					
					//TESTAR BANCO DE DADOS
					add.adicionaProfessor(professor);

					System.out.println("\n" + "\n" + "Professor cadastrado!" + "\n");
				}

				break;

			// Procurar pessoa - Utilizando Array
			case 2:
				System.out.println("\n" + "-------- Procurar -------- " + "\n");

				System.out.print("Digite o CPF: ");

				/*
				 * Procurar no repositorio(repArray.procurar) o cpf digitado Valor retorna para
				 * o "procurado"
				 */
				Pessoa procurado = repArray.procurar(input.next());

				// Se retornar null, então não existe. Caso exista, utilizei toString para o
				// print
				if (procurado == null)
					System.out.println("\n" + "\n" + "Não há pessoa cadastrada com esse CPF!");
				else
					System.out.println("\n" + "\n" + "Pessoa encontrada!" + "\n" + procurado.toString());

				break;

			// Remover pessoa - Utilizando Array
			case 3:
				System.out.println("\n" + "-------- Remover -------- " + "\n");

				System.out.println("Digite o CPF: ");
				// Auxiliar recebe o CPF da pessoa a ser removida
				String auxiliar = input.next();

				// Primeiro é necessário verificar se existe pessoa com esse cpf
				procurado = repArray.procurar(auxiliar);
				if (procurado == null)
					System.out.println("\n" + "\n" + "Não há pessoa cadastrada com esse CPF!");

				// Caso exista a pessoa, então remove tanto da Lista quanto do Array
				else {
					repArray.remover(auxiliar);
					repLista.remover(auxiliar);
					System.out.println("\n" + "\n" + "Pessoa removida!" + "\n" + procurado.toString());
				}
				break;

			// Listagem de dados - Utilizando Lista
			case 4:
				System.out.println("\n" + "-------- Listagem de dados -------- " + "\n");

				/*
				 * Quando se utiliza o método listarPessoas, ele retorna uma Lista com todas as
				 * pessoas Mas a formatação fica separado por "," e "]" Então utilizei um for,
				 * para percorrer esta lista e ir printando cada pessoa de cada vez
				 * (RepositorioPessoaLista) repLista).listarPessoas().size() --> Isso me retorna
				 * o tamanho da lista Em outras palavras, me retorna a quantidade de pessoas
				 */
				for (int i = 0; i < ((RepositorioPessoasLista) repLista).listarPessoas().size(); i++) {
					System.out.println(((RepositorioPessoasLista) repLista).listarPessoas().get(i));
				}
				break;

			// Sair
			case 5:
				// Atualiza a variavel e a aplicação não mais volta para o Menu
				on = false;
				break;

			// Opção inválida - Qualquer outro numero digitado no menu será invalido
			default:
				System.out.println("Opcao inválida! Por favor, escolha um número válido!");
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
