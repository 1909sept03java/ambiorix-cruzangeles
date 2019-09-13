package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Cave;

public class CaveDAOImplement implements CaveDAO {

	@Override
	public List<Cave> getCaves() {
		List<Cave> cl = new ArrayList<Cave>();
		// try-with-resources... resources included in the try args will be closed
		// works with all AutoClosable resorces
		return cl;
	}

	@Override
	public Cave getCaveID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCave(Cave cave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCave(Cave cave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCave(Cave cave) {
		// TODO Auto-generated method stub
		
	}

}
