package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Professor;
import service.ProfessorService;

@WebServlet("/ExcluirProfessor.do")
public class ExcluirProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Captura de parâmetros: (a matrícula do professor a ser excluído do BD)
		int matricula = Integer.parseInt(request.getParameter("matricula"));
		
		// Instanciando um objeto do tipo professor:
		Professor professor = new Professor();
		professor.setMatricula(matricula);
		
		// Solicitando à service que remova o professor:
		ProfessorService professorService = new ProfessorService();
		professorService.excluir(professor);
		
	}

}







