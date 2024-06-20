package model.vo.complex;

import model.vo.Events;
import model.vo.SportsCenter;

public class EventsWithDetail {
	Events event;
	SportsCenter sportsCenter;
	boolean isJoined;
	double dday;

	public Events getEvent() {
		return event;
	}

	public void setEvent(Events event) {
		this.event = event;
	}

	public SportsCenter getSportsCenter() {
		return sportsCenter;
	}

	public void setSportsCenter(SportsCenter sportsCenter) {
		this.sportsCenter = sportsCenter;
	}

	public boolean isJoined() {
		return isJoined;
	}

	public void setJoined(boolean isJoined) {
		this.isJoined = isJoined;
	}

	public double getDday() {
		return dday;
	}

	public void setDday(double dday) {
		this.dday = dday;
	}
}
