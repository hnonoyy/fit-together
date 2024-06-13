package model.vo;

import java.sql.Date;

public class Events {

	int id;
	String title;
	String description;
	String tag;
	int gymId;
	String hostId;
	Date openAt;
	int capacity;
	int attendee;
	Date register_at;
	
//====================================
	public Events() {
		super();
	}

	public Events(int id, String title, String description, String tag, int gymId, String hostId, Date openAt,
			int capacity, int attendee, Date register_at) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.tag = tag;
		this.gymId = gymId;
		this.hostId = hostId;
		this.openAt = openAt;
		this.capacity = capacity;
		this.attendee = attendee;
		this.register_at = register_at;
	}

//====================================
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getTag() {
		return tag;
	}

	public int getGymId() {
		return gymId;
	}

	public String getHostId() {
		return hostId;
	}

	public Date getOpenAt() {
		return openAt;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getAttendee() {
		return attendee;
	}

	public Date getRegister_at() {
		return register_at;
	}

	
}
