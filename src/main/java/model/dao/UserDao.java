package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.vo.Users;
import oracle.jdbc.datasource.impl.OracleDataSource;

public class UserDao {

	public boolean save(Users newUsers) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("INSERT INTO USERS VALUES(?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, newUsers.getId());
			stmt.setString(2, newUsers.getPassword());
			stmt.setString(3, newUsers.getName());
			stmt.setString(4, newUsers.getGender());
			stmt.setInt(5, newUsers.getBirth());
			stmt.setString(6, newUsers.getEmail());
			stmt.setString(7, newUsers.getInterest());
			
			int r = stmt.executeUpdate();
			return r == 1 ? true : false;

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public Users findById(String id) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			// 식별키로 조회하고
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USERS WHERE ID=?");
			stmt.setString(1, id);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
			} else {
				return null;
			}

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
