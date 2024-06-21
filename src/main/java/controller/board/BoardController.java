package controller.board;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.BoardDao;
import model.vo.Board;

@WebServlet("/board/list")
public class BoardController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "자유게시판");
		try {
			int p = request.getParameter("p") == null ? 1 : Integer.parseInt(request.getParameter("p"));

			int size = 5;
			int start = size * (p-1) + 1;
			int end = size * p;

			
			BoardDao boardDao = new BoardDao();
			List<Board> board = boardDao.findByAll();
			
			int count = boardDao.countAll();
			int totalPages = count / size + (count % size > 0 ? 1 : 0);
			
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("board", board);
			request.setAttribute("currentPage",  p);
			
			
			
			request.getRequestDispatcher("/WEB-INF/view/board/list.jsp").forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
