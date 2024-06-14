package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Events;
import oracle.jdbc.datasource.impl.OracleDataSource;

public class EventDao {

	public boolean saveEvent(Events newEvents) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO EVENTS VALUES(EVENTS_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, newEvents.getTitle());
			stmt.setString(2, newEvents.getDescription());
			stmt.setString(3, newEvents.getTag());
			stmt.setInt(4, newEvents.getsportsCenterId());
			stmt.setString(5, newEvents.getHostId());
			stmt.setDate(6, newEvents.getOpenAt());
			stmt.setInt(7, newEvents.getCapacity());
			stmt.setInt(5, newEvents.getAttendee());
			stmt.setDate(5, newEvents.getRegisterAt());

			int r = stmt.executeUpdate();
			return r == 1 ? true : false;

		} catch (Exception e) {
			System.out.println(e);
			return false;
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
			System.out.println(e);
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
			System.out.println(e);
			return null;
		}
	}
	
	public List<Events> findTagOrderByOpenAt(String tag) throws SQLException {
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
			System.out.println(e);
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
			System.out.println(e);
			return false;
		}
	}

}
