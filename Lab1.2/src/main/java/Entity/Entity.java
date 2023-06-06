package Entity;

public class Entity {
	String title;
	int value;
	
	public Entity(String title, int value) {
		super();
		this.title = title;
		this.value = value;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "{\"title\":\""+title+"\", \"value\":"+ value+"}";
	}
	
	
}
