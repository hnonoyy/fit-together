package controller.board;

import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.BoardDao;
import model.vo.Board;
import model.vo.Users;

@WebServlet("/board/write-handle")
public class BoardWriteHandelController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			BoardDao boardDao = new BoardDao();
			
			Users authUser = (Users) request.getSession().getAttribute("authUser");
			
			String writeId = authUser.getId();
			String title = request.getParameter("title");
			String body = request.getParameter("body");
			Date writeAt = new Date(System.currentTimeMillis());
			
			Board board = new Board(0,writeId,title,body,writeAt,0);
			
			boolean r;
			r = boardDao.save(board);
			if(r) {
				response.sendRedirect(request.getContextPath()+"/board/list");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
