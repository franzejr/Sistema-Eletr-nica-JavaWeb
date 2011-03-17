package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import bean.Aparelho;
import bean.Cliente;

public class AparelhoDAO {

	public boolean inserir(Aparelho aparelho) {

		Connection con = Conexao.conecta();

		String sql = "insert into aparelhos (nome, modelo, marca, defeito, observacoes,serie) values (?,?,?,?,?,?)";

		PreparedStatement statement;
		try {
			statement = (PreparedStatement) con.prepareStatement(sql);
			statement.setString(1, aparelho.getNome());
			statement.setString(2, aparelho.getModelo());
			statement.setString(3, aparelho.getMarca());
			statement.setString(4, aparelho.getDefeito());
			statement.setString(5, aparelho.getObservacoes());
			statement.setString(6, aparelho.getSerie());
			
			// Executando o PreparedStatement
			statement.executeUpdate();

			statement.close();

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<Aparelho> listar() {

		List<Aparelho> aparelhos = new ArrayList<Aparelho>();

		// Obtendo um statement a partir de uma conexao
		Statement stmt;
		try {
			stmt = Conexao.conecta().createStatement();
			// SQL que sera executado
			String command = "select * from aparelhos";
			// Recuperando os dados
			ResultSet rs = stmt.executeQuery(command);
			// Percorrendo o ResultSet
			while (rs.next()) {
				Aparelho aparelho = new Aparelho();
				// Faz a leitura dos Dados da linha
				aparelho.setId(rs.getInt("id"));
				aparelho.setNome(rs.getString("nome"));
				aparelho.setMarca(rs.getString("marca"));
				aparelho.setModelo(rs.getString("modelo"));
				aparelho.setDefeito(rs.getString("defeito"));
				aparelho.setObservacoes(rs.getString("observacoes"));
				aparelho.setSerie(rs.getString("serie"));
				aparelhos.add(aparelho);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aparelhos;
	}

	public boolean editar(Aparelho aparelho) {
		try {
			// SQL que será executado
			String sql = "update aparelhos set nome = ? , modelo= ?, marca=?, defeito=?, observacoes=?,serie=? where id=?";
			// Obtendo um PreparedStatement a partir de uma conexao
			PreparedStatement pstmt = (PreparedStatement) Conexao.conecta().prepareStatement(sql);

			// Setando as variaveis
			pstmt.setString(1, aparelho.getNome());
			pstmt.setString(2, aparelho.getModelo());
			pstmt.setString(3, aparelho.getMarca());
			pstmt.setString(4, aparelho.getDefeito());
			pstmt.setString(5, aparelho.getObservacoes());
			pstmt.setString(6, aparelho.getSerie());
			pstmt.setInt(7, aparelho.getId());

			// Executando o PreparedStatement
			pstmt.executeUpdate();
			// Fechando o PreparedStatement
			pstmt.close();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean remover(Aparelho aparelho) {
		try {
			// SQL que será executado
			String sql = "delete from aparelhos where id=" + aparelho.getId();
			// Obtendo um PreparedStatement a partir de uma conexão
			PreparedStatement pstmt = (PreparedStatement) Conexao.conecta().prepareStatement(sql);
			// Setando as variáveis
			// pstmt.setInt(1,cliente.getId());
			// Executando o PreparedStatement
			pstmt.execute(sql);
			// Fechando o PreparedStatement
			pstmt.close();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
