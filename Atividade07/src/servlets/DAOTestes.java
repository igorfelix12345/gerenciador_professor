package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProfessorDAO;
import model.Professor;

@WebServlet("/DAOTestes.do")
public class DAOTestes extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Teste de inserção:
		Professor p = new Professor(123, "123.456.789-09",
			"Maria Oliveira", "Rua dos Ladrilhos, 456");
		
		ProfessorDAO pDAO = new ProfessorDAO();
		
		pDAO.alterar(p);
		
		// Teste de consulta:
		Professor p1 = pDAO.consultar(123);
		
		//System.out.println(p1.getNome());	}
		
		System.out.println(pDAO.listarProfessores().size());
	}

}
