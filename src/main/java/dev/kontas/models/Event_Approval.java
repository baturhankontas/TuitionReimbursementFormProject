package dev.kontas.models;

public class Event_Approval {
	
	private int event_id;
	private String emp_supervisor_app;
	private String dep_head_app;
	private String emp_benco_app;
	private int approval_id;
	public Event_Approval() {
		super();
	}
	public Event_Approval(String emp_supervisor_app, String dep_head_app, String emp_benco_app) {
		super();
		this.emp_supervisor_app =emp_supervisor_app ;
		this.dep_head_app = dep_head_app;
		this.emp_benco_app =emp_benco_app ;
		this.approval_id=approval_id;
	}
	public Event_Approval(int event_id, String emp_supervisor_app, String dep_head_app, String emp_benco_app) {
		super();
		this.event_id = event_id;
		this.emp_supervisor_app =emp_supervisor_app ;
		this.dep_head_app = dep_head_app;
		this.emp_benco_app =emp_benco_app ;
		this.approval_id=approval_id;
	}
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public String getEmp_supervisor_app() {
		return emp_supervisor_app;
	}
	public void setEmp_supervisor_app(String emp_supervisor_app) {
		this.emp_supervisor_app = emp_supervisor_app;
	}
	public String getDep_head_app() {
		return dep_head_app;
	}
	public void setDep_head_app(String dep_head_app) {
		this.dep_head_app = dep_head_app;
	}
	public String getEmp_benco_app() {
		return emp_benco_app;
	}
	public void setEmp_benco_app(String emp_benco_app) {
		this.emp_benco_app = emp_benco_app;
	}
	public int getApproval_id() {
		return approval_id;
	}
	public void setApproval_id(int approval_id) {
		this.approval_id = approval_id;
	}
	@Override
	public String toString() {
		return "Event_Approval [event_id=" + event_id + ", emp_supervisor_app=" + emp_supervisor_app + ", dep_head_app="
				+ dep_head_app + ", emp_benco_app=" + emp_benco_app + ", approval_id=" + approval_id + "]";
	}
	
	
}
