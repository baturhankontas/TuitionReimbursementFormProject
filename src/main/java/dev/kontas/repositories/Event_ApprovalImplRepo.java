package dev.kontas.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dev.kontas.models.Event_Approval;
import dev.kontas.util.JDBCConnection;

public class Event_ApprovalImplRepo implements Event_ApprovalRepo {

	public static Connection conn = JDBCConnection.getConnection();
	@Override
	public Event_Approval getApproval(int id) {
		// TODO Auto-generated method stub
		try {

			String sql = "SELECT * FROM event_approval WHERE event_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Event_Approval a = new Event_Approval();
				a.setEvent_id(rs.getInt("event_id"));
				a.setEmp_supervisor_app(rs.getString("emp_supervisor_app"));
				a.setDep_head_app(rs.getString("emp_department_head_app"));
				a.setEmp_benco_app(rs.getString("emp_benco_app"));
				a.setApproval_id(rs.getInt("approval_id"));
				
				
				return a;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}


	@Override
	public boolean addApproval(Event_Approval a) {
		// TODO Auto-generated method stub
		try {

			// Java is unaware of our actor_seq, so
			// its better or easier if we just use our Procedure
			// that abstracted away the use of the Sequence.
			String sql = "CALL add_event_app(?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, Integer.toString(a.getEvent_id()));
			cs.setString(2, a.getEmp_supervisor_app());
			cs.setString(3, a.getDep_head_app());
			cs.setString(4, a.getEmp_benco_app());
			

			cs.execute();
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}


	@Override
	public List<Event_Approval> getAllActors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateApproval(Event_Approval change) {
		// TODO Auto-generated method stub
		try {

			String sql = "UPDATE event_approval SET emp_supervisor_app=?, emp_department_head_app = ?, emp_benco_app=?, approval_id=?  WHERE event_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, change.getEmp_supervisor_app());
			ps.setString(2, change.getDep_head_app());
			ps.setString(3, change.getEmp_benco_app());
			ps.setString(4, Integer.toString(change.getApproval_id()));
			ps.setString(5, Integer.toString(change.getEvent_id()));
			
			ps.executeQuery();
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}


	@Override
	public boolean deleteApproval(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
