package dev.kontas.repositories;

import java.util.List;

import dev.kontas.models.Additional_Info;

public interface Additional_InfoRepo {

	public Additional_Info getInfo(int id);
	public boolean addInfo(Additional_Info a);
	public List<Additional_Info> getAllInfo();
	public boolean updateInfo(Additional_Info change);
	public boolean deleteInfo(int id);


}
