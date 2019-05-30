package dog.club.domain;

public class TipContent {
	private String image;
	private String url;
	private String content;
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public TipContent(String image,String url,String content) {
		this.image = image;
		this.url=url;
		this.content=content;
	}
	
	public TipContent() {
		image="디폴트";
		url="연결링크";
		content="내용";
	}
}
