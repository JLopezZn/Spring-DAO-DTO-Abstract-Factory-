package com.backend.db.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAOBase <T, K> {
	
	public List<T> selectAll() throws SQLException ;
	public T select(K id) throws SQLException;
	public void update(T dto) throws SQLException;
	public void insert(T dto) throws SQLException ;
	public void delete(K id) throws SQLException;

}
