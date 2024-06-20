package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Events;
import model.vo.complex.EventTagCount;
import oracle.jdbc.datasource.impl.OracleDataSource;

public class EventDao {

	public int generateKey() throws SQLException{
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");
		
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn
					.prepareStatement("SELECT EVENTS_SEQ.NEXTVAL FROM DUAL");
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int key = rs.getInt("nextval");
				return key;
			}else {
				return -1;
			}	
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public boolean saveEvent(Events events) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO EVENTS VALUES(?,?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, events.getId());
			stmt.setString(2, events.getTitle());
			stmt.setString(3, events.getDescription());
			stmt.setString(4, events.getTag());
			stmt.setInt(5, events.getsportsCenterId());
			stmt.setString(6, events.getHostId());
			stmt.setDate(7, events.getOpenAt());
			stmt.setInt(8, events.getCapacity());
			stmt.setInt(9, events.getAttendee());
			stmt.setDate(10, events.getRegisterAt());

			int r = stmt.executeUpdate();
			return r == 1 ? true : false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Events> findAll() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EVENTS ORDER BY OPEN_AT ASC");

			ResultSet rs = stmt.executeQuery();
			List<Events> events = new ArrayList<Events>();
			while (rs.next()) {
				Events one = new Events(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
						rs.getString("tag"), rs.getInt("sportscenter_id"), rs.getString("host_id"), rs.getDate("open_at"),
						rs.getInt("capacity"), rs.getInt("attendee"), rs.getDate("register_at"));
				events.add(one);
			}

			return events;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Events findById(int id) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EVENTS WHERE ID=?");
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new Events(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
						rs.getString("tag"), rs.getInt("sportscenter_id"), rs.getString("host_id"), rs.getDate("open_at"),
						rs.getInt("capacity"), rs.getInt("attendee"), rs.getDate("register_at"));
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Events> findOrderByOpenAt() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EVENTS ORDER BY OPEN_AT ASC");

			ResultSet rs = stmt.executeQuery();
			List<Events> events = new ArrayList<>();

			while (rs.next()) {
				Events one = new Events(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
						rs.getString("tag"), rs.getInt("sportscenter_id"), rs.getString("host_id"), rs.getDate("open_at"),
						rs.getInt("capacity"), rs.getInt("attendee"), rs.getDate("register_at"));
				events.add(one);
			}
			return events;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Events> findByTag(String tag) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EVENTS WHERE TAG=? ORDER BY OPEN_AT ASC");
			stmt.setString(1, tag);
			
			ResultSet rs = stmt.executeQuery();
			List<Events> events = new ArrayList<>();

			while (rs.next()) {
				Events one = new Events(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
						rs.getString("tag"), rs.getInt("sportscenter_id"), rs.getString("host_id"), rs.getDate("open_at"),
						rs.getInt("capacity"), rs.getInt("attendee"), rs.getDate("register_at"));
				events.add(one);
			}
			return events;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean increaseAttendeeById(int id) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {
			
			PreparedStatement stmt = conn
					.prepareStatement("UPDATE EVENTS SET ATTENDEE = ATTENDEE+1 WHERE ID=?");
			stmt.setInt(1, id);

			int  r= stmt.executeUpdate();

			return r == 1 ? true : false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<EventTagCount> countGroupByTag() throws SQLException{
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");
		
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("select tag, count(*) cnt from events group by tag order by cnt desc");
			
			ResultSet rs = stmt.executeQuery();
			List<EventTagCount> eventTagCount = new ArrayList<>();
			
			while (rs.next()) {
				EventTagCount one = new EventTagCount(rs.getString("tag"), rs.getInt("cnt"));
				eventTagCount.add(one);
			}
			return eventTagCount;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Events> findByTitleLikeOrDescriptionLike(String pattern) throws SQLException{
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EVENTS WHERE TITLE LIKE ? OR DESCRIPTION LIKE ? ORDER BY OPEN_AT ASC");
			stmt.setString(1, "%"+pattern+"%");
			stmt.setString(2, "%"+pattern+"%");
			ResultSet rs = stmt.executeQuery();
			List<Events> events = new ArrayList<Events>();
			while (rs.next()) {
				Events one = new Events(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
						rs.getString("tag"), rs.getInt("sportscenter_id"), rs.getString("host_id"), rs.getDate("open_at"),
						rs.getInt("capacity"), rs.getInt("attendee"), rs.getDate("register_at"));
				events.add(one);
			}

			return events;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}




















