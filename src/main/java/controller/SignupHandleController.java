package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.UserDao;
import model.vo.Users;

@WebServlet("/signup-handle")
public class SignupHandleController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String id = (String)request.getParameter("id");
			String password = (String)request.getParameter("password");
			String name = (String)request.getParameter("name");
			String email = (String)request.getParameter("email");
			int birth = Integer.parseInt(request.getParameter("birth"));
			String gender = (String)request.getParameter("gender");
			String[] interests = request.getParameterValues("interest");
			if(interests == null) {
				interests = new String[0];
			}
			
			UserDao userdao = new UserDao();
			boolean result = false;
			
			Users exist = userdao.findById(id);
			
			if(exist == null) {
				Users one = new Users(id,password,name,gender,birth,email,String.join(",", interests));
				result = userdao.saveUser(one);
			}
			if(result) {
				response.sendRedirect(request.getContextPath()+"/index");
			}else {
				response.sendRedirect(request.getContextPath()+"/signup?error");
			}
		} catch (Exception e) {
			System.out.println(e);
			response.sendRedirect(request.getContextPath()+"/signup?error");
		}
		
	}
	
}
