package dog.club.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dog.club.domain.BoardContent;
import dog.club.domain.Notice;

public class NoticeDAO {
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
	
	public boolean add(Notice cont) {
		connect();
		String sql="insert into noticecont(id,title,content,date)values(?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, cont.getId());
			pstmt.setString(2, cont.getTitle());
			pstmt.setString(3, cont.getContent());
			pstmt.setString(4, cont.getDate());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
		return true;
	}
	
	public ArrayList<Notice> getContentList(){
		connect();
		ArrayList<Notice> contlist = new ArrayList<Notice>();
		String sql="select * from noticecont";
		try {
			pstmt=conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Notice cont=new Notice();
				cont.setNo(rs.getInt("index_no"));
				cont.setId(rs.getString("id"));
				cont.setTitle(rs.getString("title"));
				cont.setContent(rs.getString("content"));
				cont.setDate(rs.getString("date"));
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
	public Notice checkContent(String no) {
		int index_no = Integer.parseInt(no);
		Notice resultcont = new Notice();
		connect();
		String sql="select * from noticecont where index_no=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, index_no);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				resultcont.setNo(rs.getInt("index_no"));
				resultcont.setId(rs.getString("id"));
				resultcont.setTitle(rs.getString("title"));
				resultcont.setContent(rs.getString("content"));
				resultcont.setDate(rs.getString("date"));
			}
			rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return resultcont;
	}
}
