package boutique.model;

public class Photo {
	private int id;
	private float size; 
	private String url;
	
	public Photo() { }
	
	public Photo(float size, String url) {
		this.size = size;
		this.url = url;
	}

	public float getSize() {
		return size;
	}
	
	public void setSize(float size) {
		this.size = size;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
