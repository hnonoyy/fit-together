package controller.events;

import java.io.IOException;
import java.sql.Date;

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

@WebServlet("/events/new-handle")
public class EventsNewHandleController extends HttpServlet  {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			EventDao eventDao = new EventDao();
			
			Users authUser = (Users) request.getSession().getAttribute("authUser");

			String title = request.getParameter("title");
			String description = request.getParameter("description");
			String tag = request.getParameter("tag");
			int sportsCenterId = Integer.parseInt(request.getParameter("sportsCenterId"));
			String hostId = authUser.getId();	
			Date openAt = Date.valueOf(request.getParameter("openAt"));
			int capacity = Integer.parseInt(request.getParameter("capacity"));
			int attendee = 1;
			Date registerAt = new Date(System.currentTimeMillis());
			
			int id = eventDao.generateKey();
			Events events = new Events(id,title,description,tag,sportsCenterId,hostId,openAt,capacity,attendee,registerAt);
			
			boolean r = eventDao.saveEvent(events);
			
			if(r) {
				Participants participant = new Participants();
				participant.setUserId(hostId);
				participant.setJoinAt(registerAt);
				participant.setEventId(id);
				
				ParticipantDao participantDao = new ParticipantDao();
				participantDao.saveParticipant(participant);
			}
			
			//response.sendRedirect(request.getContextPath()+"/events/view?id=?"+id);
			response.sendRedirect(request.getContextPath()+"/events/"+id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
