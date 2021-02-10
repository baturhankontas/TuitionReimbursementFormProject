package dev.kontas.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.kontas.models.Tuition_Form;
import dev.kontas.util.JDBCConnection;

public class Tuition_FormImplRepo implements Tuition_FormRepo {
	
	public static Connection conn = JDBCConnection.getConnection();
	@Override
	public Tuition_Form getForm(int id) {
		// TODO Auto-generated method stub
		try {

			String sql = "SELECT * FROM tuition_form WHERE form_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Tuition_Form t = new Tuition_Form();
				t.setForm_id(rs.getInt("FORM_ID"));
				t.setDate(rs.getString("FORM_DATE"));
				t.setDescription(rs.getString("FORM_DESC"));
				t.setAmount(rs.getInt("FORM_AMOUNT"));
				t.setNotes(rs.getString("FORM_NOTES"));
				t.setStatus(rs.getString("FORM_STATUS"));
				t.setEvent_id(rs.getInt("EVENT_ID"));
				t.setEmp_id(rs.getInt("EMP_ID"));
				t.setEmp_time_off(rs.getInt("EMP_TIME_OFF"));
				
				return t;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}



	@Override
	public Tuition_Form getForm(String name) {
		// TODO Auto-generated method stub
		

		return null;

	}


	@Override
	public List<Tuition_Form> getAllForm(){
		// TODO Auto-generated method stub
		List<Tuition_Form> forms= new ArrayList<Tuition_Form>();

		try {

			String sql = "SELECT * FROM tuition_form";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Tuition_Form t = new Tuition_Form();
				t.setForm_id(rs.getInt("FORM_ID"));
				t.setDate(rs.getString("FORM_DATE"));
				t.setDescription(rs.getString("FORM_DESC"));
				t.setAmount(rs.getInt("FORM_AMOUNT"));
				t.setNotes(rs.getString("FORM_NOTES"));
				t.setStatus(rs.getString("FORM_STATUS"));
				t.setEvent_id(rs.getInt("EVENT_ID"));
				t.setEmp_id(rs.getInt("EMP_ID"));
				t.setEmp_time_off(rs.getInt("EMP_TIME_OFF"));

				forms.add(t);

				// Optionally could condense to 1 line of code.
//				actors.add(new Actor(rs.getInt("ID"), rs.getString("NAME"), rs.getInt("WORTH")));

			}
			
			return forms;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public boolean addForm(Tuition_Form a){
		// TODO Auto-generated method stub
		try {

			// Java is unaware of our actor_seq, so
			// its better or easier if we just use our Procedure
			// that abstracted away the use of the Sequence.
			String sql = "CALL add_tuition_form(?,?,?,?,?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, a.getDate());
			cs.setString(2, a.getDescription());
			cs.setString(3, Integer.toString(a.getAmount()));
			cs.setString(4, a.getNotes());
			cs.setString(5, a.getStatus());
			cs.setString(6, Integer.toString(a.getEvent_id()));
			cs.setString(7, Integer.toString(a.getEmp_id()));
			cs.setString(8, Integer.toString(a.getEmp_time_off()));
			

			cs.execute();
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}



	@Override
	public boolean updateForm(Tuition_Form change){
		// TODO Auto-generated method stub
		try {

			String sql = "UPDATE tuition_form SET form_date=?,form_desc=?,form_amount=?,form_notes=?,form_status=?,event_id=?,emp_id=?,emp_time_off=? WHERE form_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			/*ps.setString(1,Integer.toString(change.getForm_id()));
			ps.setString(2, change.getDate());
			ps.setString(3, change.getDescription());
			ps.setString(4, Integer.toString(change.getAmount()));
			ps.setString(5, change.getNotes());
			ps.setString(6, change.getStatus());
			ps.setString(7, Integer.toString(change.getEvent_id()));
			ps.setString(8, Integer.toString(change.getEmp_id()));
			ps.setString(9, Integer.toString(change.getEmp_time_off()));
			*/
			
			ps.setString(1, change.getDate());
			ps.setString(2, change.getDescription());
			ps.setString(3, Integer.toString(change.getAmount()));
			ps.setString(4, change.getNotes());
			ps.setString(5, change.getStatus());
			ps.setString(6, Integer.toString(change.getEvent_id()));
			ps.setString(7, Integer.toString(change.getEmp_id()));
			ps.setString(8, Integer.toString(change.getEmp_time_off()));
			ps.setString(9,Integer.toString(change.getForm_id()));

			ps.executeQuery();
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}


	@Override
	public boolean deleteForm(int id){
		// TODO Auto-generated method stub
	

		return false;
	}



	@Override
	public Tuition_Form getFormByEvent(int id) {
		// TODO Auto-generated method stub
		try {

			String sql = "SELECT * FROM tuition_form WHERE event_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Tuition_Form t = new Tuition_Form();
				t.setForm_id(rs.getInt("FORM_ID"));
				t.setDate(rs.getString("FORM_DATE"));
				t.setDescription(rs.getString("FORM_DESC"));
				t.setAmount(rs.getInt("FORM_AMOUNT"));
				t.setNotes(rs.getString("FORM_NOTES"));
				t.setStatus(rs.getString("FORM_STATUS"));
				t.setEvent_id(rs.getInt("EVENT_ID"));
				t.setEmp_id(rs.getInt("EMP_ID"));
				t.setEmp_time_off(rs.getInt("EMP_TIME_OFF"));
				
				return t;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
