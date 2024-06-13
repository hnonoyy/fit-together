package model.vo;

public class Users {

	String id;
	String password;
	String name;
	String gender;
	int birth;
	String email;
	String interest;
	
//====================================
	public Users() {
		super();
	}

	public Users(String id, String password, String name, String gender, int birth, String email, String interest) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
		this.interest = interest;
	}

//====================================	
	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public int getBirth() {
		return birth;
	}

	public String getEmail() {
		return email;
	}

	public String getInterest() {
		return interest;
	}

	
	
}
