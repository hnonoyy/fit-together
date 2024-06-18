package controller.events;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.EventDao;
import model.dao.ParticipantDao;
import model.vo.Events;
import model.vo.Participants;
import model.vo.Users;

@WebServlet("/events/join/*")
public class EventJoinController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			EventDao eventDao = new EventDao();
			ParticipantDao participantDao = new ParticipantDao();
			
			String[] items = request.getRequestURI().split("/");
			int eventId = Integer.parseInt(items[items.length-1]);

			Users authUser = (Users)request.getSession().getAttribute("authUser");
			if(authUser == null) {
				response.sendRedirect(request.getContextPath()+"/login?url=/events/"+eventId);
				return;
			}
			String authUserId = authUser.getId();
			Date jointAt = new Date(System.currentTimeMillis());
			
			List<Participants> participants = participantDao.findByEventId(eventId);
			List<String> userIds = new ArrayList<>();
			for(Participants one : participants) {
				userIds.add(one.getUserId());
			}
			Events events = eventDao.findById(eventId);
			
			if(!userIds.contains(authUserId)&& events.getAttendee() < events.getCapacity()) {
				
				Participants p = new Participants(-1,authUserId,eventId,jointAt);
				
				participantDao.saveParticipant(p);
				
				eventDao.increaseAttendeeById(eventId);
				response.sendRedirect(request.getContextPath()+"/events/"+eventId);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
