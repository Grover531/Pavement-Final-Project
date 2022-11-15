package com.pavement.dao;

import java.util.List;

import com.pavement.model.Renter;

public interface RenterDAO {
	public int save(Renter renter);
	
	public int update(Renter renter);
	
	public Renter get(Integer id);
	
	public int delete(Integer id);
	
	public List<Renter> list();
}
