package dev.kontas.services;

import java.util.List;
import java.util.Set;

import dev.kontas.models.Tuition_Form;


public interface Tuition_FormService {

	public boolean createForm(Tuition_Form f);
	public Tuition_Form getForm(int id);
	public Tuition_Form updateForm(Tuition_Form update); 
	public List<Tuition_Form> getAllForms(int user_id);
	public Tuition_Form getFormByEvent(int id);
}
