package dev.kontas.services;

import java.util.List;
import java.util.Iterator;
import java.util.Set;

import dev.kontas.models.Tuition_Form;
import dev.kontas.repositories.Tuition_FormRepo;
import dev.kontas.repositories.Tuition_FormImplRepo;

public class Tuition_FormServiceImpl implements Tuition_FormService{

	private Tuition_FormRepo tr=new Tuition_FormImplRepo();
	@Override
	public boolean createForm(Tuition_Form f) {
		// TODO Auto-generated method stub
		return tr.addForm(f);
	}
	
	@Override
	public Tuition_Form getForm(int id) {
		// TODO Auto-generated method stub
		return tr.getForm(id) ;
	}
	@Override
	public Tuition_Form updateForm(Tuition_Form update) {
		// TODO Auto-generated method stub
		boolean result=tr.updateForm(update);
		if(result==true) {
			return update;
		}
		return null;
	}
	@Override
	public List<Tuition_Form> getAllForms(int user_id) {
		// TODO Auto-generated method stub
		
		return tr.getAllForm();
	}

	@Override
	public Tuition_Form getFormByEvent(int id) {
		// TODO Auto-generated method stub
		return tr.getFormByEvent(id);
	}
	

}
