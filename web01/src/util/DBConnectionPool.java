package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

// JDBC URL, Driver, ID, PWD를 외부에서 주입 
public class DBConnectionPool {
	String url;
	String driver;
	String username;
	String password;
	
	ArrayList<Connection> list = new ArrayList<Connection>();
	
	public void setUrl(String url) {
		this.url = url;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getConnection() throws Exception {
		if (list.size() > 0) {
			return list.remove(0);
		} else {
			Class.forName(driver);
			return DriverManager.getConnection(url, username, password);
		}
	}
	
	public void returnConnection(Connection con) {
		try {
			if (!con.isClosed()) {
				list.add(con);
			}
		} catch (Exception e) {}
	}
	
	public void closeAll() {
		for (Connection con : list) {
			try {con.close();} catch (Exception e) {}
		}
	}

}












