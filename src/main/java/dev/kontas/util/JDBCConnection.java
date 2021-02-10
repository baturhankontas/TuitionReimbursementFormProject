package dev.kontas.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCConnection {

	private static Connection conn = null;

	public static Connection getConnection() {
		try {
			if (conn == null) {
				// make a new connection
				/*
				 * Oracle added a *hotfix* to ensure that ojdbc drives would correctly load at
				 * the beginning of you app starting.
				 */
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Properties props = new Properties();
				FileInputStream input = new FileInputStream(
						JDBCConnection.class.getClassLoader().getResource("connection.properties").getFile());
				props.load(input);

				String url = props.getProperty("url");
				String username = props.getProperty("username");
				String password = props.getProperty("password");
				/*
				 * Class.forName("oracle.jdbc.driver.OracleDriver");
				 * 
				 * String url=
				 * "jdbc:oracle:thin:@kontas2101etl.cbzkbupjh0xq.us-east-1.rds.amazonaws.com:1521:ORCL";
				 * String username="alikontas"; String password="5326864Bk.";
				 */

				conn = DriverManager.getConnection(url, username, password);

				return conn;
			} else {
				// return the connection that already exists.

			}
			return conn;
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
