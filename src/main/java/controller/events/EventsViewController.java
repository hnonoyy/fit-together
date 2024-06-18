package controller.events;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.EventDao;
import model.dao.ParticipantDao;
import model.dao.SportsCenterDao;
import model.vo.Events;
import model.vo.Participants;
import model.vo.SportsCenter;
import model.vo.Users;

@WebServlet("/events/*")
public class EventsViewController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("/events/*");
		request.setAttribute("title", "신청 행사");
		try {
			Users authUser = (Users)request.getSession().getAttribute("authUser");
			
			String uri = request.getRequestURI();
			int id = Integer.parseInt(uri.substring(uri.lastIndexOf("/") + 1));
			
			if(authUser == null) {
				response.sendRedirect(request.getContextPath()+"/login?url=/events/"+id);
				return;
			}
			
			String authUserId = authUser.getId();
			
			EventDao eventDao = new EventDao();
			Events events = eventDao.findById(id);
			request.setAttribute("events", events);
			
			ParticipantDao participantDao = new ParticipantDao();
			SportsCenterDao sportCenterDao = new SportsCenterDao();
			
			List<Participants> participants =participantDao.findByEventId(id);
			request.setAttribute("participants", participants);
			request.setAttribute("partSize", participants.size());
			
			SportsCenter sportsCenter= sportCenterDao.findById(events.getsportsCenterId());
			request.setAttribute("sportsCenter", sportsCenter);
			
			Date nowDay = new Date(System.currentTimeMillis());
			Date eventDay = events.getOpenAt();
			long diffMllies = nowDay.getTime() - eventDay.getTime();
			double diffDay = (double)diffMllies/(1000 * 60 * 60 * 24);
			int dday= (int)Math.ceil(diffDay);
			
			request.setAttribute("dday", dday);
			
			List<String> userIds = new ArrayList<>();
			for(Participants one : participants) {
				userIds.add(one.getUserId());
			}
			boolean isUserId = false;
			if(userIds.contains(authUserId)) {
				isUserId =true;
			}
			request.setAttribute("isUserId", isUserId);
			
			String tab = request.getParameter("tab");
			if(tab == null) {
				request.getRequestDispatcher("/WEB-INF/view/events/view-default.jsp").forward(request, response);
			}else if(tab.equals("comments")) {
				request.getRequestDispatcher("/WEB-INF/view/events/view-comments.jsp").forward(request, response);
			}
						
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/view/events/error.jsp").forward(request, response);
		}
		
		
	}
}
