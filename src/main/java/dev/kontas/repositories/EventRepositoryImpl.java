package dev.kontas.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.kontas.models.Event;
import dev.kontas.util.JDBCConnection;

public class EventRepositoryImpl implements EventRepository {

	public static Connection conn = JDBCConnection.getConnection();
	@Override
	public Event getEvent(int id){
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT * FROM event WHERE event_emp_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Event e = new Event();
				e.setEvent_id(rs.getInt("EVENT_ID"));
				e.setEvent_emp_id(rs.getInt("EVENT_EMP_ID"));
				e.setDate(rs.getString("EVENT_DATE"));
				e.setTime(rs.getString("EVENT_TIME"));
				e.setName(rs.getString("EVENT_NAME"));
				e.setLocation(rs.getString("EVENT_LOCATION"));
				e.setType_id(rs.getInt("EVENT_TYPE_ID"));
				
				return e;
//				return new Actor(rs.getInt("ID"), rs.getString("NAME"), rs.getInt("WORTH"));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public Event getEventbyReal(int id){
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT * FROM event WHERE event_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Event e = new Event();
				e.setEvent_id(rs.getInt("EVENT_ID"));
				e.setEvent_emp_id(rs.getInt("EVENT_EMP_ID"));
				e.setDate(rs.getString("EVENT_DATE"));
				e.setTime(rs.getString("EVENT_TIME"));
				e.setName(rs.getString("EVENT_NAME"));
				e.setLocation(rs.getString("EVENT_LOCATION"));
				e.setType_id(rs.getInt("EVENT_TYPE_ID"));
				
				return e;
//				return new Actor(rs.getInt("ID"), rs.getString("NAME"), rs.getInt("WORTH"));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public boolean addEvent(Event a){
		// TODO Auto-generated method stub
		try {

			String sql = "CALL add_event(?,?,?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, Integer.toString(a.getEvent_emp_id()));
			cs.setString(2, a.getDate());
			cs.setString(3, a.getTime());
			cs.setString(4, a.getName());
			cs.setString(5, a.getLocation());
			cs.setString(6, Integer.toString(a.getType_id()));

			cs.execute();
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}



	@Override
	public List<Event> getAllEvent() {
		// TODO Auto-generated method stub
		List<Event> events= new ArrayList<Event>();

		try {

			String sql = "SELECT * FROM Event";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Event e = new Event();
				e.setEvent_id(rs.getInt("EVENT_ID"));
				e.setEvent_emp_id(rs.getInt("EVENT_EMP_ID"));
				e.setDate(rs.getString("EVENT_DATE"));
				e.setTime(rs.getString("EVENT_TIME"));
				e.setName(rs.getString("EVENT_NAME"));
				e.setLocation(rs.getString("EVENT_LOCATION"));
				e.setType_id(rs.getInt("EVENT_TYPE_ID"));

				events.add(e);

				// Optionally could condense to 1 line of code.
//				actors.add(new Actor(rs.getInt("ID"), rs.getString("NAME"), rs.getInt("WORTH")));

			}
			
			return events;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public boolean updateEvent(Event change){
		// TODO Auto-generated method stub
		try {

			String sql = "UPDATE event SET event_emp_id=?, event_date=?, event_time=?, event_name=?, event_location=?, event_type_id=? WHERE event_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			
			ps.setString(1, Integer.toString(change.getEvent_id()));
			ps.setString(2, Integer.toString(change.getEvent_emp_id()));
			ps.setString(3, change.getDate());
			ps.setString(4, change.getTime());
			ps.setString(5, change.getName());
			ps.setString(6, change.getLocation());
			ps.setString(7, Integer.toString(change.getType_id()));

			ps.executeQuery();
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}


	@Override
	public boolean deleteEvent(int id) {
		// TODO Auto-generated method stub
		try {

			String sql = "DELETE event WHERE event_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeQuery();
			
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}

