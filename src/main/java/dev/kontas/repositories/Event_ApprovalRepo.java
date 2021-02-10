package dev.kontas.repositories;

import java.util.List;

import dev.kontas.models.Event_Approval;

public interface Event_ApprovalRepo {

	public Event_Approval getApproval(int id);
	public boolean addApproval(Event_Approval a);
	public List<Event_Approval> getAllActors();
	public boolean updateApproval(Event_Approval change);
	public boolean deleteApproval(int id);


}
