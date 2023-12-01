package db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import seminario.Motorista;

public class MotoristaDAO {

	public void inserirMotorista(Motorista motorista) {
		Conexao conexao = new Conexao();
		try {
			PreparedStatement stmt = conexao.getConnection().prepareStatement(
					"INSERT INTO Motorista (Nome, Sobrenome, Email, Senha, DataNascimento, cpf, telefone) VALUES (?, ?, ?,?,?,?,?)");
			stmt.setString(1, motorista.getNome());
			stmt.setString(2, motorista.getSobrenome());
			stmt.setString(3, motorista.getEmail());
			stmt.setString(4, motorista.getSenha());
			stmt.setDate(5, Date.valueOf(motorista.getDataNascimento()));
			stmt.setString(6, motorista.getCpf());
			stmt.setString(7, motorista.getTelefone());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizarMotorista(Motorista motorista) {
		Conexao conexao = new Conexao();
		try {
			PreparedStatement stmt = conexao.getConnection().prepareStatement(
					"UPDATE Motorista SET Nome = ?, Sobrenome = ?, Email = ? , Senha = ? , cpf = ? , telefone = ? WHERE ID_Motorista = ?");
			stmt.setString(1, motorista.getNome());
			stmt.setString(2, motorista.getSobrenome());
			stmt.setString(3, motorista.getEmail());
			stmt.setString(4, motorista.getSenha());
			stmt.setString(5, motorista.getCpf());
			stmt.setString(6, motorista.getTelefone());
			stmt.setInt(7, motorista.getIdMotorista());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletarMotorista(int idMotorista) {
		Conexao conexao = new Conexao();
		try {
			PreparedStatement stmt = conexao.getConnection()
					.prepareStatement("DELETE FROM Motorista WHERE ID_Motorista = ?");
			stmt.setInt(1, idMotorista);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Motorista> buscarTodosMotoristas() {
		Conexao conexao = new Conexao();
		List<Motorista> motoristas = new ArrayList<>();

		try {
			PreparedStatement stmt = conexao.getConnection().prepareStatement("SELECT * FROM Motorista");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Motorista motorista = new Motorista( rs.getString("Nome"),
						rs.getString("Sobrenome"), rs.getString("Email"), rs.getString("Senha"),
						rs.getDate("DataNascimento").toLocalDate(), rs.getString("CPF"), rs.getString("Telefone"),rs.getInt("ID_Motorista"));
				motoristas.add(motorista);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return motoristas;
	}

}
