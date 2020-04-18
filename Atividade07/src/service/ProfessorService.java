package service;

import dao.ProfessorDAO;
import model.Professor;
import java.util.ArrayList;

public class ProfessorService {

	private ProfessorDAO professorDAO;
	
	/**
	 * Instancia um objeto ProfessorDAO dentro do atributo professorDAO.
	 */
	public ProfessorService() {
		this.professorDAO = new ProfessorDAO();
	}
	
	public void cadastrar(Professor professor) {
		this.professorDAO.cadastrar(professor);
	}
	
	public void alterar(Professor professor) {
		this.professorDAO.alterar(professor);
	}
	
	public void excluir(Professor professor) {
		this.professorDAO.excluir(professor);
	}
	
	public Professor consultar(int matricula) {
		return this.professorDAO.consultar(matricula);
	}
	
	public ArrayList<Professor> listarProfessores() {
		return this.professorDAO.listarProfessores();
	}
}








