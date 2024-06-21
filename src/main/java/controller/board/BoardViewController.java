package controller.board;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.BoardDao;
import model.vo.Board;

@WebServlet("/board/*")
public class BoardViewController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String uri = request.getRequestURI();
			int no = Integer.parseInt(uri.substring(uri.lastIndexOf("/") + 1));
			BoardDao boardDao = new BoardDao();
			
			Board board = boardDao.findByNo(no);
			boardDao.increaseReadCntByNo(no);
			request.setAttribute("board", board);
			request.getRequestDispatcher("/WEB-INF/view/board/view.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
