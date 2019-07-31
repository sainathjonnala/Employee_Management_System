package comakeit.assessment1.employee._management.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comakeit.assessment1.employee._management.Bean.AdminBean;
import comakeit.assessment1.employee._management.DAO.AdminValidation_DAO;

@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher requestDispatcher = null;

		HttpSession session = request.getSession();

		AdminValidation_DAO adminValidaiton = new AdminValidation_DAO();

		AdminBean adminBean = new AdminBean();

		adminBean.setUsername((String) request.getParameter("username"));
		adminBean.setPassword((String) request.getParameter("password"));

		session.setAttribute("adminBean", adminBean);

		try {

			if (adminValidaiton.isValidAdmin(adminBean)) {
				requestDispatcher = request.getRequestDispatcher("AdminOperations.jsp");
				requestDispatcher.forward(request, response);
			} else {
				requestDispatcher = request.getRequestDispatcher("ErrorPage.jsp?error=login");
				requestDispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
