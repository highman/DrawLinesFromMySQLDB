package org.ossystem.it;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PointDAOImpl implements PointDAO {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/MySQLDB" 
								   	+ "?user=root&password=kostya&createDatabaseIfNotExist=true";	
	   
	private static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS Points(" +
															"ID INT NOT NULL AUTO_INCREMENT, " +
															"NAME varchar(32)," +
															"XX INT NOT NULL," +
															"YY INT NOT NULL," +
															"primary key (ID));";

	private static final String INSERT_QUERY = "insert into Points(id, name, XX, YY) values(default, ?, ?,?)";

	private static final String UPDATE_QUERY = "update Points set name=?, XX=?, YY=? where id=?";

	private static final String DELETE_QUERY = "delete from Points where id=?";

	private static final String SELECT_ALL_QUERY = "select * from Points";
	
	private static final String SELECT_BY_ID_QUERY = "select * from Points where id=?";
	
	private PointDAOImpl() {			
		try {
			Class.forName(JDBC_DRIVER);			
			try(Connection connection = getConnection()) {								
				executeStatement(connection,CREATE_TABLE_QUERY);				
			} 
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println("Database error:" + ex.getMessage());
		}
	}
	
	private static class Handler {
		private static PointDAOImpl instance = new PointDAOImpl();
	}
	
	public static PointDAOImpl getInstance() {		
		return Handler.instance;
	}	
	
	private Connection getConnection() {
		Connection conn = null;		
		try {			
			conn = DriverManager.getConnection(JDBC_URL);			
		} catch (SQLException sqle) {
			throw new RuntimeException("Error in getting a DB connection.",	sqle);
		}
		return conn;
	}
	
	private void executeStatement(Connection connection, String sql, Object... parameters) {		
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			for (int i = 0; i < parameters.length; i++) {
				statement.setObject(i + 1, parameters[i]);
			}
			statement.executeUpdate();
		} catch (Exception ex) {
			throw new RuntimeException("Database error:" + ex.getMessage(), ex);
		}
	}

	
	@Override
	public void addPoint(Point p) {
		try(Connection connection = getConnection()) {
			executeStatement(connection,INSERT_QUERY, p.getName(), p.getXX(), p.getYY());						
		} catch (Exception ex) {
			System.out.println("Database error:" + ex.getMessage());
		}		
	}

	@Override
	public void editPoint(Point p) {
		try(Connection connection = getConnection()) {
			executeStatement(connection, UPDATE_QUERY, p.getName(), p.getXX(), p.getYY(), p.getId());
		} catch (Exception ex) {
			System.out.println("Database error:" + ex.getMessage());
		}			
	}

	@Override
	public void deletePoint(int id) {
		try(Connection connection = getConnection()) {
			executeStatement(connection, DELETE_QUERY, id);
		} catch (Exception ex) {
			System.out.println("Database error:" + ex.getMessage());
		}					
	}
	
	@Override
	public Point getByID(int id) {
		Point point = null;
		try(Connection connection = getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
				statement.setInt(1, id);
				try (ResultSet resultSet = statement.executeQuery()) {
					if(resultSet.next()) {
						point = new Point();
						point.setId(resultSet.getInt("ID"));
						point.setName(resultSet.getString("NAME"));
						point.setXX(resultSet.getInt("XX"));
						point.setYY(resultSet.getInt("YY"));
					}
				}				
			}
			
		} catch (Exception ex) {
			System.out.println("Database error:" + ex.getMessage());
		}
		return point;			
	}

	@Override
	public ArrayList<Point> getAllPoints() {
		ArrayList<Point> list = new ArrayList<>(); 
		try(Connection connection = getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {				
				try (ResultSet resultSet = statement.executeQuery()) {
					while(resultSet.next()) {
						Point point = new Point();						
						point.setId(resultSet.getInt("ID"));
						point.setName(resultSet.getString("NAME"));
						point.setXX(resultSet.getInt("XX"));
						point.setYY(resultSet.getInt("YY"));
						list.add(point);
					}
				}				
			}
			
		} catch (Exception ex) {
			System.out.println("Database error:" + ex.getMessage());
		}
		return list;
	}
}
