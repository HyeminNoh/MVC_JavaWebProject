package dog.club.domain;

public class BoardContent {
	private int no;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	private String id;
	private String content;
	private String title;
	private String imagefile;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImagefile() {
		return imagefile;
	}
	public void setImagefile(String imagefile) {
		this.imagefile = imagefile;
	}
	
}
