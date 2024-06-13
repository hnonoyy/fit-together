package model.vo;

public class SportsCenter {

	int id;
	String type;
	String name;
	String owner;
	String management;
	
//==================================================	
	public SportsCenter() {
		super();
	}

	public SportsCenter(int id, String type, String name, String owner, String management) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.owner = owner;
		this.management = management;
	}
//==================================================

	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getOwner() {
		return owner;
	}

	public String getManagement() {
		return management;
	}
	
}
