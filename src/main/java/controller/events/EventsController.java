package controller.events;

import java.io.IOException;
import java.util.ArrayList;
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
import model.vo.Users;
import model.vo.complex.EventsWithDetail;

@WebServlet("/events")
public class EventsController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "행사목록");
		try {
			//파라미터,세션 뽑을 것이 있는지?
			
			Users authUser = (Users)request.getSession().getAttribute("authUser");
			
			EventDao eventDao = new EventDao();
			SportsCenterDao sportCenterDao = new SportsCenterDao();
			ParticipantDao participantDao = new ParticipantDao();
			
			List<Events> list = eventDao.findAll();
			
			List<EventsWithDetail> detailList = new ArrayList<>();
			for(Events e : list) {
				EventsWithDetail one= new EventsWithDetail();
				one.setEvent(e);
				one.setSportsCenter(sportCenterDao.findById(e.getsportsCenterId()));
				if(authUser == null) {
					one.setJoined(false);
				}else {
					List<Participants> participants = participantDao.findByEventId(e.getId());
					List<String> ids = new ArrayList<>();
					for(Participants p : participants) {
						ids.add(p.getUserId());
					}
					if(ids.contains(authUser.getId())) {
						one.setJoined(true);
					}else {
						one.setJoined(false);
					}
				}
				
				detailList.add(one);
			}
			request.setAttribute("events", detailList);
			
			request.getRequestDispatcher("/WEB-INF/view/events/list.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
