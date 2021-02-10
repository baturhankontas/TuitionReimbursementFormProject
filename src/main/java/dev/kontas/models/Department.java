package dev.kontas.models;

public class Department {

	private int dep_id;
	private String dep_name;
	private int head_id;
	public Department() {
		super();
	}
	public Department(String dep_name, int head_id) {
		super();
		this.dep_name = dep_name;
		this.head_id = head_id;
	}
	public Department(int dep_id, String dep_name, int head_id) {
		super();
		this.dep_id = dep_id;
		this.dep_name = dep_name;
		this.head_id = head_id;
	}
	public int getDep_id() {
		return dep_id;
	}
	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	public int getHead_id() {
		return head_id;
	}
	public void setHead_id(int head_id) {
		this.head_id = head_id;
	}
	@Override
	public String toString() {
		return "Department [dep_id=" + dep_id + ", dep_name=" + dep_name + ", head_id=" + head_id + "]";
	}
	
}
