package dog.club.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dog.club.domain.ChatContent;

public class ChatConDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost:3306/jspdb?useSSL=false&serverTimezone=UTC";
	
	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "jspbook","passwd");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void disconnect() {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean add(ChatContent cont) {
		connect();
		String sql="insert into chatcont values (?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, cont.getId());
			pstmt.setString(2, cont.getDate());
			pstmt.setString(3, cont.getContent());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
		return true;
	}
	
	public ArrayList<ChatContent> getContentList(){
		connect();
		ArrayList<ChatContent> contlist = new ArrayList<ChatContent>();
		String sql="select * from chatCont";
		try {
			pstmt=conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ChatContent cont=new ChatContent();
				cont.setId(rs.getString("id"));
				cont.setDate(rs.getString("date"));
				cont.setContent(rs.getString("content"));
				contlist.add(cont);
			}
			rs.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		disconnect();
	}
	return contlist;
	}
}
