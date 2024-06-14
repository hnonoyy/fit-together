package model.vo;

import java.sql.Date;

public class Events {

	int id;
	String title;
	String description;
	String tag;
	int sportsCenterId;
	String hostId;
	Date openAt;
	int capacity;
	int attendee;
	Date registerAt;
	
//====================================
	public Events() {
		super();
	}

	public Events(int id, String title, String description, String tag, int sportsCenterId, String hostId, Date openAt,
			int capacity, int attendee, Date registerAt) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.tag = tag;
		this.sportsCenterId = sportsCenterId;
		this.hostId = hostId;
		this.openAt = openAt;
		this.capacity = capacity;
		this.attendee = attendee;
		this.registerAt = registerAt;
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

	public int getsportsCenterId() {
		return sportsCenterId;
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

	public Date getRegisterAt() {
		return registerAt;
	}

	
}
