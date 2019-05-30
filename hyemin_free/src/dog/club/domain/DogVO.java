package dog.club.domain;

public class DogVO {
	private String username;
	private String id;
	private String password;
	private String dogname;
	private int dogage;
	private String dogsex;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDogname() {
		return dogname;
	}
	public void setDogname(String dogname) {
		this.dogname = dogname;
	}
	public int getDogage() {
		return dogage;
	}
	public void setDogage(int dogage) {
		this.dogage = dogage;
	}
	public String getDogsex() {
		return dogsex;
	}
	public void setDogsex(String dogsex) {
		this.dogsex = dogsex;
	}
	public String getDogtype() {
		return dogtype;
	}
	public void setDogtype(String dogtype) {
		this.dogtype = dogtype;
	}
	private String dogtype;
}
