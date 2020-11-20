package com.backend.db.dao.factory;

import com.backend.db.dao.AlumnoDAO;
import com.backend.db.dao.IAlumnoDAO;

public class AlumnoDaoFactoryImpl implements AlumnoDaoFactory {

	private static AlumnoDaoFactoryImpl instance;

	private AlumnoDaoFactoryImpl() {
	}

	@Override
	public IAlumnoDAO objeto() {
		return new AlumnoDAO();
	}

	public static AlumnoDaoFactoryImpl getInstance() {
		if (instance == null)
			instance = new AlumnoDaoFactoryImpl();
		return instance;
	}

}
