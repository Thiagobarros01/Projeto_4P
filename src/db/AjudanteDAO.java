package db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import seminario.Ajudante;

public class AjudanteDAO {

	public void inserirAjudante(Ajudante ajudante) {
		Conexao conexao = new Conexao();
		try {
			PreparedStatement stmt = conexao.getConnection().prepareStatement(
					"INSERT INTO Ajudante (Nome, Sobrenome, Email, Senha, DataNascimento, cpf, telefone) VALUES (?, ?, ?,?,?,?,?)");
			stmt.setString(1, ajudante.getNome());
			stmt.setString(2, ajudante.getSobrenome());
			stmt.setString(3, ajudante.getEmail());
			stmt.setString(4, ajudante.getSenha());
			stmt.setDate(5, Date.valueOf(ajudante.getDataNascimento()));
			stmt.setString(6, ajudante.getCpf());
			stmt.setString(7, ajudante.getTelefone());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizarAjudante(Ajudante ajudante) {
		Conexao conexao = new Conexao();
		try {
			PreparedStatement stmt = conexao.getConnection().prepareStatement(
					"UPDATE Ajudante SET Nome = ?, Sobrenome = ?, Email = ?, Senha = ? WHERE ID_Ajudante = ?");
			stmt.setString(1, ajudante.getNome());
			stmt.setString(2, ajudante.getSobrenome());
			stmt.setString(3, ajudante.getEmail());
			stmt.setString(4, ajudante.getSenha());
			stmt.setInt(5, ajudante.getIdAjudante());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletarAjudante(int idAjudante) {
		Conexao conexao = new Conexao();
		try {
			PreparedStatement stmt = conexao.getConnection()
					.prepareStatement("DELETE FROM Ajudante WHERE ID_Ajudante = ?");
			stmt.setInt(1, idAjudante);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Ajudante> buscarTodosAjudantes(){
		Conexao conexao = new Conexao();
		List<Ajudante> ajudantes = new ArrayList<Ajudante>();
		
		try {
			PreparedStatement stmt = conexao.getConnection().prepareStatement("SELECT * FROM ajudante");
			ResultSet rs = stmt.executeQuery();
			
				while (rs.next()) {
					Ajudante ajudante = new Ajudante(rs.getString("nome"),rs.getString("sobrenome"),rs.getString("email"), rs.getString("senha"),rs.getDate("datanascimento").toLocalDate(), rs.getString("CPF"), rs.getString("Telefone"),rs.getInt("id_ajudante"));
					ajudantes.add(ajudante);
					
				
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return ajudantes;
		
		
		
		
	}
}
