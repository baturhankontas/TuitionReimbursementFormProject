package dev.kontas.models;

public class Event_Grade {
	private int event_id;
	private String event_grade;
	
	public Event_Grade() {
		super();
	}

	public Event_Grade(String event_grade) {
		super();
		this.event_grade = event_grade;
	}

	public Event_Grade(int event_id, String event_grade) {
		super();
		this.event_id = event_id;
		this.event_grade = event_grade;
	}

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public String getEvent_grade() {
		return event_grade;
	}

	public void setEvent_grade(String event_grade) {
		this.event_grade = event_grade;
	}

	@Override
	public String toString() {
		return "Event_Grade [event_id=" + event_id + ", event_grade=" + event_grade + "]";
	}
	
	
	
}
