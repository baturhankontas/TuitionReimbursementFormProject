package dev.kontas.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.kontas.models.Employee;
import dev.kontas.services.EmployeeService;
import dev.kontas.services.EmployeeServiceImpl;

public class EmployeeController {

	public static EmployeeService eserv=new EmployeeServiceImpl();
	public static Gson gson=new Gson();
	
	public static void getLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String name=request.getParameter("name");
		String surname=request.getParameter("surname");
		
		HttpSession session=request.getSession();
		
		
		/*try {
		
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}*/
		
		Employee e = eserv.login(name,surname);
		
		session.setAttribute("s_id", e.getId());
		session.setAttribute("s_name", e.getName());
		session.setAttribute("s_surname", e.getSurname());
		session.setAttribute("s_mail", e.getEmail());
		session.setAttribute("s_dep_id", e.getDepartment_id());
		session.setAttribute("s_super", e.getSupervisor_id());
		session.setAttribute("s_benco", e.getBenco());
		
		response.getWriter().append((e != null) ? gson.toJson(e) : "{}");
		
	}
	public static void getUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session=request.getSession();
		Employee e=new Employee();
		e.setId((Integer)(session.getAttribute("s_id")));
		e.setName((String)(session.getAttribute("s_name")));
		e.setSurname((String)(session.getAttribute("s_surname")));
		e.setEmail((String)(session.getAttribute("s_mail")));
		e.setDepartment_id((Integer)(session.getAttribute("s_dep_id")));
		e.setSupervisor_id((Integer)(session.getAttribute("s_super")));
		e.setBenco((String)(session.getAttribute("s_benco")));
		System.out.println(e);
		response.getWriter().append((e != null) ? gson.toJson(e) : "{}");
	}
	public static void logOut(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session=request.getSession();
		session.invalidate();
	}
}
