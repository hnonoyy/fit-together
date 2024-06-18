package controller.events;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.SportsCenterDao;

@WebServlet("/events/design")
public class EventsDesignController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "행사등록");
		
		if(request.getSession().getAttribute("authUser") == null ) {
			response.sendRedirect(request.getContextPath()+"/login?url=/events/design");
			return;
		}
		try {
			SportsCenterDao sportscenterDao = new SportsCenterDao();
			List<String> type = sportscenterDao.sportsCenterDistinctTypes();
			request.setAttribute("types", type);
			request.getRequestDispatcher("/WEB-INF/view/events/design.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/view/events/error.jsp").forward(request, response);
		}
	}
}
