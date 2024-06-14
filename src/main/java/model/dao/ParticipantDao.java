package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.vo.Participants;
import oracle.jdbc.datasource.impl.OracleDataSource;

public class ParticipantDao {

	public boolean saveParticipant(Participants newParticipant) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO PARTICIPANTS VALUE (PARTICIPANTS_SEQ.NEXTVAL,?, ?, ?)");
			
			stmt.setString(1, newParticipant.getUserId());
			stmt.setString(2, newParticipant.getEventId());
			stmt.setDate(3, newParticipant.getJoinAt());

			int r = stmt.executeUpdate();
			return r == 1 ? true : false;

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public Participants findByEventId(String eventId) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * PARTICIPANTS WHERE EVENT_ID=?");
			stmt.setString(1, eventId);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new Participants(rs.getInt("id"), rs.getString("user_id"), rs.getString("event_id"), rs.getDate("join_at"));
			} else {
				return null;
			}

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}	
	
	public Participants findByUserId(String userId) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * PARTICIPANTS WHERE USER_ID=?");
			stmt.setString(1, userId);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new Participants(rs.getInt("id"), rs.getString("user_id"), rs.getString("event_id"), rs.getDate("join_at"));
			} else {
				return null;
			}

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}	
}
