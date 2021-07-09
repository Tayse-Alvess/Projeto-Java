package dados;

import java.sql.*;
import java.util.*;
import negocio.Aluno;
import negocio.Professor;
import negocio.Curso;


public class PessoaDAO {
	private Connection con = null;

	public PessoaDAO() {	
		this.con = new ConexaoFactory().getConnection();		
	}

	public void adicionaAluno(Aluno aluno) {
		
		String sql = "INSERT INTO aluno(nome, cpf, idade, curso) VALUES(?,?,?,?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);		
			
			stmt.setString(1, aluno.getNome());		
			stmt.setString(2, aluno.getCpf());	
			stmt.setInt(3, aluno.getIdade());
			stmt.setString(4, aluno.getCurso().getNome());
			
			stmt.execute();
			stmt.close();

			System.out.println("Gravado!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void adicionaProfessor(Professor professor) {

		String sql = "INSERT INTO professor(nome, cpf, idade , salario) VALUES(?,?,?,?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);		

			stmt.setString(1, professor.getNome());		
			stmt.setString(2, professor.getCpf());	
			stmt.setInt(3, professor.getIdade());
			stmt.setDouble(4, professor.getSalario());
			
			stmt.execute();
			stmt.close();

			System.out.println("Gravado!");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void procuraAluno(String cpf) {

		String sql = "SELECT * FROM aluno where cpf = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, cpf);			
			stmt.execute();
			stmt.close();

			System.out.println("Aluno encontrado!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void procuraProfessor(String cpf) {

		String sql = "SELECT * FROM professor where cpf = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, cpf);			
			stmt.execute();
			stmt.close();

			System.out.println("Professor encontrado!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void removeAluno(String cpf) {

		String sql = "DELETE FROM aluno where cpf = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, cpf);
			stmt.execute();
			stmt.close();

			System.out.println("Aluno removido!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void removeProfessor(String cpf) {

		String sql = "DELETE FROM professor where cpf = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, cpf);
			stmt.execute();
			stmt.close();

			System.out.println("Professor removido!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
