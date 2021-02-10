package dev.kontas.services;

import java.util.List;

import dev.kontas.models.Event;
import dev.kontas.models.Event_Grade;
import dev.kontas.models.Event_Approval;

public interface EventService {

	public Event getEventReal(int id);
	public Event getEvent(int id) ;
	public List<Event> getAllEvents();
	public Event addEvent(Event e);
	public List<Event> getEvents(int id);
	public Event_Grade getEvent_Grade(int id);
	public Event_Grade addEvent_Grade(Event_Grade eg);
	public Event_Approval addApproval(Event ea,int approver_id, String approval);
	public Event_Approval getApproval(int approval_id);
	public boolean createApproval(int event_id);
	public boolean createGrade(int event_id);
	public boolean updateGrade(Event_Grade e);
	public boolean updateApproval(Event_Approval ea);
}
