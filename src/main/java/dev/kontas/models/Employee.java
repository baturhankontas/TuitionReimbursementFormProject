package dev.kontas.models;

public class Employee {
	
	private int id;
	private String name;
	private String surname;
	private String email;
	private int department_id;
	private int supervisor_id;
	private String benco;
	
	public Employee(int id, String name, String surname, String email, int department_id, int supervisor_id,
			String benco) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.department_id = department_id;
		this.supervisor_id = supervisor_id;
		this.benco = benco;
	}

	public Employee(String name, String surname, String email, int department_id, int supervisor_id, String benco) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.department_id = department_id;
		this.supervisor_id = supervisor_id;
		this.benco = benco;
	}

	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public int getSupervisor_id() {
		return supervisor_id;
	}

	public void setSupervisor_id(int supervisor_id) {
		this.supervisor_id = supervisor_id;
	}

	public String getBenco() {
		return benco;
	}

	public void setBenco(String benco) {
		this.benco = benco;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email
				+ ", department_id=" + department_id + ", supervisor_id=" + supervisor_id + ", benco=" + benco + "]";
	}
	
	
	
	
}
