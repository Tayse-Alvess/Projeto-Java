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
	
	public static void esperar(int ms){
        try{
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

	public static void main(String[] args) {
		
		System.getProperties(); 
	    System.getProperty("user.language");

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
			esperar(70);
		}
		System.out.println("\n");

		// variaveis de controle
		boolean on = true;
		int escolha;

		// Loop do menu, ate escolher a opcao sair
		while (on == true) {
			// Menu
			System.out.print("|------------------------------------|\n");
			System.out.print("|                Menu                |\n");
            		System.out.print("|------------------------------------|\n");
            		System.out.print("|  1 - Cadastrar                     |\n");
            		System.out.print("|  2 - Procurar                      |\n");
            		System.out.print("|  3 - Remover                       |\n");
            		System.out.print("|  4 - Listagem de Cadastros         |\n");
            		System.out.print("|  5 - Sair                          |\n");
            		System.out.print("|------------------------------------|\n");
            		System.out.print("Digite uma opção: ");

			// Atualiza variavel de controle
			escolha = 0;

			// Seleciona uma opcao
			int selecao = 0;
			selecao = input.nextInt();
			System.out.println();
			switch (selecao) {

			// Cadastrar pessoa
			case 1:
				System.out.println("\n" + "---------- Cadastrar Pessoa ---------- " + "\n");

				// Escolher se nao Aluno ou Professor
				System.out.println("1. Aluno" + "\n" + "2. Professor");
				System.out.print("Escolha 1 ou 2: ");
				escolha = input.nextInt();
				// Caso a pessoa digite algo diferente de 1 ou 2, e necessario escolher
				// novamente
				while (escolha != 1 && escolha != 2) {
					System.out.println("\n" + "Escolha inválida!");
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
					System.out.println("\n" + "1. Ciência da Computação" + "\n" + "2. Engenharia da Computação");
					System.out.print("Qual o curso? Escolha 1 ou 2: ");
					escolha = input.nextInt();
					// Caso a pessoa digite algo diferente de 1 ou 2, e necessario escolher
					// novamente
					while (escolha != 1 && escolha != 2) {
						System.out.println("\n" + "Escolha inválida!");
						System.out.println("1. Ciência da Computação" + "\n" + "2. Engenharia da Computação");
						System.out.print("Por favor, escolha 1 ou 2: ");
						escolha = input.nextInt();
					}

					// De acordo com o curso escolhido
					if (escolha == 1) {
						curso.setCodigo(10);
						curso.setNome("Ciência da Computação");
					} else {
						curso.setCodigo(20);
						curso.setNome("Engenharia da Computação");
					}

					// Salvar o cadastro do Aluno no Array, na Lista e no Banco de Dados
					Aluno aluno = new Aluno(nome, cpf, idade, curso);
					
					/*Verifica se esta no limite da quantidade de pessoas que podem ser
					  armazenadas no Array*/
					try{
						repArray.inserir(aluno);
					}
					catch(ArrayIndexOutOfBoundsException e){
						System.out.println(e.getMessage());
					}
					
					System.out.println();
					repLista.inserir(aluno);
					banco.adicionaAluno(aluno);

					System.out.println("Aluno cadastrado!" + "\n");
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

					System.out.println();
					repLista.inserir(professor);
					banco.adicionaProfessor(professor);

					System.out.println("Professor cadastrado!" + "\n");
				}
				
				esperar(400);
				break;

			// Procurar pessoa - Utilizando Lista
			case 2:
				System.out.println("\n" + "-------------- Procurar -------------- " + "\n");
				
				//Escolha entre procurar aluno ou professor
				System.out.println("1. Aluno" + "\n" + "2. Professor");
				System.out.print("Escolha uma opção: ");
				escolha = input.nextInt();
				
				
				// Caso a pessoa digite algo diferente de 1 ou 2, e necessario escolher
				// novamente
				while (escolha != 1 && escolha != 2) {
					System.out.println("\n" + "Escolha inválida!");
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
					System.out.println("\n" + "\n" + "Nao há pessoa cadastrada com esse CPF!");
				else
					System.out.println("\n" + "\n" + "Pessoa encontrada!" + "\n" + procurado.toString());

				esperar(400);
				break;

			// Remover pessoa
			case 3:
				System.out.println("\n" + "-------------- Remover -------------- " + "\n");
					
				//Escolha entre remover aluno ou professor
				System.out.println("1. Aluno" + "\n" + "2. Professor");
				System.out.print("Escolha uma opção: ");
				escolha = input.nextInt();
				
				// Caso a pessoa digite algo diferente de 1 ou 2, Ã© necessÃ¡rio escolher
				// novamente
				while (escolha != 1 && escolha != 2) {
					System.out.println("\n" + "Escolha inválida!");
					System.out.println("1. Aluno" + "\n" + "2. Professor");
					System.out.print("Por favor, escolha 1 ou 2: ");
					escolha = input.nextInt();
				}	

				System.out.print("Digite o CPF: ");
				// Auxiliar recebe o CPF da pessoa a ser removida
				String auxiliar = input.next();

				// Primeiro Ã© necessÃ¡rio verificar se existe pessoa com esse cpf
				procurado = repLista.procurar(auxiliar);
				if (procurado == null)
					System.out.println("\n" + "\n" + "Nao há pessoa cadastrada com esse CPF!");

				// Caso exista a pessoa, entÃ£o remove na Lista, no Array e no Banco de Dados
				else {
					System.out.println();
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
					esperar(400);
				}
				break;

			// Listagem de dados - Banco de Dados
			case 4:
				System.out.println("\n" + "--------- Listagem de dados --------- " + "\n");
				System.out.println("1. Alunos");
				System.out.println("2. Professores");
				System.out.println("3. Todos");
				System.out.print("Escolha uma opção: ");
				escolha = input.nextInt();
				// Caso a pessoa digite algo diferente de 1 ou 2 ou 3, e necessario escolher
				// novamente
				while (escolha != 1 && escolha != 2 && escolha !=3) {
					System.out.println("\n" + "Escolha inválida!");
					System.out.print("Por favor, escolha 1, 2 ou 3: ");
					escolha = input.nextInt();
				}
				System.out.println();
				
				//Listagem de todos os alunos
				if(escolha == 1){
					for (int i = 0; i < ((PessoaDAO) banco).getListaAluno().size(); i++) {
						System.out.println(((PessoaDAO) banco).getListaAluno().get(i));
					}
				}
					
				//Listagem de todos os professores
				else if(escolha ==2){
					for (int i = 0; i < ((PessoaDAO) banco).getListaProfessor().size(); i++) {
						System.out.println(((PessoaDAO) banco).getListaProfessor().get(i));
					}
				}
					
				//Listagem de todas as pessoas
				else{
					for (int i = 0; i < ((PessoaDAO) banco).getListaAluno().size(); i++) {
						System.out.println(((PessoaDAO) banco).getListaAluno().get(i));
					}
					
					for (int i = 0; i < ((PessoaDAO) banco).getListaProfessor().size(); i++) {
						System.out.println(((PessoaDAO) banco).getListaProfessor().get(i));
					}
					
				}
				
				esperar(400);
				break;

			// Sair
			case 5:
				// Atualiza a variavel e a aplicacao nao mais volta para o Menu
				on = false;
				break;

			// Opcaoo invalida - Qualquer outro numero digitado no menu sera invalido
			default:
				System.out.println("Opcao invalida! Por favor, escolha um numero valido!");
				break;
			}

			// Para sair caracter por caracter
			esperar(200);
			System.out.print("\n" + "Redirecionando");
			esperar(200);
			System.out.print(".");
			esperar(200);
			System.out.print(".");
			esperar(200);
			System.out.print(".");
			esperar(200);
			System.out.print("\n" + "\n");
		}

		// Fim da aplicacao
		System.out.print("Encerrando em ");
		esperar(250);
		System.out.print("3");
		esperar(250);
		System.out.print(".");
		esperar(250);
		System.out.print(".");
		esperar(250);
		System.out.print(".");
		esperar(250);
		System.out.print("2");
		esperar(250);
		System.out.print(".");
		esperar(250);
		System.out.print(".");
		esperar(250);
		System.out.print(".");
		esperar(250);
		System.out.print("1");
		esperar(250);
		System.out.println("\n" + "Ate logo! :)");
		input.close();

	}
}
