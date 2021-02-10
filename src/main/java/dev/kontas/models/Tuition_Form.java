package dev.kontas.models;

public class Tuition_Form {
	
	private int form_id;
	private String date;
	private String description;
	private int amount;
	private String notes;
	private String status;
	private int event_id;
	private int emp_id;
	private int emp_time_off;
	public Tuition_Form() {
		super();
	}
	public Tuition_Form(String date, String description, int amount, String notes, String status, int event_id,
			int emp_id, int emp_time_off) {
		super();
		this.date = date;
		this.description = description;
		this.amount = amount;
		this.notes = notes;
		this.status = status;
		this.event_id = event_id;
		this.emp_id = emp_id;
		this.emp_time_off = emp_time_off;
	}
	public Tuition_Form(int form_id, String date, String description, int amount, String notes, String status,
			int event_id, int emp_id, int emp_time_off) {
		super();
		this.form_id = form_id;
		this.date = date;
		this.description = description;
		this.amount = amount;
		this.notes = notes;
		this.status = status;
		this.event_id = event_id;
		this.emp_id = emp_id;
		this.emp_time_off = emp_time_off;
	}
	public int getForm_id() {
		return form_id;
	}
	public void setForm_id(int form_id) {
		this.form_id = form_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getEmp_time_off() {
		return emp_time_off;
	}
	public void setEmp_time_off(int emp_time_off) {
		this.emp_time_off = emp_time_off;
	}
	@Override
	public String toString() {
		return "Tuition_Form [form_id=" + form_id + ", date=" + date + ", description=" + description + ", amount="
				+ amount + ", notes=" + notes + ", status=" + status + ", event_id=" + event_id + ", emp_id=" + emp_id
				+ ", emp_time_off=" + emp_time_off + "]";
	}
	
	
	
	
}
