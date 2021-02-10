package dev.kontas.services;



import java.util.ArrayList;
import java.util.List;

import dev.kontas.models.Department;
import dev.kontas.models.Employee;
import dev.kontas.models.Event;
import dev.kontas.models.Event_Approval;
import dev.kontas.models.Event_Grade;
import dev.kontas.models.Tuition_Form;
import dev.kontas.repositories.EventRepository;
import dev.kontas.repositories.EventRepositoryImpl;
import dev.kontas.repositories.Event_ApprovalImplRepo;
import dev.kontas.repositories.Event_ApprovalRepo;
import dev.kontas.repositories.Event_GradeImplRepo;
import dev.kontas.repositories.Event_GradeRepo;

public class EventServiceImpl implements EventService {

	private EventRepository er = new EventRepositoryImpl();
	private Event_GradeRepo egr=new Event_GradeImplRepo();
	private Event_ApprovalRepo ear=new Event_ApprovalImplRepo();
	public static EmployeeService eserv=new EmployeeServiceImpl();
	public static DepartmentService dserv=new DepartmentServiceImpl();
	public static Tuition_FormService tserv=new Tuition_FormServiceImpl(); 
	
	@Override
	public Event getEvent(int id) {
		// TODO Auto-generated method stub
		return er.getEvent(id);
	}
	public Event getEventReal(int id) {
		// TODO Auto-generated method stub
		return er.getEventbyReal(id);
	}
	
	
	@Override
	public Event addEvent(Event e) {
		// TODO Auto-generated method stub
		er.addEvent(e);
	
		
		return e ;
	}

	@Override
	public Event_Grade getEvent_Grade(int id) {
		// TODO Auto-generated method stub
		return egr.getGrade(id);
	}

	@Override
	public Event_Grade addEvent_Grade(Event_Grade eg) {
		// TODO Auto-generated method stub
		egr.addGrade(eg);
		int x=eg.getEvent_id();
		return getEvent_Grade(x);
	}

	@Override
	public Event_Approval addApproval(Event ea, int approver_id, String approval) {
		// TODO Auto-generated metho stub
		int event_id=ea.getEvent_id();		//event id
		int emp_id=ea.getEvent_emp_id();
		Event_Approval app=ear.getApproval(event_id);	//
		Tuition_Form f=tserv.getFormByEvent(event_id);
		
		if(approval=="Y"&& eserv.getEmployee(approver_id).getBenco()=="Y") {
			f.setStatus("APPROVED-WAITING FOR GRADE");
			Tuition_Form t= tserv.updateForm(f);
			System.out.println(t);
		}
		
		int emp=ea.getEvent_emp_id();	//employee id
		Employee e = eserv.getEmployee(emp);	//employee call
		System.out.println(e);
		int dep=e.getDepartment_id();	//get employees department
		Department d=dserv.getDepartment(dep); //get department 
		System.out.println(d+"asdas"+d.getDep_id());
		
		if(e.getSupervisor_id()==approver_id && d.getHead_id()==approver_id) {  //if approver is supervisor and dept head
			app.setEmp_supervisor_app(approval);
			app.setDep_head_app(approval);
			ear.updateApproval(app);
			System.out.println("a");
			return ear.getApproval(event_id);
		}
		else if(e.getSupervisor_id()==approver_id) {//if approver is 
			app.setEmp_supervisor_app(approval);
			ear.updateApproval(app);
			System.out.println("b");
			return ear.getApproval(event_id);
		}
		else if(eserv.getEmployee(approver_id).getBenco()=="Y") {  //if approver is benco
			app.setEmp_benco_app(approval);
			ear.updateApproval(app);
			System.out.println("c");
			return ear.getApproval(event_id);
		}
		else if(d.getHead_id()==approver_id) {//if approver is dept head
			app.setDep_head_app(approval);
			ear.updateApproval(app);
			System.out.println("d");
			return ear.getApproval(event_id);
		}
		else if( ea.getEvent_emp_id()== d.getHead_id()) {  //start from her 
			app.setEmp_supervisor_app("Y");
			app.setDep_head_app("Y");
			ear.updateApproval(app);
			System.out.println("e");
			return ear.getApproval(event_id);
		}
		
		return ear.getApproval(event_id);
	}

	@Override
	public Event_Approval getApproval(int event_id) {
		// TODO Auto-generated method stub
		return ear.getApproval(event_id);
	}

	@Override
	public boolean createApproval(int event_id) {
		// TODO Auto-generated method stub
		Event_Approval ea=new Event_Approval(event_id,"-","-","-");
		boolean result= ear.addApproval(ea);
		return result;
	}

	@Override
	public boolean createGrade(int event_id) {
		// TODO Auto-generated method stub
		Event_Grade eg= new Event_Grade(event_id,"0");
		egr.addGrade(eg);
		return false;
	}

	@Override
	public List<Event> getEvents(int id) {
		// TODO Auto-generated method stub
		List<Event> cEvents= new ArrayList<>();
		System.out.println("aLL EVENTS: "+er.getAllEvent());
		for(Event e: er.getAllEvent()) {
			if(e.getEvent_emp_id()==id) {
				cEvents.add(e);
			}
		}
		return cEvents;
	}

	@Override
	public boolean updateGrade(Event_Grade e) {
		// TODO Auto-generated method stub
		return egr.updateGrade(e);
	}

	@Override
	public boolean updateApproval(Event_Approval ea) {
		// TODO Auto-generated method stub
		return ear.updateApproval(ea);
	}
	public List<Event> getAllEvents(){
		return er.getAllEvent();
	}
	
	

}
