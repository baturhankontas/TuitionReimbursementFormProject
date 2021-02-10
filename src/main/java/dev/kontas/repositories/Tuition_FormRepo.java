package dev.kontas.repositories;

import java.sql.SQLException;
import java.util.List;

import dev.kontas.models.Tuition_Form;

public interface Tuition_FormRepo {
	
	public Tuition_Form getForm(int id);
	public Tuition_Form getForm(String name);
	public List<Tuition_Form> getAllForm();
	public boolean addForm(Tuition_Form a);
	public boolean updateForm(Tuition_Form change);
	public boolean deleteForm(int id);
	public Tuition_Form getFormByEvent(int id);
}


