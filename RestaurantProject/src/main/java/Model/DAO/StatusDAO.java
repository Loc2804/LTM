package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.BEAN.Status;

public class StatusDAO {
	
	public boolean checkStatusName(String name) {
		for(Status status : getAllStatus()) {
			if(status.getName().equals(name))
				return true;
		}
		return false;
	}
	
	public boolean checkExist(long id) {
		for(Status status : getAllStatus()) {
			if(status.getId() == id)
				return true;
		}
		return false;
	}
	
	public boolean createNewStatus(Status status) {
		if(checkStatusName(status.getName())) {
			return false;
		}
		try {
	        String url = "jdbc:mysql://localhost:3306/restaurant"; 
	        String user = "root";  
	        String password = ""; 
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection conn = DriverManager.getConnection(url, user, password);
	        Statement stmt = conn.createStatement();
	        String query = "Insert into status(name) values('"+status.getName()+"')";
	        int result = stmt.executeUpdate(query);
            if (result > 0) {
                return true;
            }
	    } catch (ClassNotFoundException e) {
	        System.out.println("Không tìm thấy MySQL JDBC Driver: " + e.getMessage());
	    } catch (SQLException e) {
	        System.out.println("Lỗi: " + e.getMessage());
	    }
		return false;
	}
	
	public List<Status> getAllStatus(){
		List<Status> list = new ArrayList<Status>();
		try {
	        String url = "jdbc:mysql://localhost:3306/restaurant"; 
	        String user = "root";  
	        String password = ""; 
	        Class.forName("com.mysql.jdbc.Driver");
	
	        Connection conn = DriverManager.getConnection(url, user, password);
	
	        Statement stmt = conn.createStatement();
	
	        String query = "SELECT * FROM status";
	        ResultSet rs = stmt.executeQuery(query);
	
	        while (rs.next()) {
	            Status status = new Status();
	            status.setId(rs.getLong("id"));
	            status.setName(rs.getString("name"));
	            list.add(status);
	        }
			
	        rs.close();
	        conn.close();
	    } catch (ClassNotFoundException e) {
	        System.out.println("Không tìm thấy MySQL JDBC Driver: " + e.getMessage());
	    } catch (SQLException e) {
	        System.out.println("Lỗi: " + e.getMessage());
	    }
		return list;
	}
	
	public Status getStatusById(long id){
		Status status = new Status();
		try {
	        String url = "jdbc:mysql://localhost:3306/restaurant"; 
	        String user = "root";  
	        String password = ""; 
	        Class.forName("com.mysql.jdbc.Driver");
	
	        Connection conn = DriverManager.getConnection(url, user, password);
	
	        Statement stmt = conn.createStatement();
	
	        String query = "SELECT * FROM status where id = '"+id+"'";
	        ResultSet rs = stmt.executeQuery(query);
	
	        while (rs.next()) {
	            status.setId(rs.getLong("id"));
	            status.setName(rs.getString("name"));
	        }
			
	        rs.close();
	        conn.close();
	    } catch (ClassNotFoundException e) {
	        System.out.println("Không tìm thấy MySQL JDBC Driver: " + e.getMessage());
	    } catch (SQLException e) {
	        System.out.println("Lỗi: " + e.getMessage());
	    }
		return status != null ? status : null;
	}
	
	public boolean deleteStatus(long id) {
		String query = "DELETE FROM status WHERE id = ?";
	    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "");
	         PreparedStatement pstmt = conn.prepareStatement(query)) {

	        pstmt.setLong(1, id);

	        int result = pstmt.executeUpdate();
	        return result > 0;
	    } catch (SQLException e) {
	        System.out.println("Lỗi: " + e.getMessage());
	    }
	    return false;
	}
	
	public boolean updateStatus(Status status) {
		String query = "UPDATE status SET name=? WHERE id = ?";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "");
		     PreparedStatement pstmt = conn.prepareStatement(query)) {
		    pstmt.setString(1, status.getName());
		    pstmt.setLong(2, status.getId());
		   
		    int result = pstmt.executeUpdate();
		    return result > 0;
		} catch (SQLException e) {
		    System.out.println("Lỗi: " + e.getMessage());
		}
		return false;
	}

}
