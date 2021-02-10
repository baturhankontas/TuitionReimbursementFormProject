package dev.kontas.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dev.kontas.models.Additional_Info;
import dev.kontas.util.JDBCConnection;

public class Additional_InfoImplRepo implements Additional_InfoRepo {
	
	public static Connection conn = JDBCConnection.getConnection();
	@Override
	public Additional_Info getInfo(int id) {
		// TODO Auto-generated method stub
		try {

			String sql = "SELECT * FROM additional_info WHERE form_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Additional_Info a = new Additional_Info();
				a.setForm_id(rs.getInt("FORM_ID"));
				a.setAdd_info(rs.getString("ADD_INFO"));
				a.setCreater_id(rs.getInt("CREATER_ID"));
				a.setEmp_id(rs.getInt("EMP_ID"));
				
				return a;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}


	@Override
	public boolean addInfo(Additional_Info a) {
		// TODO Auto-generated method stub
		try {

			// Java is unaware of our actor_seq, so
			// its better or easier if we just use our Procedure
			// that abstracted away the use of the Sequence.
			String sql = "CALL add_additional_info(?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, Integer.toString(a.getForm_id()));
			cs.setString(2, a.getAdd_info());
			cs.setString(3, Integer.toString(a.getCreater_id()));
			cs.setString(4, Integer.toString(a.getEmp_id()));
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
	public List<Additional_Info> getAllInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateInfo(Additional_Info change) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteInfo(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
