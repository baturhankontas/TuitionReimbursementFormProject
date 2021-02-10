package dev.kontas.models;

public class Additional_Info {

	private int form_id;
	private String add_info;
	private int creater_id;
	private int emp_id;
	public Additional_Info() {
		super();
	}
	public Additional_Info(String add_info, int creater_id, int emp_id) {
		super();
		this.add_info = add_info;
		this.creater_id = creater_id;
		this.emp_id = emp_id;
	}
	public Additional_Info(int form_id, String add_info, int creater_id, int emp_id) {
		super();
		this.form_id = form_id;
		this.add_info = add_info;
		this.creater_id = creater_id;
		this.emp_id = emp_id;
	}
	public int getForm_id() {
		return form_id;
	}
	public void setForm_id(int form_id) {
		this.form_id = form_id;
	}
	public String getAdd_info() {
		return add_info;
	}
	public void setAdd_info(String add_info) {
		this.add_info = add_info;
	}
	public int getCreater_id() {
		return creater_id;
	}
	public void setCreater_id(int creater_id) {
		this.creater_id = creater_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	@Override
	public String toString() {
		return "Additional_Info [form_id=" + form_id + ", add_info=" + add_info + ", creater_id=" + creater_id
				+ ", emp_id=" + emp_id + "]";
	}
	
	
}
