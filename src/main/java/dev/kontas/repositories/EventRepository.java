package dev.kontas.repositories;

import java.sql.SQLException;
import java.util.List;

import dev.kontas.models.Event;

public interface EventRepository {
	public Event getEventbyReal(int id);
	public Event getEvent(int id);
	public boolean addEvent(Event a);
	public List<Event> getAllEvent();
	public boolean updateEvent(Event change);
	public boolean deleteEvent(int id);


}
