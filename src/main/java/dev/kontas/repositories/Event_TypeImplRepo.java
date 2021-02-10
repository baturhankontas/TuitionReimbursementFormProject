package dev.kontas.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dev.kontas.models.Event_Type;
import dev.kontas.util.JDBCConnection;

public class Event_TypeImplRepo implements Event_TypeRepo {

	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public Event_Type getEType(int id) {
		// TODO Auto-generated method stub
		try {

			String sql = "SELECT * FROM event_type WHERE event_type_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Event_Type e = new Event_Type();
				e.setEvent_id(rs.getInt("EVENT_TYPE_ID"));
				e.setEvent_coverage(rs.getInt("EVENT_COVERAGE"));
				e.setName(rs.getString("EVENT_NAME"));
				
				return e;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}


	@Override
	public boolean addEType(Event_Type a) {
		// TODO Auto-generated method stub
		try {

			// Java is unaware of our actor_seq, so
			// its better or easier if we just use our Procedure
			// that abstracted away the use of the Sequence.
			String sql = "CALL add_event_type(?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, Integer.toString(a.getEvent_id()));
			cs.setString(2, Integer.toString(a.getEvent_coverage()));
			cs.setString(3, a.getName());
			// Alternative, use at your own risk.
//			cs.setInt(2, a.getWorth());

			cs.execute();
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Event_Type> getAllEType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEType(Event_Type change) {
		// TODO Auto-generated method stub
		try {

			String sql = "UPDATE event_type SET event_coverage= ?, event_name= ? WHERE event_type_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			
			ps.setString(1, Integer.toString(change.getEvent_coverage()));
			ps.setString(2, change.getName());
			ps.setString(3, Integer.toString(change.getEvent_id()));	
			ps.executeQuery();
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}


	@Override
	public boolean deleteEType(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
