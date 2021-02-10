package dev.kontas.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import dev.kontas.models.Department;
import dev.kontas.models.Employee;
import dev.kontas.models.Event;
import dev.kontas.models.Event_Approval;
import dev.kontas.models.Tuition_Form;
import dev.kontas.services.DepartmentService;
import dev.kontas.services.DepartmentServiceImpl;
import dev.kontas.services.EmployeeService;
import dev.kontas.services.EmployeeServiceImpl;
import dev.kontas.services.EventService;
import dev.kontas.services.EventServiceImpl;
import dev.kontas.services.Tuition_FormService;
import dev.kontas.services.Tuition_FormServiceImpl;

public class Tuition_FormController {

	public static Tuition_FormService tserv = new Tuition_FormServiceImpl();
	public static EmployeeService eserv = new EmployeeServiceImpl();
	public static DepartmentService dserv = new DepartmentServiceImpl();
	public static EventService eventserv = new EventServiceImpl();
	public static Gson gson = new Gson();

	public static void createForm(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		Tuition_Form t = gson.fromJson(request.getReader(), Tuition_Form.class);
		HttpSession session = request.getSession();
		t.setEmp_id((Integer) (session.getAttribute("s_id")));

		Event event = eventserv.getEvent(t.getEmp_id());
		t.setEvent_id(event.getEvent_id());
		System.out.println(t.toString());

		boolean success = tserv.createForm(t);
		System.out.println(success);
		System.out.println("created form");
		// Most common practice is to send back the added Object
		// Just in case the Client wants to use it again.
		response.getWriter().append((success) ? gson.toJson(t) : "{}");

	}

	public static void getAllForms(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int current_user_id = ((Integer) (session.getAttribute("s_id"))); // current user
		int current_user_dept = ((Integer) (session.getAttribute("s_dep_id"))); // current user dept
		String benco = ((String) (session.getAttribute("s_benco"))); // current benco
		Department d = dserv.getDepartment(current_user_dept);
		String current_user_dept_head = "N"; //
		System.out.println("CURRENT USER " + current_user_id);
		if (d.getHead_id() == current_user_id) {
			current_user_dept_head = "Y"; // current user dept head
		}
		System.out.println(current_user_dept_head);
		System.out.println();

		List<Tuition_Form> dhList = new ArrayList<>();
		List<Tuition_Form> bencoList = new ArrayList<>();
		List<Tuition_Form> visible_list = new ArrayList<>();
		List<Tuition_Form> list = tserv.getAllForms(current_user_id);
		// System.out.println(list);
		if (benco.equals("Y")) {
			for (int i = 0; i < list.size(); i++) {
				Tuition_Form form = list.get(i);
				int id = form.getEvent_id();
				if (((eventserv.getApproval(id)).getDep_head_app()).equals("Y")
						&& ((eventserv.getApproval(id)).getEmp_supervisor_app()).equals("Y")) {
					bencoList.add(list.get(i));
				}

			}
			response.getWriter().append((bencoList != null) ? gson.toJson(bencoList) : "{}");

		} else if (current_user_dept_head.equals("Y")) {
			for (int i = 0; i < list.size(); i++) {
				Tuition_Form form = list.get(i);
				Employee f = eserv.getEmployee(form.getEmp_id());
				if (current_user_id == f.getSupervisor_id() && (eventserv.getApproval((list.get(i)).getEvent_id())).getEmp_supervisor_app().equals("-")/*
															 * ||(eventserv.getApproval((list.get(i)).getEvent_id())).
															 * getEmp_supervisor_app().equals("N")
															 */) {
					dhList.add(list.get(i));
				}
				if ((eventserv.getApproval((list.get(i)).getEvent_id())).getEmp_supervisor_app().equals("Y")&&(eventserv.getApproval((list.get(i)).getEvent_id())).getDep_head_app().equals("-")) {
					dhList.add(list.get(i));
				}
			}
			response.getWriter().append((dhList != null) ? gson.toJson(dhList) : "{}");
		}

		else if (current_user_dept_head.equals("N") && benco.equals("N")) {
			for (int i = 0; i < list.size(); i++) {
				Tuition_Form tf = list.get(i);
				Employee e = eserv.getEmployee(tf.getEmp_id());
				if (current_user_id == e.getSupervisor_id()
						&& (eventserv.getApproval((list.get(i)).getEvent_id())).getEmp_supervisor_app().equals("-")) {
					visible_list.add(list.get(i));
				}
			}
			response.getWriter().append((visible_list != null) ? gson.toJson(visible_list) : "{}");
		}

	}

	public static void addNewComment(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Tuition_Form form = gson.fromJson(request.getReader(), Tuition_Form.class);
		int id = form.getForm_id() - 31;
		System.out.println(form.getForm_id());
		System.out.println(form.getNotes());
		Tuition_Form t = tserv.getForm(id);
		t.setNotes(form.getNotes());
		t.setStatus(form.getStatus());
		tserv.updateForm(t);

		response.getWriter().append((t != null) ? gson.toJson(t) : "{}");

	}

	public static void addtoOldComment(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Tuition_Form form = gson.fromJson(request.getReader(), Tuition_Form.class);
		int id = form.getForm_id();
		id = id - 31;
		System.out.println(id);
		System.out.println(form.getNotes());

		Tuition_Form t = tserv.getForm(id);
		String newForm = form.getNotes() + " " + t.getNotes();
		t.setNotes(newForm);
		t.setStatus(form.getStatus());
		tserv.updateForm(t);

		response.getWriter().append((t != null) ? gson.toJson(t) : "{}");

	}

	public static void seeApproves(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		String input = request.getParameter("id");

		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}
		System.out.println(id);
		// Tuition_Form t = eventserv.getEvent_Grade(id);
		Event_Approval e = eventserv.getApproval((id));
		System.out.println(e);
		response.getWriter().append((e != null) ? gson.toJson(e) : "{}");
	}

	public static void getForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		String input = request.getParameter("id");

		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}

		Tuition_Form t = tserv.getForm(id);

		response.getWriter().append((t != null) ? gson.toJson(t) : "{}");
	}

	public static void updateForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		Tuition_Form t = gson.fromJson(request.getReader(), Tuition_Form.class);

		// Call the appropriate Service for adding Actors
		Tuition_Form success = tserv.updateForm(t);

		// Most common practice is to send back the added Object
		// Just in case the Client wants to use it again.
		response.getWriter().append((success != null) ? gson.toJson(t) : "{}");

	}

	public static void addApprove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String input = request.getParameter("id");
		int id;
		HttpSession session = request.getSession();
		int c_id = ((Integer) (session.getAttribute("s_id")));
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}

		Tuition_Form t = tserv.getFormByEvent(id);
		t.setStatus("SUCCESFULLY COMPLETED");
		tserv.updateForm(t);

	}
}
