package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Professor;

import java.sql.ResultSet;

/**
 * Padrão de projeto Data Access Object (DAO)
 */
public class ProfessorDAO {
	
	/**
	 * Objeto de conexão com o banco de dados:
	 */
	private Connection conexao;
	
	public ProfessorDAO() {
		/**
		 * Pegando a conexão com o ConnectionFactory:
		 */
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Professor professor) {
			
		String inserir = "INSERT INTO professor "
				+ " (matricula, cpf, nome, endereco) "
				+ " VALUES (?, ?, ?, ?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, professor.getMatricula());
			pst.setString(2, professor.getCpf());
			pst.setString(3, professor.getNome());
			pst.setString(4, professor.getEndereco());
			
			//PROFESSOR: MATRICULA: 456, CPF: 12451519, NOME: JOÃO, ENDEREÇO: RUA DAS FLORES
			
			/*INSERT INTO professor (matricula, cpf, nome, endereco) 
				VALUES ( 456, "12451519", "JOÃO", "RUA DAS FLORES" )*/
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Professor.");
			ex.printStackTrace();
			
		}
	}
	
	public void alterar(Professor professor) {
		
		String inserir = "UPDATE professor "
				+ "SET cpf = ?, nome = ?, endereco = ? "
				+ " WHERE matricula = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setString(1, professor.getCpf());
			pst.setString(2, professor.getNome());
			pst.setString(3, professor.getEndereco());
			pst.setInt(4, professor.getMatricula());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Professor.");
			ex.printStackTrace();
			
		}
	}
	
	public void excluir(Professor professor) {
		
		String inserir = "DELETE FROM professor "
				+ " WHERE matricula = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, professor.getMatricula());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Professor.");
			ex.printStackTrace();
		}
	}
	
	public Professor consultar(int matricula) { // consultar(963)
		
		String inserir = "SELECT * FROM professor "
				+ " WHERE matricula = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, matricula);
			
					
			ResultSet resultado = pst.executeQuery();
			
			Professor p = null;
			if (resultado.next() == true) {
				p = new Professor();
				p.setCpf(resultado.getString("cpf"));
				p.setEndereco(resultado.getString("endereco"));
				p.setMatricula(resultado.getInt("matricula"));
				p.setNome(resultado.getString("nome"));
			}
			return p;
			
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Professor.");
			ex.printStackTrace();
			
			return null;
		}
	}

	
	public ArrayList<Professor> listarProfessores() {
		
		String inserir = "SELECT * FROM professor";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Professor> lista = new ArrayList<>();
			
			while (resultado.next()) {
				Professor p = new Professor();
				p.setCpf(resultado.getString("cpf"));
				p.setEndereco(resultado.getString("endereco"));
				p.setMatricula(resultado.getInt("matricula"));
				p.setNome(resultado.getString("nome"));
				lista.add(p);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Professor.");
			ex.printStackTrace();
			
			return null;
		}
	}

}
