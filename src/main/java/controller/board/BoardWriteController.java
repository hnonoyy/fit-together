package controller.board;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "게시글 작성");
		
		if(request.getSession().getAttribute("authUser") == null ) {
			response.sendRedirect(request.getContextPath()+"/login?url=/board/write");
			return;
		}

		request.getRequestDispatcher("/WEB-INF/view/board/write.jsp").forward(request, response);
	}
}
