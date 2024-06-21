package controller.sportscenter;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.SportsCenterDao;

@WebServlet("/sportsCenter")
public class SportsCenterController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "체육시설");
		try {

			int p = request.getParameter("p") == null ? 1 : Integer.parseInt(request.getParameter("p"));

			int size = 10;
			// int start = (size * p) - (size-1);
			int start = size * (p - 1) + 1;
			int end = size * p;

			SportsCenterDao sportsCenterDao = new SportsCenterDao();
			int count = sportsCenterDao.countAll();
			int totalPages = count / size + (count % size > 0 ? 1 : 0);

			request.setAttribute("sportsCenters", sportsCenterDao.findAll(start, end));
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("currentPage",  p);
			
			request.getRequestDispatcher("/WEB-INF/view/sportscenter/list.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
