package dev.kontas.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dev.kontas.models.Event_Grade;
import dev.kontas.util.JDBCConnection;

public class Event_GradeImplRepo implements Event_GradeRepo {

	public static Connection conn = JDBCConnection.getConnection();
	@Override
	public Event_Grade getGrade(int id) {
		// TODO Auto-generated method stub
		try {

			String sql = "SELECT * FROM event_grade WHERE event_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Event_Grade a = new Event_Grade();
				a.setEvent_id(rs.getInt("EVENT_ID"));
				a.setEvent_grade(rs.getString("EVENT_GRADE"));
				
				
				return a;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}


	@Override
	public boolean addGrade(Event_Grade a) {
		// TODO Auto-generated method stub
		try {

			
			String sql = "CALL add_event_grader(?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, Integer.toString(a.getEvent_id()));
			cs.setString(2, a.getEvent_grade());
	

			cs.execute();
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}


	@Override
	public List<Event_Grade> getAllGrade() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateGrade(Event_Grade change) {
		// TODO Auto-generated method stub
		try {

			System.out.println(change);
			String sql = "UPDATE event_grade SET event_grade=? WHERE event_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, change.getEvent_grade().toString());
			ps.setString(2, Integer.toString(change.getEvent_id()));
			
			

			ps.executeQuery();
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}


	@Override
	public boolean deleteGrade(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
