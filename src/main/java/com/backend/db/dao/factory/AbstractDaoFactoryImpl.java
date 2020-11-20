package com.backend.db.dao.factory;

public class AbstractDaoFactoryImpl implements AbstractDaoFactory{

	private static AbstractDaoFactoryImpl instance;
	private AbstractDaoFactoryImpl() {
		
	}
	
	public static AbstractDaoFactoryImpl getInstance() {
		if(instance==null)
			instance = new AbstractDaoFactoryImpl();
		return instance;
	}
	@Override
	public AlumnoDaoFactory getAlumoFactory() {
		return AlumnoDaoFactoryImpl.getInstance();
	}

	@Override
	public ProfesorDaoFactoryImpl getProfesorFactory() {
		return ProfesorDaoFactoryImpl.getInstance();
	}

}
