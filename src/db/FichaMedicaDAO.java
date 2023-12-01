package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import seminario.FichaMedica;

public class FichaMedicaDAO {

	public void inserirFichaMedica(FichaMedica fichaMedica) {
		Conexao conexao = new Conexao();
		try {

			PreparedStatement stmt = conexao.getConnection().prepareStatement(
					"INSERT INTO FichaMedica (ID_Motorista, TipoSangue, Alergias, DoencasCronicas, Medicamentos) VALUES (?, ?, ?, ?, ?)");
			stmt.setInt(1, fichaMedica.getIdMotorista());
			stmt.setString(2, fichaMedica.getTipoSangue());
			stmt.setString(3, fichaMedica.getAlergias());
			stmt.setString(4, fichaMedica.getDoencasCronicas());
			stmt.setString(5, fichaMedica.getMedicamentos());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizarFichaMedica(FichaMedica fichaMedica) {
		Conexao conexao = new Conexao();
		try {
			PreparedStatement stmt = conexao.getConnection().prepareStatement(
					"UPDATE FichaMedica SET TipoSangue = ?, Alergias = ?, DoencasCronicas = ?, Medicamentos = ? WHERE ID_Motorista = ?");
			stmt.setString(1, fichaMedica.getTipoSangue());
			stmt.setString(2, fichaMedica.getAlergias());
			stmt.setString(3, fichaMedica.getDoencasCronicas());
			stmt.setString(4, fichaMedica.getMedicamentos());
			stmt.setInt(5, fichaMedica.getIdMotorista());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletarFichaMedica(int idFichaMedica) {
		Conexao conexao = new Conexao();
		try {
			PreparedStatement stmt = conexao.getConnection()
					.prepareStatement("DELETE FROM FichaMedica WHERE ID_Motorista = ?");
			stmt.setInt(1, idFichaMedica);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<FichaMedica> buscarTodasFichas() {
		Conexao conexao = new Conexao();
		List<FichaMedica> ficha = new ArrayList<FichaMedica>();
		
		try{
			PreparedStatement stmt = conexao.getConnection().prepareStatement("SELECT * FROM fichamedica");
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				FichaMedica fichaMedica = new FichaMedica(rs.getInt("id_motorista"),
			    rs.getString("tipoSangue"),
			    rs.getString("alergias"),
			     rs.getString("doencasCronicas"),
			     rs.getString("medicamentos"));
				
				ficha.add(fichaMedica);
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} return ficha;
	}
}