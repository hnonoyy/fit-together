package model.vo.complex;

import model.vo.Participants;
import model.vo.Users;

public class ParticipantWithUsersDetail {

	Participants participants;
	Users users;

	public ParticipantWithUsersDetail() {
		super();
	}

	public ParticipantWithUsersDetail(Participants participants, Users users) {
		super();
		this.participants = participants;
		this.users = users;
	}

	public Participants getParticipants() {
		return participants;
	}

	public void setParticipants(Participants participants) {
		this.participants = participants;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
