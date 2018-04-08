package backend.entity;

import org.springframework.data.annotation.Id;


public class Skills {
	
	@Id 
	private String id ;
	private String name; 
	private int level ;
	public Skills() {
		super();
	}
	public Skills(String id, String name, int level) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	} 
	
	
	
	

}
