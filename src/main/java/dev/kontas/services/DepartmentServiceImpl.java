package dev.kontas.services;

import dev.kontas.models.Department;
import dev.kontas.repositories.DepartmentRepository;
import dev.kontas.repositories.DepartmentRepositoryImpl;

public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository dep= new DepartmentRepositoryImpl();
	@Override
	public Department getDepartment(int id) {
		// TODO Auto-generated method stub
		return dep.getDepartment(id);
	}

}
