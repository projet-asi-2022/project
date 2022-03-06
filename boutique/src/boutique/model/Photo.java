package boutique.model;

public class Photo {
	private float size; 
	private String url;
	
	public Photo(float size, String url) {
		this.size = size;
		this.url = url;
	}
	public Photo() {
	
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
}
