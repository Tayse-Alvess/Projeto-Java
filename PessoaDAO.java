package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import negocios.Pessoa;

public class PessoaDAO {

	private Connection con = null;

	public PessoaDAO() {	
		this.con = new ConexaoFactory().getConnection();		
	}

	public void adiciona(Pessoa pessoa) {
		
		

		String sql = "INSERT INTO aluno(Nome, CPF, Idade, Curso) VALUES ('[value-1]','[value-2]','[value-3]','[value-4]')";
		System.out.println(sql);

		try {
			PreparedStatement stmt = con.prepareStatement(sql);		
			

			stmt.setString(1, pessoa.getNome());			
			stmt.setString(2, pessoa.getCpf());

			stmt.execute();
			stmt.close();

			System.out.println("Gravado!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Pessoa> getLista() {
		
		List<Pessoa> contas = new ArrayList<Pessoa>();
		
		String sql = "SELECT * FROM conta";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Pessoa pessoa = new Pessoa (rs.getString("nome"),rs.getString("cpf"),rs.getInt("idade"));
				pessoa.setNome(rs.getString("nome"));  
				pessoa.setCpf(rs.getString("cpf"));			
				pessoa.setIdade(rs.getInt("idade"));
				
				pessoa.add(pessoa);
			}
			
			rs.close();
			stmt.close();
			return pessoa;
		} catch (SQLException e) {			
			throw new RuntimeException(e);
		}		
	}	
}


