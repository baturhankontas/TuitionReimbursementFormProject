package dev.kontas.repositories;

import java.util.List;

import dev.kontas.models.Department;

public interface DepartmentRepository {

	public Department getDepartment(int id);
	public boolean addDepartment(Department a);
	public List<Department> getAllDepartment();
	public boolean updateDepartment(Department change);
	public boolean deleteDepartment(int id);


}
