package com.backend.db.dao.factory;

public interface AbstractDaoFactory {
	
	AlumnoDaoFactory getAlumoFactory();
	ProfesorDaoFactory getProfesorFactory();
}
