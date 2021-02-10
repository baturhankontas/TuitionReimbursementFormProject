package dev.kontas.models;

public class Event {
	
	private int event_id;
	private int event_emp_id;
	private String date;
	private String time;
	private String name;
	private String location;
	private int type_id;
	public Event() {
		super();
	}
	public Event(int event_emp_id, String date, String time, String name, String location) {
		super();
		this.event_emp_id = event_emp_id;
		this.date = date;
		this.time = time;
		this.name = name;
		this.location = location;
		this.type_id=type_id;
	}
	public Event(int event_id, int event_emp_id, String date, String time, String name, String location) {
		super();
		this.event_id = event_id;
		this.event_emp_id = event_emp_id;
		this.date = date;
		this.time = time;
		this.name = name;
		this.location = location;
		this.type_id=type_id;
	}
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public int getEvent_emp_id() {
		return event_emp_id;
	}
	public void setEvent_emp_id(int event_emp_id) {
		this.event_emp_id = event_emp_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	@Override
	public String toString() {
		return "Event [event_id=" + event_id + ", event_emp_id=" + event_emp_id + ", date=" + date + ", time=" + time
				+ ", name=" + name + ", location=" + location + ", type_id=" + type_id + "]";
	}
	
	
	
	
}
