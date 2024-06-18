package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.UserDao;
import model.vo.Users;

@WebServlet("/login-handle")
public class LoginHandleController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setAttribute("title", "로그인");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		try {
			UserDao userDao = new UserDao();
			Users user = userDao.findById(id);
			if(user == null || !user.getPassword().equals(password)) {
				request.getRequestDispatcher("/WEB-INF/view/login-error.jsp").forward(request, response);
			}else {
				request.getSession().setAttribute("authUser", user);
				String redirectUrl = (String)request.getSession().getAttribute("redirectUrl");
				response.sendRedirect(request.getContextPath()+redirectUrl);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/view/login-error.jsp").forward(request, response);
		}
	}
}
