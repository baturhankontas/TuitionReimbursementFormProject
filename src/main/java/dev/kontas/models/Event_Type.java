package dev.kontas.models;

public class Event_Type {

	private int event_id;
	private int event_coverage;
	private String name;
	public Event_Type() {
		super();
	}
	public Event_Type(int event_coverage, String name) {
		super();
		this.event_coverage = event_coverage;
		this.name = name;
	}
	public Event_Type(int event_id, int event_coverage, String name) {
		super();
		this.event_id = event_id;
		this.event_coverage = event_coverage;
		this.name = name;
	}
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public int getEvent_coverage() {
		return event_coverage;
	}
	public void setEvent_coverage(int event_coverage) {
		this.event_coverage = event_coverage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Event_Type [event_id=" + event_id + ", event_coverage=" + event_coverage + ", name=" + name + "]";
	}
	
	
}
