package dev.kontas.services;

import dev.kontas.models.Employee;
import dev.kontas.repositories.EmployeeRepository;
import dev.kontas.repositories.EmployeeRepositoryImpl;
public class EmployeeServiceImpl implements EmployeeService {

	private static EmployeeRepository erepo= new EmployeeRepositoryImpl();
	@Override
	public Employee login(String name, String surname) {
		// TODO Auto-generated method stub
		for (Employee u : erepo.getAllEmployee()) {
			if (u.getName().equals(name)) {
				if (u.getSurname().equals(surname)) {
					return u;
				} else {
					System.out.println("Wrong Identity");
				}
			}

		}

		return null;
	}
	public Employee getEmployee(int id) {
		
		return erepo.getEmployee(id);
	}


}
