package dog.club.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dog.club.domain.DogVO;

public class DogDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost:3306/jspdb?useSSL=false&serverTimezone=UTC";
	
	public void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "jspbook","passwd");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
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
	
	public boolean add(DogVO dog) {
		connect();
		String sql="insert into dogclient values (?,?,?,?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dog.getUsername());
			pstmt.setString(2, dog.getId());
			pstmt.setString(3, dog.getPassword());
			pstmt.setString(4, dog.getDogname());
			pstmt.setInt(5, dog.getDogage());
			pstmt.setString(6, dog.getDogsex());
			pstmt.setString(7, dog.getDogtype());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
		return true;
	}
	
	public boolean update(DogVO previous, DogVO update) {
		connect();
		String sql="update dogclient set username=?,id=?,password=?,dogname=?,dogage=?,dogsex=?,dogtype=? where id=? and password=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, update.getUsername());
			pstmt.setString(2, update.getId());
			pstmt.setString(3, update.getPassword());
			pstmt.setString(4, update.getDogname());
			pstmt.setInt(5, update.getDogage());
			pstmt.setString(6, update.getDogsex());
			pstmt.setString(7, update.getDogtype());
			pstmt.setString(8, previous.getId());
			pstmt.setString(9, previous.getPassword());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
		return true;
	}
	
	public boolean delete(DogVO dog) {
		connect();
		String sql="delete from dogclient where id=? and password=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dog.getId());
			pstmt.setString(2, dog.getPassword());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
		return true;
	}
	
	public ArrayList<DogVO> getClientList(){
		connect();
		ArrayList<DogVO> clientlist = new ArrayList<DogVO>();
		String sql="select * from dogclient";
		try {
			pstmt=conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				DogVO dog=new DogVO();
				dog.setUsername(rs.getString("username"));
				dog.setId(rs.getString("id"));
				dog.setPassword(rs.getString("password"));
				dog.setDogname(rs.getString("dogname"));
				dog.setDogage(Integer.parseInt(rs.getString("dogage")));
				dog.setDogsex(rs.getString("dogsex"));
				dog.setDogtype(rs.getString("dogtype"));
				clientlist.add(dog);
			}
			rs.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		disconnect();
	}
	return clientlist;
	}
	
	//로그인 아이디, 비밀번호 체크 메서드
	public int loginCheck(String id, String pw) {
		connect();
		String sql="select password from dogclient where id=?";
		
		String dbpw="";		//db에서 꺼낸 비밀번호
		int check=-1;
		 
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbpw=rs.getString("password");
				
				if(dbpw.equals(pw)) {
					check=1; //성공
				}
				else {
					check=0; //비밀번호 다름
				}
			}else {
				check=-1;  //아이디가 없음
			}
			return check;
		}catch(Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		}finally {
			try {
					if(pstmt!=null) {
						pstmt.close();
						pstmt=null;
					}
					if(conn!=null) {
						conn.close();
						conn=null;
					}
				}catch(Exception e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		}
	
		//로그인에 성공한 회원 정보 조회
		public DogVO loginClient(String id, String pw){
			connect();
			DogVO loginclient=new DogVO();
			String sql="select * from dogclient where id=?";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, id);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					loginclient.setUsername(rs.getString("username"));
					loginclient.setId(rs.getString("id"));
					loginclient.setPassword(rs.getString("password"));
					loginclient.setDogname(rs.getString("dogname"));
					loginclient.setDogage(Integer.parseInt(rs.getString("dogage")));
					loginclient.setDogsex(rs.getString("dogsex"));
					loginclient.setDogtype(rs.getString("dogtype"));
				}
				rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
			return loginclient;
		}
}
