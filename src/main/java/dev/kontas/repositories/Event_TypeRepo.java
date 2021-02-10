package dev.kontas.repositories;

import java.util.List;

import dev.kontas.models.Event_Type;

public interface Event_TypeRepo {

	public Event_Type getEType(int id);
	public boolean addEType(Event_Type a);
	public List<Event_Type> getAllEType();
	public boolean updateEType(Event_Type change);
	public boolean deleteEType(int id);


}
