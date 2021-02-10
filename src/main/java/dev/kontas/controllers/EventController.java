package dev.kontas.controllers;

import java.io.IOException;
import java.util.ArrayList;
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
import dev.kontas.models.Event_Grade;
import dev.kontas.models.Tuition_Form;
import dev.kontas.services.DepartmentService;
import dev.kontas.services.DepartmentServiceImpl;
import dev.kontas.services.EmployeeService;
import dev.kontas.services.EmployeeServiceImpl;
import dev.kontas.services.EventService;
import dev.kontas.services.EventServiceImpl;
import dev.kontas.services.Tuition_FormService;
import dev.kontas.services.Tuition_FormServiceImpl;

public class EventController {
	public static EmployeeService eserv = new EmployeeServiceImpl();
	public static EventService es = new EventServiceImpl();
	public static Gson gson = new Gson();
	public static DepartmentService dserv = new DepartmentServiceImpl();
	public static Tuition_FormService tf = new Tuition_FormServiceImpl();

	public static void addEvent(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		Event e = gson.fromJson(request.getReader(), Event.class);
		HttpSession session = request.getSession();

		System.out.println(e.toString());

		e.setEvent_emp_id((Integer) (session.getAttribute("s_id")));

		Event success = es.addEvent(e);
		Event afterAdd = es.getEvent(success.getEvent_emp_id());

		boolean approval = es.createApproval(afterAdd.getEvent_id());
		boolean grade = es.createGrade(afterAdd.getEvent_id());
		if ((Integer) (session.getAttribute("s_id")) <= 7) {
			Event_Approval manager = new Event_Approval();
			manager.setDep_head_app("Y");
			manager.setEmp_supervisor_app("Y");
			manager.setEmp_benco_app("-");
			manager.setEvent_id(afterAdd.getEvent_id());
			es.updateApproval(manager);

			/////// update approval area
		}
		System.out.println("app" + approval + "grade" + grade);
		response.getWriter().append((afterAdd != null) ? gson.toJson(e) : "{}");

	}

	public static void addGrade(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		Event_Grade eg = gson.fromJson(request.getReader(), Event_Grade.class);
		System.out.println(eg.getEvent_grade());
		int eventid =eg.getEvent_id();
		System.out.println("Added grade" + eg.toString());
		if(eg.getEvent_grade().length()==1) {
			Tuition_Form t =tf.getFormByEvent(eventid);
			t.setStatus("GRADED-WAITING BENCO FOR APPROVE ");
			tf.updateForm(t);
			
		}
		else {
			Tuition_Form t =tf.getFormByEvent(eventid);
			t.setStatus("GRADED-WAITING MANAGER FOR APPROVE");
			tf.updateForm(t);

		}

		boolean success = es.updateGrade(eg);

		response.getWriter().append((success) ? gson.toJson(eg) : "{}");

	}

	public static void getEvent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		int current_id = (Integer) (session.getAttribute("s_id"));

		System.out.println("get called");
		List<Event> e = es.getEvents(current_id);
		System.out.println(e.toString());
		for (int i = 0; i < e.size(); i++) {
			if (tf.getFormByEvent(e.get(i).getEvent_id()).getStatus() != "APPROVED-WAITING FOR GRADE") {
				e.remove(i);
			}
		}

		response.getWriter().append((e != null) ? gson.toJson(e) : "{}");
	}

	public static void addApproval(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {
		HttpSession session = request.getSession();
		int current_id = (Integer) (session.getAttribute("s_id"));
		String input = request.getParameter("event");
		String approval = request.getParameter("app");
		System.out.println(input);
		System.out.println(approval);

		int eid;
		try {
			eid = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}
		System.out.println(eid);
		Event e = es.getEventReal(eid);
		System.out.println(e.toString());

		Event_Approval success = es.addApproval(e, current_id, approval);

		response.getWriter().append((success != null) ? gson.toJson(success) : "{}");

	}

	public static void getGrade(HttpServletRequest request, HttpServletResponse response) throws IOException {

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

		Event_Grade e = es.getEvent_Grade(id);
		System.out.println(e);
		response.getWriter().append((e != null) ? gson.toJson(e) : "{}");
	}

	/// fix this
	public static void getApproval(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {
		// event id will be get
		String input = request.getParameter("event_id");
		String app = request.getParameter("app");
		System.out.println(input);
		System.out.println(app);

		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}

		Event_Approval e = es.getApproval(id);

		response.getWriter().append((e != null) ? gson.toJson(e) : "{}");
	}

	public static void seeGradesOfAll(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {
		HttpSession session = request.getSession();
		int current_user_id = ((Integer) (session.getAttribute("s_id")));
		int current_user_dept = ((Integer) (session.getAttribute("s_dep_id")));
		String benco = ((String) (session.getAttribute("s_benco")));
		Department d = dserv.getDepartment(current_user_dept);
		String current_user_dept_head = "N";
		System.out.println("CURRENT USER " + current_user_id);

		if (d.getHead_id() == current_user_id) {
			current_user_dept_head = "Y";
		}

		List<Event> visible_list = new ArrayList<>();
		List<Event> list = es.getAllEvents();
		if (benco == "Y") {
			visible_list = list;
		}
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			Event tf = list.get(i);
			Employee e = eserv.getEmployee(tf.getEvent_emp_id());

			if (e.getSupervisor_id() == current_user_id) { // if current user supervisor
				visible_list.add(list.get(i));
			} else if (e.getDepartment_id() == current_user_dept && current_user_dept_head == "Y") { // if current user
																										// is department
																										// head and same
																										// department
																										// with employee
				visible_list.add(list.get(i));
			}

		}

		response.getWriter().append((visible_list != null) ? gson.toJson(visible_list) : "{}");
	}

	public static void getMyEvent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		int current_id = (Integer) (session.getAttribute("s_id"));

		System.out.println("get called");
		List<Event> e = es.getEvents(current_id);
		System.out.println(e.toString());
		

		response.getWriter().append((e != null) ? gson.toJson(e) : "{}");
	}

}
