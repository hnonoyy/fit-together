package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Participants;
import model.vo.Users;
import model.vo.complex.ParticipantWithUsersDetail;
import oracle.jdbc.datasource.impl.OracleDataSource;

public class ParticipantDao {

	public boolean saveParticipant(Participants newParticipant) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO PARTICIPANTS VALUES (PARTICIPANTS_SEQ.NEXTVAL,?, ?, ?)");
			
			stmt.setString(1, newParticipant.getUserId());
			stmt.setInt(2, newParticipant.getEventId());
			stmt.setDate(3, newParticipant.getJoinAt());

			int r = stmt.executeUpdate();
			return r == 1 ? true : false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Participants> findByEventId(int eventId) throws SQLException  {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PARTICIPANTS WHERE EVENT_ID=?");
			stmt.setInt(1, eventId);

			ResultSet rs = stmt.executeQuery();
			List<Participants> participants = new ArrayList<>();
			while (rs.next()) {
				Participants one = new Participants();

				one.setId(rs.getInt("id"));
				one.setEventId(rs.getInt("event_id"));
				one.setUserId(rs.getString("user_id"));
				one.setJoinAt(rs.getDate("join_at"));
				participants.add(one);
			}

			return participants;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}	
	
	public List<Participants> findByUserId(String userId) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PARTICIPANTS WHERE USER_ID=?");
			stmt.setString(1, userId);

			ResultSet rs = stmt.executeQuery();
			List<Participants> participants = new ArrayList<>();
			while (rs.next()) {
				Participants one = new Participants();

				one.setId(rs.getInt("id"));
				one.setEventId(rs.getInt("event_id"));
				one.setUserId(rs.getString("user_id"));
				one.setJoinAt(rs.getDate("join_at"));
				participants.add(one);
			}

			return participants;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<ParticipantWithUsersDetail> findByEventIdWithUserDetail(int eventId) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn
					.prepareStatement("SELECT * FROM PARTICIPANTS p JOIN USERS u ON p.USER_ID = u.ID WHERE EVENT_ID=?");
			stmt.setInt(1, eventId);

			ResultSet rs = stmt.executeQuery();
			List<ParticipantWithUsersDetail> participants = new ArrayList<>();
			while (rs.next()) {
				Participants one = new Participants();
				one.setId(rs.getInt("id"));
				one.setEventId(rs.getInt("event_id"));
				one.setUserId(rs.getString("user_id"));
				one.setJoinAt(rs.getDate("join_at"));

				Users users = new Users();
				users.setId(rs.getString("id"));
				users.setPassword(rs.getString("password"));
				users.setName(rs.getString("name"));
				users.setGender(rs.getString("gender"));
				users.setBirth(rs.getInt("birth"));
				users.setEmail(rs.getString("email"));
				users.setInterest(rs.getString("interest"));
				
				ParticipantWithUsersDetail pwud = new ParticipantWithUsersDetail();
				pwud.setParticipants(one);
				pwud.setUsers(users);
				
				participants.add(pwud);
			}

			return participants;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
