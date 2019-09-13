package com.revature.dao;

import java.util.List;

import com.revature.beans.Cave;

public interface CaveDAO {

	public List<Cave> getCaves();
	public Cave getCaveID(int id);
	public void createCave(Cave cave);
	public void updateCave(Cave cave);
	public void deleteCave(Cave cave);
	
}
