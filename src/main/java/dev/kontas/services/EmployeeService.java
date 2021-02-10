package dev.kontas.services;

import dev.kontas.models.Employee;

public interface EmployeeService {

	Employee login(String name, String surname);
	Employee getEmployee(int id);
}
