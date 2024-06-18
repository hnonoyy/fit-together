package controller.events;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.SportsCenterDao;
import model.vo.SportsCenter;

@WebServlet("/events/new")
public class EventsNewController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "행사등록");
		try {
			
			String type = request.getParameter("type");
			SportsCenterDao sportsCenterDao = new SportsCenterDao();
			List<SportsCenter> sportsCenter = sportsCenterDao.findBytype(type);
			request.setAttribute("sportsCenter", sportsCenter);
			request.getRequestDispatcher("/WEB-INF/view/events/new.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/view/events/error.jsp").forward(request, response);
		}
	}
}
