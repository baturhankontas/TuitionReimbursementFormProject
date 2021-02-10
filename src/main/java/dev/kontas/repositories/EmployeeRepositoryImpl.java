package dev.kontas.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.kontas.models.Employee;
import dev.kontas.util.JDBCConnection;

public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		try {

			String sql = "SELECT * FROM employee WHERE emp_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Employee e = new Employee();
				e.setId(rs.getInt("EMP_ID"));
				e.setName(rs.getString("EMP_NAME"));
				e.setSurname(rs.getString("EMP_SURNAME"));
				e.setEmail(rs.getString("EMP_EMAIL"));
				e.setDepartment_id(rs.getInt("emp_department_id"));
				e.setSupervisor_id(rs.getInt("emp_supervisor_id"));
				e.setBenco(rs.getString("emp_benco"));
				
				 

				return e;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}


	@Override
	public boolean addEmployee(Employee a) {
		// TODO Auto-generated method stub
		try {

			// Java is unaware of our actor_seq, so
			// its better or easier if we just use our Procedure
			// that abstracted away the use of the Sequence.
			String sql = "CALL add_actor(?,?,?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, a.getName());
			cs.setString(2, a.getSurname());
			cs.setString(3,a.getEmail());
			cs.setInt(4, a.getDepartment_id());
			cs.setInt(5, a.getSupervisor_id());
			cs.setString(6, a.getBenco());

			cs.execute();
			 
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		List<Employee> actors = new ArrayList<Employee>();

		try {

			String sql = "SELECT * FROM employee";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Employee e = new Employee();
				e.setId(rs.getInt("EMP_ID"));
				e.setName(rs.getString("EMP_NAME"));
				e.setSurname(rs.getString("EMP_SURNAME"));
				e.setEmail(rs.getString("EMP_EMAIL"));
				e.setDepartment_id(rs.getInt("emp_department_id"));
				e.setSupervisor_id(rs.getInt("emp_supervisor_id"));
				e.setBenco(rs.getString("emp_benco"));

				actors.add(e);

	
				 
			}
		
			return actors;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean updateEmployee(Employee change) {
		// TODO Auto-generated method stub
		try {

			String sql = "UPDATE employee SET emp_name = ?, emp_surname=?, emp_email=?,emp_department_id=?,emp_supervisor_id=?, emp_benco= ? WHERE emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(change.getId()));
			ps.setString(2, change.getName());
			ps.setString(3, change.getSurname());
			ps.setString(4, change.getEmail());
			ps.setString(5, Integer.toString(change.getDepartment_id()));
			ps.setString(6, Integer.toString(change.getSupervisor_id()));
			ps.setString(7, change.getBenco());

			ps.executeQuery();
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}


	@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		

		return false;
	}

}
