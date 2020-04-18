package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Professor;
import service.ProfessorService;

@WebServlet("/CadastrarProfessor.do")
public class CadastrarProfessor extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recebendo os dados do usuário: (capturando os parâmetros)
		String cpf = request.getParameter("cpf_professor");
		String nome = request.getParameter("nome_professor");
		String endereco = request.getParameter("endereco_professor");
		int matricula = Integer.parseInt(request.getParameter("matricula_professor"));
		
		// Instanciar um objeto do tipo professor:
		Professor professor = new Professor();
		professor.setCpf(cpf);
		professor.setNome(nome);
		professor.setEndereco(endereco);
		professor.setMatricula(matricula);
		
		// Enviar o objeto professor para a service:
		ProfessorService professorService = new ProfessorService();
		professorService.cadastrar(professor);
		
		
	}

}
