package dev.kontas.repositories;

import java.util.List;

import dev.kontas.models.Employee;

public interface EmployeeRepository {

	public Employee getEmployee(int id);
	public boolean addEmployee(Employee a);
	public List<Employee> getAllEmployee();
	public boolean updateEmployee(Employee change);
	public boolean deleteEmployee(int id);

}
