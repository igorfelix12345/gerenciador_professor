package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ProfessorService;
import model.Professor;

@WebServlet("/ListarProfessores.do")
public class ListarProfessores extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Solicitar à service a lista de professores:
		ProfessorService professorService = new ProfessorService();
		// Instanciando uma lista de professores (vazia):
		ArrayList<Professor> listaProfessores = null;
		// Carregando a lista com os professores do banco de dados:
		listaProfessores = professorService.listarProfessores();
		
		// Definir o tipo de conteúdo a ser enviado:
		response.setContentType("text/html");
		
		// Criando um objeto de saída de caracteres:
		PrintWriter saida = response.getWriter();
		
		// Percorrer toda a lista de objetos professor e imprimir os dados:
		saida.println("<html>");
		saida.println("<body>");
		saida.println("<table>");
		
		listaProfessores.forEach( 
			p -> {
				saida.println("<tr>");
				saida.println("<td>");
				saida.println(p.getNome());
				saida.println("</td>");
				saida.println("<td>");
				saida.println(p.getCpf());
				saida.println("</td>");
				saida.println("<td>");
				saida.println(p.getMatricula());
				saida.println("</td>");
				saida.println("<td>");
				saida.println(p.getEndereco());
				saida.println("</td>");
				
				/* Criando uma coluna para o link de exclusão: */
				saida.println("<td>");
				saida.println("<a href='ExcluirProfessor.do?matricula=" 
							+ p.getMatricula() + "'> Excluir </a>");
				
				saida.println("</td>");
				
				/* Criando uma coluna para o link de atualização: */
				saida.println("<td>");
				saida.println("<a href='AlterarProfessor.do?matricula="
							+ p.getMatricula() + "'> Alterar </a>");
				saida.println("</td>");
				
				saida.println("</tr>");
			} 
		);
		
		saida.println("</table>");
		
	}

}








