package dados;

import java.sql.*;
import java.util.*;
import negocios.Aluno;
import negocios.Professor;
import negocios.Curso;


public class PessoaDAO {
	private Connection con = null;

	public PessoaDAO() {	
		this.con = new ConexaoFactory().getConnection();		
	}

	//Adiciona Aluno
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
	
	//Adiciona professor
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
	
	//Procura Aluno
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

	//Procura Professor
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

	//Remove aluno
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

	//Remove professor
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
	
	//Lista alunos
	public List<Aluno> getListaAluno() {
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		String sql = "SELECT * FROM aluno";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			Curso curso=new Curso();
			while(rs.next()){
				curso.setNome(rs.getString("curso"));
				Aluno aluno = new Aluno(rs.getString("nome"), rs.getString("cpf"), rs.getInt("idade"), curso );
				aluno.setNome(rs.getString("nome"));  
				aluno.setCpf(rs.getString("cpf"));		
				aluno.setIdade(rs.getInt("idade"));	
				aluno.setCurso(curso);
				
				alunos.add(aluno);
			}
			
			rs.close();
			stmt.close();
			return alunos;
		} catch (SQLException e) {			
			throw new RuntimeException(e);
		}		
	}	
	
	//Lista professores
	public List<Professor> getListaProfessor() {
		
		List<Professor> professor = new ArrayList<Professor>();
		
		String sql = "SELECT * FROM professor";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){

				Professor professores = new Professor(rs.getString("nome"), rs.getString("cpf"), rs.getInt("idade"), rs.getDouble("salario") );
				professores.setNome(rs.getString("nome"));  
				professores.setCpf(rs.getString("cpf"));		
				professores.setIdade(rs.getInt("idade"));
				professores.setSalario(rs.getDouble("salario"));	
				
				professor.add(professores);
			}
			
			rs.close();
			stmt.close();
			return professor;
		} catch (SQLException e) {			
			throw new RuntimeException(e);
		}		
	}		
	
	
}
