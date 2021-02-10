package dev.kontas.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dev.kontas.models.Department;
import dev.kontas.util.JDBCConnection;

public class DepartmentRepositoryImpl implements DepartmentRepository{

	public static Connection conn = JDBCConnection.getConnection();
	@Override
	public Department getDepartment(int id) {
		// TODO Auto-generated method stub
		try {

			String sql = "SELECT * FROM department WHERE department_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Department d = new Department();
				d.setDep_id(rs.getInt("DEPARTMENT_ID"));
				d.setDep_name(rs.getString("DEPARTMENT_NAME"));
				d.setHead_id(rs.getInt("DEPARTMENT_HEAD_ID"));
				 
				return d;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}


	@Override
	public boolean addDepartment(Department a) {
		// TODO Auto-generated method stub
		try {

			// Java is unaware of our actor_seq, so
			// its better or easier if we just use our Procedure
			// that abstracted away the use of the Sequence.
			String sql = "CALL add_department(?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, a.getDep_name());
			cs.setString(2, Integer.toString(a.getHead_id()));
			

			cs.execute();
			 
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}



	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateDepartment(Department change) {
		// TODO Auto-generated method stub
		try {

			String sql = "UPDATE department SET department_name= ?, department_head_id= ? WHERE department_id= ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, change.getDep_name());
			ps.setString(2, Integer.toString(change.getHead_id()));
			ps.setString(3, Integer.toString(change.getDep_id()));

			ps.executeQuery();
			 
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}


	@Override
	public boolean deleteDepartment(int id) {
		// TODO Auto-generated method stub
		try {

			String sql = "DELETE department WHERE department_id = ?";
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

