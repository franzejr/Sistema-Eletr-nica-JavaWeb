package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import bean.Cliente;

import com.mysql.jdbc.PreparedStatement;

public class ClienteDAO {

	public boolean inserir(Cliente cliente) {

		Connection con = Conexao.conecta();

		String sql = "insert into clientes (nome, telefoneFixo, celular, endereco) values (?,?,?,?)";

		try {
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getTelefoneFixo());
			statement.setString(3, cliente.getCelular());
			statement.setString(4, cliente.getEndereco());

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

	public List<Cliente> listar() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		//Obtendo um statement a partir de uma conexao
		Statement stmt;
		try {
			stmt = Conexao.conecta().createStatement();
		//SQL que sera executado
		String command = "select * from clientes";
		//Recuperando os dados
		ResultSet rs = stmt.executeQuery(command);
		//Percorrendo o ResultSet
		while(rs.next()){
			Cliente cliente = new Cliente();
			//Faz a leitura dos dados da linha
			cliente.setId(rs.getInt("id"));
			cliente.setNome(rs.getString("nome"));
			cliente.setEndereco(rs.getString("endereco"));
			cliente.setTelefoneFixo(rs.getString("telefoneFixo"));
			cliente.setCelular(rs.getString("celular"));
			clientes.add(cliente);
			
		}
		
		return clientes;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
	public List<Cliente> buscarPorNome(String nome) {
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			// SQL que será executado
			String sql = "select * from clientes where nome like ?";
			// Obtendo um PreparedStatement a partir de uma conexão
			PreparedStatement pstmt = (PreparedStatement) Conexao.conecta().prepareStatement(sql);
			// Setando as variáveis
			pstmt.setString(1, "%" + nome + "%");
			// Recuperando os dados
			ResultSet rs = pstmt.executeQuery();
			// Percorrento o ResultSet
			while (rs.next()) {
				Cliente cliente = new Cliente();
				// Faz a leitura dos dados da linha
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setTelefoneFixo(rs.getString("telefoneFixo"));
				cliente.setCelular(rs.getString("celular"));
				clientes.add(cliente);
			}
			// Fechando o PreparedStatement
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}
	
	public boolean editar(Cliente cliente){
		try {
			//SQL que será executado
			String sql = "update clientes set nome = ? , endereco= ?, telefoneFixo=?, celular=? where id=?";		 
			//Obtendo um PreparedStatement a partir de uma conexao
			PreparedStatement pstmt = (PreparedStatement) Conexao.conecta().prepareStatement(sql);
		
		//Setando as variaveis
		pstmt.setString(1, cliente.getNome());
		pstmt.setString(2, cliente.getEndereco());
		pstmt.setString(3, cliente.getTelefoneFixo());
		pstmt.setString(4, cliente.getCelular());
		pstmt.setInt(5, cliente.getId());
		
		//Executando o PreparedStatement
		pstmt.executeUpdate();
		//Fechando o PreparedStatement
		pstmt.close();
		
		return true;
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}

	
	}
	
	public boolean remover(Cliente cliente)
	{		
		try {
			// SQL que será executado
			String sql = "delete from clientes where id="+cliente.getId();
			// Obtendo um PreparedStatement a partir de uma conexão
			PreparedStatement pstmt = (PreparedStatement) Conexao.conecta().prepareStatement(sql);
			// Setando as variáveis
			//pstmt.setInt(1,cliente.getId());
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
