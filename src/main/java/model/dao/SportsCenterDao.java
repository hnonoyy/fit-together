package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.vo.SportsCenter;
import oracle.jdbc.datasource.impl.OracleDataSource;

public class SportsCenterDao {
	
	
	public List<SportsCenter> sportsCenterType(String type) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			// 식별키로 조회하고
			PreparedStatement stmt = conn.prepareStatement("SELECT DISTINCT TYPE FROM GYMS");
			stmt.setString(1, type);

			ResultSet rs = stmt.executeQuery();
			List<SportsCenter> sportsCenter = new ArrayList<>();
			
			while(rs.next()) {
				SportsCenter one = new SportsCenter(rs.getInt("id"), rs.getString("type"), rs.getString("name"), rs.getString("owner"), rs.getString("management"));  
				sportsCenter.add(one);
			}
			return sportsCenter;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}

	public List<SportsCenter> findBytype(String type) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			// 식별키로 조회하고
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM SPORTSCENTER WHERE TYPE=?");
			stmt.setString(1, type);

			ResultSet rs = stmt.executeQuery();
			List<SportsCenter> sportsCenter = new ArrayList<>();
			
			while(rs.next()) {
				SportsCenter one = new SportsCenter(rs.getInt("id"), rs.getString("type"), rs.getString("name"), rs.getString("owner"), rs.getString("management"));  
				sportsCenter.add(one);
			}
			return sportsCenter;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public SportsCenter findById(int id) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			// 식별키로 조회하고
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM SPORTSCENTER WHERE TYPE=?");
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				return new SportsCenter(rs.getInt("id"), rs.getString("type"), rs.getString("name"), rs.getString("owner"), rs.getString("management"));
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
