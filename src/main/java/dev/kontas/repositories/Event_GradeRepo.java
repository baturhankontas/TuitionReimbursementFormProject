package dev.kontas.repositories;

import java.util.List;

import dev.kontas.models.Event_Grade;

public interface Event_GradeRepo {
	
	public Event_Grade getGrade(int id);
	public boolean addGrade(Event_Grade a);
	public List<Event_Grade> getAllGrade();
	public boolean updateGrade(Event_Grade change);
	public boolean deleteGrade(int id);


}
