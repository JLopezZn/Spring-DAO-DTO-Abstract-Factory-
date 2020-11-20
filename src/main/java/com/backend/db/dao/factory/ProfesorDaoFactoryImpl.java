package com.backend.db.dao.factory;

import com.backend.db.dao.IProfesorDAO;
import com.backend.db.dao.ProfesorDAO;

public class ProfesorDaoFactoryImpl implements ProfesorDaoFactory {
	
	private static ProfesorDaoFactoryImpl instance;

	private ProfesorDaoFactoryImpl() {
	}

	public static ProfesorDaoFactoryImpl getInstance() {
		if (instance == null)
			instance = new ProfesorDaoFactoryImpl();
		return instance;
	}
	@Override
	public IProfesorDAO objeto() {
		return new ProfesorDAO();
	}

}
