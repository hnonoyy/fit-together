package model.vo;

public class SportsCenter {

	int id;
	String type;
	String name;
	String district;
	String owner;
	String management;

	public SportsCenter() {
		super();
	}

	public SportsCenter(int id, String type, String name, String district, String owner, String management) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.district = district;
		this.owner = owner;
		this.management = management;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getManagement() {
		return management;
	}

	public void setManagement(String management) {
		this.management = management;
	}

//==================================================	

}