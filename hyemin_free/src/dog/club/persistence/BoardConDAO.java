package dog.club.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dog.club.domain.BoardContent;
import dog.club.domain.DogVO;

public class BoardConDAO {
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
	
	public boolean add(BoardContent cont) {
		connect();
		String sql="insert into boardcont(id,title,content,imagefile)values(?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, cont.getId());
			pstmt.setString(2, cont.getTitle());
			pstmt.setString(3, cont.getContent());
			pstmt.setString(4, cont.getImagefile());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
		return true;
	}
	
	public boolean delete(String no) {
		connect();
		String sql="delete from boardcont where index_no=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(no));
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
		return true;
	}
	
	public boolean update(BoardContent update) {
		connect();
		String sql="update boardcont set id=?,title=?,content=?,imagefile=? where index_no=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, update.getId());
			pstmt.setString(2, update.getTitle());
			pstmt.setString(3, update.getContent());
			pstmt.setString(4, update.getImagefile());
			pstmt.setInt(5, update.getNo());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
		return true;
	}
	
	public BoardContent checkboard(String no) {
		int index_no = Integer.parseInt(no);
		BoardContent resultcont = new BoardContent();
		connect();
		String sql="select * from boardcont where index_no=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, index_no);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				resultcont.setNo(rs.getInt("index_no"));
				resultcont.setId(rs.getString("id"));
				resultcont.setTitle(rs.getString("title"));
				resultcont.setContent(rs.getString("content"));
				resultcont.setImagefile(rs.getString("imagefile"));
			}
			rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return resultcont;
	}
	
	public ArrayList<BoardContent> getContentList(){
		connect();
		ArrayList<BoardContent> contlist = new ArrayList<BoardContent>();
		String sql="select * from boardcont";
		try {
			pstmt=conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardContent cont=new BoardContent();
				cont.setNo(rs.getInt("index_no"));
				cont.setId(rs.getString("id"));
				cont.setTitle(rs.getString("title"));
				cont.setContent(rs.getString("content"));
				cont.setImagefile(rs.getString("imagefile"));
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
