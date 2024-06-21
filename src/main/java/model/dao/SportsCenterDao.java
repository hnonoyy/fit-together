package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.SportsCenter;
import oracle.jdbc.datasource.impl.OracleDataSource;

public class SportsCenterDao {
	
	public int countAll() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.
					prepareStatement("SELECT COUNT(*) FROM SPORTSCENTER");
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				int cnt = rs.getInt("count(*)");
				return cnt;
			} else {
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
			
	}
	
	
	public List<SportsCenter> findAll(int start, int end) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.
					prepareStatement("SELECT * FROM (SELECT ROWNUM RN, g.* FROM (SELECT * FROM SPORTSCENTER ORDER BY NAME)g) WHERE RN BETWEEN ? AND ?");
			stmt.setInt(1, start);
			stmt.setInt(2, end);
			ResultSet rs = stmt.executeQuery();
			List<SportsCenter> sportsCenter = new ArrayList<>();
			
			while(rs.next()) {
				SportsCenter one = new SportsCenter();

				one.setId(rs.getInt("id"));
				one.setDistrict(rs.getString("district"));
				one.setManagement(rs.getString("management"));
				one.setName(rs.getString("name"));
				one.setOwner(rs.getString("owner"));
				one.setType(rs.getString("type"));
				sportsCenter.add(one);
			}
			return sportsCenter;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<SportsCenter> findBytype(String type) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM SPORTSCENTER WHERE TYPE=?");
			stmt.setString(1, type);
			ResultSet rs = stmt.executeQuery();
			List<SportsCenter> sportsCenter = new ArrayList<>();
			
			while(rs.next()) {
				SportsCenter one = new SportsCenter();
				one.setId(rs.getInt("id"));
				
				sportsCenter.add(one);
			}
			return sportsCenter;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public SportsCenter findById(int id) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM SPORTSCENTER WHERE ID=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				SportsCenter one = new SportsCenter();

				one.setId(rs.getInt("id"));
				one.setDistrict(rs.getString("district"));
				one.setManagement(rs.getString("management"));
				one.setName(rs.getString("name"));
				one.setOwner(rs.getString("owner"));
				one.setType(rs.getString("type"));
				return one;
				
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<String> sportsCenterDistinctTypes() throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//3.35.208.47:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");
		
		try (Connection conn = ods.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT DISTINCT TYPE FROM SPORTSCENTER");
			
			ResultSet rs = stmt.executeQuery();
			List<String> types = new ArrayList<>();
			
			while (rs.next()) {
				types.add(rs.getString("type"));
			}
			
			return types;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
