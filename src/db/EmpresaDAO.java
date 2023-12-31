package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import seminario.Empresa;

public class EmpresaDAO {

	public void inserirEmpresa(Empresa empresa) {
		Conexao conexao = new Conexao();
		try {
			PreparedStatement stmt = conexao.getConnection().prepareStatement(
					"INSERT INTO Empresa (NomeEmpresa, CNPJ, Endereco, ContatoNome, ContatoTelefone) VALUES (?, ?, ?, ?, ?)");
			stmt.setString(1, empresa.getNomeEmpresa());
			stmt.setString(2, empresa.getCnpj());
			stmt.setString(3, empresa.getEndereco());
			stmt.setString(4, empresa.getContatoNome());
			stmt.setString(5, empresa.getContatoTelefone());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizarEmpresa(Empresa empresa) {
		Conexao conexao = new Conexao();
		try {
			PreparedStatement stmt = conexao.getConnection().prepareStatement(
					"UPDATE Empresa SET NomeEmpresa = ?, CNPJ = ?, Endereco = ?, ContatoNome = ?, ContatoTelefone = ? WHERE ID_Empresa = ?");
			stmt.setString(1, empresa.getNomeEmpresa());
			stmt.setString(2, empresa.getCnpj());
			stmt.setString(3, empresa.getEndereco());
			stmt.setString(4, empresa.getContatoNome());
			stmt.setString(5, empresa.getContatoTelefone());
			stmt.setInt(6, empresa.getIdEmpresa());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletarEmpresa(int idEmpresa) {
		Conexao conexao = new Conexao();
		try {
			PreparedStatement stmt = conexao.getConnection()
					.prepareStatement("DELETE FROM Empresa WHERE ID_Empresa = ?");
			stmt.setInt(1, idEmpresa);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Empresa> buscarTodasEmpresas() {

		Conexao conexao = new Conexao();
		List<Empresa> empresas = new ArrayList<Empresa>();

		try {

			PreparedStatement stmt = conexao.getConnection().prepareStatement("SELECT * FROM empresa");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Empresa empresa = new Empresa(rs.getString("nomeempresa"), rs.getString("cnpj"),
						rs.getString("endereco"), rs.getString("contatonome"), rs.getString("ContatoTelefone"),
						rs.getInt("id_empresa"));
				empresas.add(empresa);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empresas;
	}
}